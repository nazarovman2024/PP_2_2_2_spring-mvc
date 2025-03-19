package web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/users/add")
    public String saveUserController(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        User user = new User(firstName, lastName);
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String getUsersController(
            @RequestParam(value = "count", defaultValue = "10") int count, Model model
    ) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getUsers(count));
        return "users";
    }

    @GetMapping(value = "/users/edit")
    public String editUserController(
            @RequestParam(value = "id", defaultValue = "0") long id, Model model
    ) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/users/edit/apply")
    public String applyEditUserController(
            @RequestParam("id") long id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        User user = userService.getUser(id);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userService.update(user);
        }

        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUserController(
            @RequestParam("id") long id
    ) {
        userService.delete(id);
        return "redirect:/users";
    }

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }
}
