package com.accountBook.book.dto;

import lombok.Data;

@Data
public class SubjectValue {

    public SubjectValue(String name, String value){
        this.name = name;
        this.value = value;
    }

    String name;
    String value;

}
