package com.example.week04.repository;

import com.example.week04.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReopository extends JpaRepository<User, Long> {


    Optional<User> findBynickname(String nickname);

    void findAllBynickname(String nickname);

    Optional<User> findByUsername(String username);
}
