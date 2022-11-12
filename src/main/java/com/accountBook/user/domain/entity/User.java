package com.accountBook.user.domain.entity;

import com.accountBook.basicBoard.domain.entity.TimeEntity;
import com.accountBook.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String userPw;

    @Embedded
    private TimeEntity timeEntity;

    public UserDto toDto(User user){
        String userId = user.getUserId();
        String userPw = user.getUserId();
        TimeEntity timeEntity = user.getTimeEntity();
        return UserDto.builder()
                .userId(userId)
                .userPw(userPw)
                .timeEntity(timeEntity).build();
    }
}
