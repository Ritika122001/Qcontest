package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;
import com.crio.qcontest.repositories.UserRepository;


public class UserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of createUser method
    // Implementation must take care of the following cases:-
    // 1) Create and store user in the repository.

    public User createUser(String name) {

        UserRepository userRepository = new UserRepository();
        User user = new User(name);
        return userRepository.save(user);

    //  return null;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of getAllUser method
    // Implementation must take care of the following cases:-
    // 1) Get all the users in ascending Order w.r.t score.
    // 2) Get all the users in descending Order w.r.t score.
    
    public List<User> getUsers(UserOrder userOrder) {
      List<User> users = userRepository.findAll();

      if(userOrder == UserOrder.SCORE_ASC) {
        users = users.stream().sorted((user1, user2) -> user1.getTotalScore().compareTo(user2.getTotalScore()))
                .collect(Collectors.toList());
    } else if(userOrder == UserOrder.SCORE_DESC) {
        users = users.stream().sorted((user1, user2) -> user2.getTotalScore().compareTo(user1.getTotalScore()))
                .collect(Collectors.toList());
    }
    
    return users;
    
       

    } 

  }

