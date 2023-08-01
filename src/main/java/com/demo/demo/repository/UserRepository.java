package com.demo.demo.repository;

import com.demo.demo.domain.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsernameAndPassword(String username, String password);
}
