package com.demo.demo.service;

import java.util.Optional;

import com.demo.demo.domain.Users;
import com.demo.demo.dto.UsersDTO;

public interface UserService {

    Optional<UsersDTO> login(String username, String password);

    boolean checkLogin();

    void save(Users user);

    void sendEmail(String email);

    void update(Users users);
}
