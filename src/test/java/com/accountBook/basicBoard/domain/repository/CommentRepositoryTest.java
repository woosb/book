package com.accountBook.basicBoard.domain.repository;

import com.accountBook.basicBoard.domain.entity.Comment;
import com.accountBook.basicBoard.domain.entity.Post;
import com.accountBook.basicBoard.domain.entity.TimeEntity;
import com.accountBook.user.domain.entity.User;
import com.accountBook.user.domain.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("save_comment")
    void saveComment() throws Exception{
        //given
        TimeEntity nowDateTime = new TimeEntity(LocalDateTime.now(),LocalDateTime.now());
        User user = User.builder().userId("testUser").userPw("TestPassWord").timeEntity(nowDateTime).build();
        userRepository.save(user);

        Post post = Post.builder()
                .title("testTitle")
                .content("testContent")
                .user(user)
                .timeEntity(nowDateTime).build();

        postRepository.save(post);

        Comment comment1 = Comment.builder()
                .post(post)
                .content("comment1")
                .user(user)
                .timeEntity(nowDateTime).build();
        Comment comment2 = Comment.builder()
                .post(post)
                .content("comment2")
                .user(user)
                .timeEntity(nowDateTime).build();

        //when
        commentRepository.save(comment1);
        commentRepository.save(comment2);

        //then
        long count = commentRepository.count();
        Assertions.assertEquals(count, 2);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    @DisplayName("find_comment")
    void findComment() throws Exception{
        //given

        //when

        //then

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("update_comment")
    void updateComment() throws Exception{
        //given


        //when

        //then

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    @DisplayName("delete_comment")
    void deleteComment() throws Exception{
        //given


        //when

        //then

    }
}