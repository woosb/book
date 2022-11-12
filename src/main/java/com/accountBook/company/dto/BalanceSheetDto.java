package com.accountBook.company.dto;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.entity.BalanceSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BalanceSheetDto {

    private Long id;
    private Company company;

    private String subjectCode;
    private String subjectName;
    private String subjectValue;

    private String current;                    //통화
    private String stdYmd;                     // 결산기준일
    private String stdMm;                      // 결산월
    private String kindOfReport;               // 보고서종류

    public BalanceSheet toEntity(BalanceSheetDto balanceSheetDto){
        return BalanceSheet.builder()
                .id(this.id)
                .company(this.company)
                .subjectCode(this.subjectCode)
                .subjectName(this.subjectName)
                .subjectValue(this.subjectValue)
                .current(this.current)
                .stdYmd(this.stdYmd)
                .stdMm(this.stdMm)
                .kindOfReport(this.kindOfReport).build();
    }
}
