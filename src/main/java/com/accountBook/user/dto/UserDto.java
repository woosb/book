package com.accountBook.user.dto;

import com.accountBook.basicBoard.domain.entity.TimeEntity;
import com.accountBook.user.domain.entity.User;
import lombok.Builder;

@Builder
public class UserDto {
    private Long id;
    private String userId;
    private String userPw;
    private TimeEntity timeEntity;

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .userPw(this.userPw)
                .timeEntity(this.timeEntity).build();
    }
}
