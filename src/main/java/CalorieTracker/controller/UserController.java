package CalorieTracker.controller;

import CalorieTracker.entity.User;
import CalorieTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")

    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()){
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping ("/update/{id}")

    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()){
            User _user = userData.get();
            _user.setUserName(user.getUserName());
            _user.setDateOfBirth(user.getDateOfBirth());
            _user.setHeight(user.getHeight());
            _user.setWeight(user.getWeight());
            _user.setProfileImgUrl(user.getProfileImgUrl());

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
