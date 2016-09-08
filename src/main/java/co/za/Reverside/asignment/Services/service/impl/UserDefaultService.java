package co.za.Reverside.asignment.Services.service.impl;

import co.za.Reverside.asignment.DTO.UserDTO;
import co.za.Reverside.asignment.Repository.UserRepository;
import co.za.Reverside.asignment.Services.UserService;
import co.za.Reverside.asignment.Domain.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tha on 2016/09/01.
 */
@Service
public class UserDefaultService implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void save(User  user)
    {
            userRepository.save(user);
    }
    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    @Override
    public User findOne(Long userId)
    {
        return userRepository.findOne(userId);
    }

    @Override
    public void update(User user1)
    {
        userRepository.save(user1);

    }

}
