package com.accountBook.basicBoard.domain.repository;

import com.accountBook.basicBoard.domain.entity.Comment;
import com.accountBook.basicBoard.domain.entity.Post;
import com.accountBook.basicBoard.domain.entity.TimeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void savePostAndComments() {
        Post post;
        TimeEntity timeEntity = new TimeEntity();
        timeEntity.setInsertDate(LocalDateTime.now());
        timeEntity.setUpdateDate(LocalDateTime.now());
        post = Post.builder()
                .title("testTitle")
                .content("TestContents")
                .timeEntity(timeEntity)
                .comments(new ArrayList<>())
                .viewCount(1).build();

        post.getComments().add(Comment.builder().content("testContents1").timeEntity(timeEntity).post(post).build());
        post.getComments().add(Comment.builder().content("testContents2").timeEntity(timeEntity).post(post).build());
        post.getComments().add(Comment.builder().content("testContents3").timeEntity(timeEntity).post(post).build());
        post.getComments().add(Comment.builder().content("testContents4").timeEntity(timeEntity).post(post).build());

        Post save = postRepository.save(post);
        Assertions.assertEquals(post, save);

        postRepository.delete(post);
        long count = postRepository.count();
        Assertions.assertEquals(count, 0);
    }
}