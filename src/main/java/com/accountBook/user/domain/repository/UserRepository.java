package com.accountBook.user.domain.repository;

import com.accountBook.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    void deleteByUserId(String userId);
}
