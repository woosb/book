package com.accountBook.book.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialPosition {

    @Id
    @GeneratedValue
    private Long FinancialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    private String assets;                     // 자산총계
    private String liabilities;                // 부채총계
    private String equityAndLiabilities;       // 자본과 부채총계
    private String cashAndCashEquivalents;     // 현금및 현금성 자산
    private String retainedEarnings;           // 이익잉여금
    private String currentAssets;              // 유동자산
    private String noncurrentAssets;           // 비유동자산
    private String currentLiabilities;         // 유동부채
    private String noncurrentLiabilities;      // 비유동부채

    private String ymd;                        // 결산기준일
    private String mm;                         // 결산월
    private String kindOfReport;               // 보고서종류

}
