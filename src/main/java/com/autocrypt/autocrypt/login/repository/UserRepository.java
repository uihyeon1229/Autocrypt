package com.autocrypt.autocrypt.login.repository;

import com.autocrypt.autocrypt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByNickname(String nickname);
}
