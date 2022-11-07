package com.accountBook.basicBoard.domain.repository;

import com.accountBook.basicBoard.domain.entity.Post;
import com.accountBook.basicBoard.domain.entity.TimeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("save_post")
    public void savePost() {
        //given
        TimeEntity timeEntity = new TimeEntity(LocalDateTime.now(), LocalDateTime.now());

        Post post = Post.builder()
                .title("testTitle")
                .content("TestContents")
                .timeEntity(timeEntity)
                .comments(new ArrayList<>())
                .viewCount(1).build();

        //when
        postRepository.save(post);

        //then
        Assertions.assertThat(post.getPostId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    @DisplayName("find_post")
    public void findPost() {
        //given
        Optional<Post> postByPostId = postRepository.findPostByPostId(1L);

        //when
        Post post = postByPostId.orElseThrow();

        //then
        Assertions.assertThat(post.getPostId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("update_post")
    public void updatePost(){
        //given
        Optional<Post> postByPostId = postRepository.findPostByPostId(1L);
        Post post = postByPostId.orElseThrow();

        //when
        post.setTitle("updatedTitle");
        post.setContent("updatedContent");
        TimeEntity timeEntity = post.getTimeEntity();
        LocalDateTime updatedTime = LocalDateTime.now();
        timeEntity.setUpdateDate(updatedTime);
        postRepository.save(post);

        //then
        Post updatedPost = postRepository.findPostByPostId(1L).orElseThrow();
        Assertions.assertThat(updatedPost.getTitle()).isEqualTo("updatedTitle");
        Assertions.assertThat(updatedPost.getContent()).isEqualTo("updatedContent");
        Assertions.assertThat(updatedPost.getTimeEntity().getUpdateDate()).isEqualTo(updatedTime);
    }


    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("delete_post")
    public void deletePost(){
        //given
        Optional<Post> findPost = postRepository.findPostByPostId(1L);
        if(findPost.isPresent()){
            Post post = findPost.get();
            postRepository.delete(post);
        }

        //when
        Post tempPost = null;
        Optional<Post> optionalPost = postRepository.findPostByPostId(1L);
        if(optionalPost.isPresent()){
            tempPost = optionalPost.get();
        }

        //then
        Assertions.assertThat(tempPost).isNull();
    }
}