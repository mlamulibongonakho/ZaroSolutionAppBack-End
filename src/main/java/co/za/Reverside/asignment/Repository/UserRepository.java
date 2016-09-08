package co.za.Reverside.asignment.Repository;


import co.za.Reverside.asignment.Domain.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tha on 2016/09/01.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    @Override
    List<User> findAll();

    User findByEmail(String email);

}
