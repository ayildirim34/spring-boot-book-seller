package com.yil.spring_boot_book_seller.service;

import com.yil.spring_boot_book_seller.model.Role;
import com.yil.spring_boot_book_seller.model.User;
import com.yil.spring_boot_book_seller.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {

        user.setCreateTime(LocalDateTime.now());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Transactional
    @Override
    public void makeAdmin (String username) {
        userRepository.updateUserRole(username, Role.ADMIN);
    }

}
