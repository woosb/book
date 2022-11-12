package com.accountBook.basicBoard.domain.repository;

import com.accountBook.basicBoard.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostByPostId(Long postId);
    Optional<Post> findPostByTitle(String title);
}
