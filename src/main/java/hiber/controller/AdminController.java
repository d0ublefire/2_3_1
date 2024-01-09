package hiber.controller;

import hiber.model.Role;
import hiber.model.User;
import hiber.service.RoleService;
import hiber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
//@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping ("/users")
    public String getAllUsers(ModelMap model, Principal principal) {
            User user = userService.findByUserEmail(principal.getName());
            model.addAttribute("user", user);
            List<User> listOfUsers = userService.listUsers();
            model.addAttribute("users", listOfUsers);
            System.out.println(listOfUsers);
            return "users";
    }

    @GetMapping("/new")
    public String createUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute("users", user);
        Collection<Role> roles = roleService.getRoles();
        model.addAttribute("roles", roles);
        return "userCreate";
    }

    @PostMapping("/userCreate")
    public String addUser(@ModelAttribute("users") User user, ModelMap model) {
        model.addAttribute("roles", roleService.getRoles());
//        model.addAttribute("selectedRoles", user.getRoles());
        userService.addUser(user);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        userService.updateUser(user);

        return "redirect:/users";
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam("id") long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") long id) {
        model.addAttribute("users", userService.getUser(id));
        model.addAttribute("roles", roleService.getRoles());
        return "userUpdate";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("users") User user, Model model) {
        model.addAttribute("roles", roleService.getRoles());
        userService.updateUser(user);
        return "redirect:/users";
    }
}


