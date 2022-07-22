package com.accountBook.book.dto;

public class CompanyDto {

    private Long id;

    private String key;
    private String name;
    private String subject;
    private String subject_eng;
    private String amount;
    private String ymd;
    private String mm;
    private String quarter_kr;

    public CompanyDto(String key, String name, String subject, String subject_eng, String amount, String ymd, String mm, String quarter_kr){
        this.key = key;
        this.name = name;
        this.subject = subject;
        this.subject_eng = subject_eng;
        this.amount = amount;
        this.ymd = ymd;
        this.mm = mm;
        this.quarter_kr = quarter_kr;
    }

    @Override
    public String toString(){
        return "CompanyDto [key = " + key + ", name = " + name + ", subject = " + subject + ", subject_eng = " + subject_eng + ", amount = " + amount + ", mm = " + mm + ", ymd = " + ymd + ", Quarter = " + quarter_kr +  "]" ;
    }

}
