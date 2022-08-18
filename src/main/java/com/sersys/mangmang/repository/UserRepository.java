package com.sersys.mangmang.repository;

import com.sersys.mangmang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    UserDetails findUserByUsername(String username);

}
