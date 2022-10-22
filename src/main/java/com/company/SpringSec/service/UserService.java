package com.company.SpringSec.service;

import com.company.SpringSec.dto.UserDto;
import com.company.SpringSec.dto.converter.UserToUserDtoConverter;
import com.company.SpringSec.dto.request.CreateUserRequest;
import com.company.SpringSec.model.User;
import com.company.SpringSec.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repository;
  private final UserToUserDtoConverter converter;


    public UserService(UserRepository repository, UserToUserDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public UserDto createUser(CreateUserRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        checkUserAlreadyExistOrNot(request.getPin());
        User user = new User()
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setAddress(request.getAddress())
                .setPin(request.getPin())
                .setPassword(passwordEncoder.encode(request.getPassword()));
        return converter.convert(repository.save(user));
    }

    public List<UserDto> findAllUsers(){
        return converter.convert(repository.findAll());
    }

    public User findUserByPin(String pin){
        return repository.findByPin(pin)
                .orElseThrow(()->new RuntimeException("User couldn't be found by following pin: "+pin));
    }

    protected User findUserById(String userId){
        return repository.findById(userId)
                .orElseThrow(()->new RuntimeException("User couldn't be found by following userId: "+userId));
    }

    private void checkUserAlreadyExistOrNot(String pin){
        Optional<User> user = repository.findByPin(pin);
        user.ifPresent(user1 -> {throw new RuntimeException("User Already Exist");});
    }
}
