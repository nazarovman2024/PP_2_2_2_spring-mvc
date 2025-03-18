package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public String listUsers(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<User> users = userService.subUsers(count);
        model.addAttribute("users", users);
        return "users";
    }

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }
}
