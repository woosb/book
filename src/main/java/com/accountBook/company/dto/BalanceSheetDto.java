package com.accountBook.company.dto;

import com.accountBook.company.domain.entity.BalanceSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BalanceSheetDto {

    private Long id;
    private Long companyId;

    private String subjectCode;
    private String subjectName;
    private String subjectValue;

    private String current;                    //통화
    private String stdYmd;                     // 결산기준일
    private String stdMm;                      // 결산월
    private String kindOfReport;               // 보고서종류
    private String currentPeriod;              //당기
    private String priorPeriod;                //전기
    private String bfPriorPeriod;              //전전기

    public BalanceSheet toEntity(BalanceSheetDto balanceSheetDto){
        return BalanceSheet.builder()
                .id(this.id)
                .subjectCode(this.subjectCode)
                .subjectName(this.subjectName)
                .currentPeriod(this.currentPeriod)
                .priorPeriod(this.priorPeriod)
                .bfPriorPeriod(this.bfPriorPeriod)
                .current(this.current)
                .stdYmd(this.stdYmd)
                .stdMm(this.stdMm)
                .kindOfReport(this.kindOfReport).build();
    }
}
