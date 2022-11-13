package com.accountBook.company.domain.entity;


import com.accountBook.company.dto.BalanceSheetDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="balance_sheet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BalanceSheet {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    @JsonManagedReference
    private Company company;

    @Column(name = "SUBJECT_CODE")
    private String subjectCode;
    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "CURRENT")
    private String current;                    //통화

    @Column(name = "STD_YMD")
    private String stdYmd;                     // 결산기준일
    @Column(name = "STD_MM")
    private String stdMm;                      // 결산월
    @Column(name = "KIND_OF_REPORT")
    private String kindOfReport;               // 보고서종류

    @Column(name = "CURRENT_PERIOD")
    private String currentPeriod;              // 당기

    @Column(name = "PRIOR_PERIOD")
    private String priorPeriod;                // 전기

    @Column(name = "BF_PRIOR_PERIOD")
    private String bfPriorPeriod;              // 전전기

    public BalanceSheetDto toDto(){
        return BalanceSheetDto.builder()
                .id(this.id)
                .companyId(this.company.getId())
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
