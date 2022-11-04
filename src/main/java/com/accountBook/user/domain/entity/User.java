package com.accountBook.user.domain.entity;

import com.accountBook.basicBoard.domain.entity.TimeEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String id;
    private String pw;

    @Embedded
    private TimeEntity timeEntity;

}
