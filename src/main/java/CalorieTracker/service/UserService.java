package CalorieTracker.service;

import CalorieTracker.entity.User;
import CalorieTracker.errors.CustomException;
import CalorieTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {

        User _user = userRepository.findById(id).orElseThrow(() -> new CustomException("User not found"));
        _user.setUserName(user.getUserName());
        _user.setDateOfBirth(user.getDateOfBirth());
        _user.setHeight(user.getHeight());
        _user.setWeight(user.getWeight());
        _user.setProfileImgUrl(user.getProfileImgUrl());
        return userRepository.save(_user);

    }
}

