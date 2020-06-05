package com.miage.library.controller;

import com.miage.library.domain.User;
import com.miage.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());

        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String profilePost(@ModelAttribute("user") User newUser, Model model) {
        User user = userService.findByUsername(newUser.getUsername());
        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        //user.setRoles(newUser.getRoles());

        model.addAttribute("user", user);

        userService.saveUser(user);

        return "profile";
    }




    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String profile(Model model, @ModelAttribute("username") String username) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user/edit";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute("username") String username) {
        userService.remove(username);
        return "redirect:/user/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        List<User> user = userService.findUserList();
        model.addAttribute("users", user);


        return "user/list";
    }


}

