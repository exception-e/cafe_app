package ru.choosecafe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.choosecafe.model.Vote;
import ru.choosecafe.service.VoteService;
import ru.choosecafe.to.VoteTo;
import ru.choosecafe.util.SecurityUtil;
import ru.choosecafe.util.exception.IllegalRequestDataException;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "rest";

    @Autowired
    VoteService voteService;

    @GetMapping(value = "/admin/votes")
    public List<Vote> getAll() {
        return voteService.getAll();
    }

    @GetMapping(value = "/admin/vote/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote get(@PathVariable("id") int id) {
        return voteService.get(id);
    }

    @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createWithLocation(@RequestBody VoteTo voteTo) {


        if(voteService.getByDateAndUser(SecurityUtil.authUserId(), LocalDate.now()) != null
        &&
        (LocalTime.now().isAfter(LocalTime.of(11, 00)))){

            throw new IllegalRequestDataException("You have already voted today");
        }

        Vote newVote = new Vote();

        Vote created = voteService.create(newVote, SecurityUtil.authUserId(), voteTo.getRestaurantId());

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uriOfNewResource);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/vote/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/admin/vote/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        voteService.delete(id);
    }

//    @PutMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void update(@RequestBody Vote  vote) {
//        //assureIdConsistent(vote, id);
//        if(LocalTime.now().isBefore(LocalTime.of(11, 00))) {
//            voteService.update(vote, SecurityUtil.authUserId());
//        }
//    }

    @GetMapping(value = "/admin/votes/count-by-restaurant-and_date", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer countByRestaurantAndDate(@RequestParam("id") Integer id, @RequestParam("date")LocalDate date){
        return voteService.countByRestaurantAndDate(id, date);
    }

    @GetMapping(value = "/admin/votes/count-by-restaurant-today", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer countByRestaurantToday(@RequestParam("id") Integer id){
        return voteService.countByRestaurantAndDate(id, LocalDate.now());
    }

    @GetMapping(value = "/admin/votes/winner-by-date", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getWinnerRestaurantByDate(@RequestParam("date")LocalDate date){
        return voteService.getWinnerRestaurantByDate(date);
    }

    @GetMapping(value = "/admin/votes/today_winner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getTodayWinnerRestaurant(){
        return voteService.getWinnerRestaurantByDate(LocalDate.now());
    }
}