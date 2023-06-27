package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String getTest() {
        return "test";
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String getNewUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "users/add")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "users/edit/{id}")
    public String getNewUserData(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("users/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "show";
    }

}