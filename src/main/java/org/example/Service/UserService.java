package org.example.Service;

import org.example.SpringData.UserRepo;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService   {


    @Autowired
    private UserRepo userRepo;

    public User add(User user){
        return userRepo.save(user);
    }


    public List<User> bringAll () {
     return userRepo.findAll();
    }

    Optional<User> findById(long id) {
        User user = new User();
        if (user.getId() <= 5) {
            return Optional.of((User) userRepo.findById(id).get());

        } else
            return Optional.empty();

    }
}
