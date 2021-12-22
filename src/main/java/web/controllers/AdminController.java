package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.RoleService;
import web.Service.UserService;
import web.models.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", new User());
        return "new";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles") String [] nameRoles,
                             @PathVariable(value = "id") long id) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles") String [] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles",roleService.getAllRoles());
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @GetMapping(value = "user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }



}
