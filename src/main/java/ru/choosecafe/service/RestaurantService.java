package ru.choosecafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.choosecafe.AuthorizedUser;
import ru.choosecafe.Profiles;
import ru.choosecafe.model.AbstractBaseEntity;
import ru.choosecafe.model.Restaurant;
import ru.choosecafe.model.User;
import ru.choosecafe.repository.RestaurantDataRepository;
import ru.choosecafe.repository.RestaurantRepository;
import ru.choosecafe.repository.UserDataRepository;
import ru.choosecafe.to.UserTo;
import ru.choosecafe.util.UsersUtil;
import ru.choosecafe.util.exception.UpdateRestrictionException;

import java.util.List;

import static ru.choosecafe.util.UsersUtil.prepareToSave;
import static ru.choosecafe.util.validation.ValidationUtil.checkNotFound;
import static ru.choosecafe.util.validation.ValidationUtil.checkNotFoundWithId;

@Service("restaurantService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RestaurantService {

    private final RestaurantDataRepository repository;

    public RestaurantService(RestaurantDataRepository repository) {
        this.repository = repository;
    }

    public Restaurant create(Restaurant r) {
        return repository.save(r);
    }

    public Restaurant update(Restaurant r) {
        return repository.save(r);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}