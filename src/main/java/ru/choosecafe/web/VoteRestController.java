package ru.choosecafe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.choosecafe.model.Vote;
import ru.choosecafe.repository.VoteDataRepository;
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
    private final Logger log = LoggerFactory.getLogger(getClass());
    static final String REST_URL = "rest";

    @Autowired
    VoteDataRepository voteDataRepository;

    @GetMapping(value = "/admin/votes")
    public List<Vote> getAll() {
        log.info("getAll");
        return voteDataRepository.getAll();
    }

    @GetMapping(value = "/admin/vote/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote get(@PathVariable("id") int id) {
        log.info("get {}", id);
        return voteDataRepository.get(id);
    }

    @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createWithLocation(@RequestBody VoteTo voteTo) {
        log.info("create {}", voteTo);

        if(voteDataRepository.getByDateAndUser(SecurityUtil.authUserId(), LocalDate.now()) != null
        &&
        (LocalTime.now().isAfter(LocalTime.of(11, 00)))){

            throw new IllegalRequestDataException("You have already voted today");
        }

        Vote newVote = new Vote();

        Vote created = voteDataRepository.save(newVote, SecurityUtil.authUserId(), voteTo.getRestaurantId());

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/vote/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/admin/vote/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        log.info("delete {}", id);
        voteDataRepository.delete(id);
    }


    @GetMapping(value = "/admin/votes/count-by-restaurant-and_date", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer countByRestaurantAndDate(@RequestParam("id") Integer id, @RequestParam("date")LocalDate date){
        log.info("countByRestaurantAndDate {}, {}", id, date);
        return voteDataRepository.countByRestaurantAndDate(id, date);
    }

    @GetMapping(value = "/admin/votes/count-by-restaurant-today", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer countByRestaurantToday(@RequestParam("id") Integer id){
        log.info("countByRestaurantToday {}", id);
        return voteDataRepository.countByRestaurantAndDate(id, LocalDate.now());
    }

    @GetMapping(value = "/admin/votes/winner-by-date", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getWinnerRestaurantByDate(@RequestParam("date")LocalDate date){
        log.info("winnerRestaurantByDate {}", date);
        return voteDataRepository.getWinnerRestaurantByDate(date);
    }

    @GetMapping(value = "/votes/today_winner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getTodayWinnerRestaurant(){
        log.info("countByRestaurantToday");
        return voteDataRepository.getWinnerRestaurantByDate(LocalDate.now());
    }
}