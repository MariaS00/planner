package com.example.planner.service;

import com.example.planner.model.User;
import com.example.planner.repository.UserRepository;
import com.example.planner.service.dto.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String name){
        User user = new User(name);
        if (userRepository)
        System.out.println("User created: " + user.toString());
        userRepository.save(user);
    }

    public void removeUser(UUID userId){
        User user = userRepository.findByUserId(userId);
        userRepository.delete(user);
    }

    public List<UserView> getUsers(){
        return userRepository.findAll().stream().map(User::toView).collect(Collectors.toList());
    }


}
