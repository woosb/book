package com.accountBook.company.dto;

import lombok.Data;

@Data
public class SubjectValue {

    public SubjectValue(String name, String value, String Ymd, String Mm, String kindOfReport){
        this.name = name;
        this.value = value;
        this.Ymd = Ymd;
        this.Mm = Mm;
        this.kindOfReport = kindOfReport;
    }

    String name;
    String value;
    String Ymd;
    String Mm;
    String kindOfReport;
}
