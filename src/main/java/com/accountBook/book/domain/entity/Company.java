package com.accountBook.book.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

    @Id @GeneratedValue
    private Long id;

    private String key;
    private String name;
    private String subject;
    private String subject_eng;
    private String amount;
    private String ymd;
    private String mm;
    private String quarter_kr;

}
