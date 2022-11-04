package com.accountBook.basicBoard.domain.entity;

import com.accountBook.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer viewCount;

    @Embedded
    private TimeEntity timeEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(comments, post.comments) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(viewCount, post.viewCount) && Objects.equals(timeEntity, post.timeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, comments, title, content, user, viewCount, timeEntity);
    }
}
