package com.company.SpringSec.repository;

import com.company.SpringSec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByPin(String pin);
    Optional<User> findByPassword(String password);
}
