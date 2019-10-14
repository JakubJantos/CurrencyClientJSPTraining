package pl.sda.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepisitory extends CrudRepository<User, Long> {

    List<User> findAll();
}
