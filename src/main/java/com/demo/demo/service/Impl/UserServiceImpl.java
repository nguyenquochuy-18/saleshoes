package com.demo.demo.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.demo.demo.domain.Users;
import com.demo.demo.dto.UsersDTO;
import com.demo.demo.repository.UserRepository;
import com.demo.demo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    private UsersDTO user;

    @Override
    public Optional<UsersDTO> login(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)) {
            return Optional.empty();
        }
        Optional<UsersDTO> usersDTO = userRepository.findByUsernameAndPassword(username, password)
                .map(users -> {
                    UsersDTO dto = new UsersDTO();
                    BeanUtils.copyProperties(users, dto);
                    return dto;
                });
        user = usersDTO.orElse(null);
        return Optional.ofNullable(user);
    }

    @Override
    public boolean checkLogin() {
        return user != null;
    }

    @Override
    public void save(Users user) {
        user.setDisplayName(user.getDisplayName());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public void sendEmail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        javaMailSender.send(msg);

    }

    @Override
    public void update(Users users) {
        userRepository.save(users);
    }

    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }
}
