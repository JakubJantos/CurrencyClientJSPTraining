package pl.sda.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServices {

    private final UserRepisitory userRepisitory;

    public UserServices(UserRepisitory userRepisitory) {
        this.userRepisitory = userRepisitory;
    }

    public boolean createUser(String email, String paswd, LocalDate date) {
        boolean isEmialUnique = userRepisitory.findAll().stream()
                .anyMatch(u->u.getEmail().equals(email));
        if (isEmialUnique){
            throw new RuntimeException("email in use");
        }

        User user = new User(email,paswd,date);
        User created = userRepisitory.save(user);

        return created.getId() != null;
    }

    public List<User> findAll() {
        return userRepisitory.findAll();
    }

    public void delete(long userId) {
        User user = userRepisitory.findById(userId)
         .orElseThrow(()->new RuntimeException("User not found"));
         userRepisitory.delete(user);
    }
}
