package com.accountBook.basicBoard.dto;

import com.accountBook.basicBoard.domain.entity.Comment;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String content;

    //TODO DTO와 Entity 변수 보충
    public Comment toEntity(){
        return Comment.builder().content(this.content).build();
    }

    public static CommentDto toDto(){
        return CommentDto.builder().build();
    }
}
