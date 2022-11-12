package com.accountBook.user.service;

import com.accountBook.user.domain.entity.User;
import com.accountBook.user.domain.repository.UserRepository;
import com.accountBook.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(new User()::toDto)
                .collect(Collectors.toList());
    }
}
