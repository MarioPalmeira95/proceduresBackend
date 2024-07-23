package com.procedures.demo.user;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add", method=RequestMethod.POST)  
    public @ResponseBody String addUser(@RequestBody User body ) {
        User user = new User();
        user.setName(body.getName());
        user.setLastname(body.getLastname());
        user.setPassword(body.getPassword());
        userRepository.save(user);

        return "saved";
    }

    @GetMapping("/find/{id}")
    public @ResponseBody Optional<User> getById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
