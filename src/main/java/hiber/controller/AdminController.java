package hiber.controller;

import hiber.model.Role;
import hiber.model.User;
import hiber.service.RoleService;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
//@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/showAccount")
    public ResponseEntity<User> showInfoUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<Collection<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Collection<Role>> getRole(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserById(id).getRoles(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<User> show(@PathVariable("id") Integer id) {
//        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
//    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User newUser, BindingResult bindingResult) {
        userService.saveUser(newUser);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userService.updateUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);

    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User userFromWebPage, @PathVariable("id") Long id) {
        userService.updateUser(userFromWebPage);
        return new ResponseEntity<>(userFromWebPage, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @PostMapping("/userCreate")
//    public String addUser(@ModelAttribute("user") User user, @RequestParam(value = "role", required = false) String[] roles) {
//
//        userService.getUserAndRoles(user, roles);
//        userService.getNotNullRole(user);
//        userService.saveUser(user);
//
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/removeUser")
//    public String removeUser(@RequestParam("id") Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/users";
//    }
//
//
//
//    @PostMapping("/updateUser")
//    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role", required = false) String[] roles) {
//        userService.getUserAndRoles(user, roles);
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
}


