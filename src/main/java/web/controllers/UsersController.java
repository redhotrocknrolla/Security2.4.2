package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UsersDAO;
import web.models.User;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDAO.show(id));
        return "users/show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        usersDAO.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id) {
        model.addAttribute("user",usersDAO.show(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id")int id) {
        usersDAO.update(id,user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id) {
        usersDAO.delete(id);
        return "redirect:/users";

    }
}
