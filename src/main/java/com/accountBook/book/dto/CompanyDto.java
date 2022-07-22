package com.accountBook.book.dto;

public class CompanyDto {

    private Long id;

    private String code;
    private String name;
    private String subject;
    private String subject_eng;
    private String amount_this;
    private String amount_before;
    private String ymd;
    private String mm;
    private String quarter_kr;

    public CompanyDto(String code, String name, String subject, String subject_eng, String amount_this, String amount_before,String ymd, String mm, String quarter_kr){
        this.code = code;
        this.name = name;
        this.subject = subject;
        this.subject_eng = subject_eng;
        this.amount_this = amount_this;
        this.amount_before = amount_before;
        this.ymd = ymd;
        this.mm = mm;
        this.quarter_kr = quarter_kr;
    }

    @Override
    public String toString(){
        return "CompanyDto [code = " + code + ", name = " + name + ", subject = " + subject + ", subject_eng = " + subject_eng + ", amount_this = " + amount_this + ", amount_before = " + amount_before + ", mm = " + mm + ", ymd = " + ymd + ", Quarter = " + quarter_kr +  "]" ;
    }

}
