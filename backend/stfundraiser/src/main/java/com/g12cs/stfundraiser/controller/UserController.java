package com.g12cs.stfundraiser.controller;
import com.g12cs.stfundraiser.repository.UserRepository;
import com.g12cs.stfundraiser.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable(value ="id")int id){
        return userRepository.findById(id);
    }

    @GetMapping("/users/name=/{username}")
    public User getByUsername(@PathVariable(value ="username") String username){
        return  userRepository.findByUsername(username);
    }

    @GetMapping("/users/role=/{role}")
    public List<User> getByRole(@PathVariable(value = "role")String role){
        return userRepository.findByRole(role);
    }

    @PostMapping("/users/")
    public User addUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }



}
