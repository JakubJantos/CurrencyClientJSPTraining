package pl.sda.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class UsersControler {

    private UserServices userServices;

    public UsersControler(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/users")
    public String users() {
        return "user/users";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String email,
                          @RequestParam String paswd,
                          @RequestParam String date, Model model) {

        try {

            LocalDate dob = LocalDate.parse(date);

            boolean res = userServices.createUser(email, paswd, dob);
            model.addAttribute("res", res);
            List<User> users = userServices.findAll();
            model.addAttribute("users", users);

            return "user/list";
        }catch (Exception e){
            model.addAttribute("errorMsg", e.getLocalizedMessage());
            return "user/users";
        }
    }

    @GetMapping("/users/delete")
    public String deleteUsers(@RequestParam long userId, Model model){
        userServices.delete(userId);
        model.addAttribute("users", userServices.findAll());
        model.addAttribute("deleteUsersResuld", true);

        return "user/list";
    }

    @GetMapping("users/list")
    public String usersList(Model model){
        model.addAttribute("users", userServices.findAll());

        return "user/list";

    }
}
