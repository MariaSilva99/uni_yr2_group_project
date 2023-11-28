package com.g12cs.stfundraiser.service;

import java.util.List;

import com.g12cs.stfundraiser.models.User;
import com.g12cs.stfundraiser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {


    //Simple Springboot service that allows easy access and editing of users table on the database
    //utilises the UserRepository which is a JPA handled repository for writing and fetching from DB

    @Autowired

    private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(int id) { return repo.findById(id); }

    public void delete(int id) {
        repo.deleteById(id);
    }

    //The specific line used in RegisterController to save user data to DB
    public void save(User user) {
        repo.save(user);
    }

    

}