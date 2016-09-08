package co.za.Reverside.asignment.Services;

import co.za.Reverside.asignment.Domain.User;

import java.util.List;

/**
 * Created by tha on 2016/09/01.
 */
public interface UserService {

    List<User> findAll();

    void save(User user);

    User findByEmail(String email);

    User findOne(Long userId);

//    User login(String email);

    void update(User user);



}
