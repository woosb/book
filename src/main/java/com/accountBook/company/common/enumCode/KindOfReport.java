package com.accountBook.company.common.enumCode;

public enum KindOfReport {
    quarter1("1분기보고서"),
    quarter2("반기보고서"),
    quarter3("3분기보고서"),
    quarter4("사업보고서"),
    ;

    private String name;
    KindOfReport(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
