package com.accountBook.user.domain.repository;

import com.accountBook.user.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    User user;

    @Test
    public void saveUser(){
        User save = userRepository.save(user);
        assertEquals(save, user);
        long count = userRepository.count();
        assertEquals(1, count);
    }

}