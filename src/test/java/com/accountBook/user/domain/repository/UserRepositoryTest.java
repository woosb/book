package com.accountBook.user.domain.repository;

import com.accountBook.basicBoard.domain.entity.TimeEntity;
import com.accountBook.user.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    //@BeforeAll //테스트 시작전에 한번만 실행
    @BeforeEach // 각 테스트 시작전에 한번씩 실행
    public void prepareUser(){
        TimeEntity timeEntity = new TimeEntity(LocalDateTime.now(),LocalDateTime.now());
        User user = User.builder().userId("test").userPw("1234").timeEntity(timeEntity).build();
        userRepository.save(user);
    }

    @Test
    public void saveUser(){
        //given
        TimeEntity timeEntity = new TimeEntity(LocalDateTime.now(),LocalDateTime.now());
        User user = User.builder().userId("testUser").userPw("1234").timeEntity(timeEntity).build();
        User save = userRepository.save(user);
        //when
        User findUser = userRepository.findByUserId("testUser").orElseGet(()->new User());
        //then
        Assertions.assertEquals(save.getUserId(), findUser.getUserId());
    }

    @Test
    public void findByUserId(){
        User findUser = userRepository.findByUserId("test").orElseThrow(()->new IllegalArgumentException("해당 유저가 없습니다."));
        Assertions.assertEquals("test", findUser.getUserId() );
    }

    @Test
    public void findUserAll(){
        List<User> all = userRepository.findAll();
        int size = all.size();
        long count = userRepository.count();
        Assertions.assertEquals(size, count);
    }

    @Test
    public void updateUser(){
        User findUser = userRepository.findByUserId("test").orElseThrow(()->new IllegalArgumentException("해당 유저가 없습니다."));
        findUser.setUserId("updateUserId");
        findUser.setUserPw("updateUserPw");
        userRepository.save(findUser);

        User findUser2 = userRepository.findByUserId("updateUserId").orElseThrow(()->new IllegalArgumentException("해당 유저가 없습니다."));
        Assertions.assertEquals("updateUserId", findUser2.getUserId());
        Assertions.assertEquals("updateUserPw", findUser2.getUserPw());
    }

    @Test
    public void deleteUser(){
        userRepository.deleteByUserId("test");
        Assertions.assertThrows(NoSuchElementException.class, ()->{
            userRepository.findByUserId("test").get();
        });
    }
}