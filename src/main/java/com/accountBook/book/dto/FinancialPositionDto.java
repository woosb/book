package com.accountBook.book.dto;

import com.accountBook.book.domain.entity.FinancialPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FinancialPositionDto {

    private Long FinancialId;
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


    public static FinancialPositionDto build(FinancialPosition financialPosition) {

        return FinancialPositionDto.builder()
                .FinancialId(financialPosition.getFinancialId())
                .liabilities(financialPosition.getLiabilities())
                .equityAndLiabilities(financialPosition.getEquityAndLiabilities())
                .cashAndCashEquivalents(financialPosition.getCashAndCashEquivalents())
                .retainedEarnings(financialPosition.getRetainedEarnings())
                .currentAssets(financialPosition.getCurrentAssets())
                .noncurrentAssets(financialPosition.getNoncurrentAssets())
                .currentLiabilities(financialPosition.getCurrentLiabilities())
                .noncurrentLiabilities(financialPosition.getNoncurrentLiabilities())
                .ymd(financialPosition.getYmd())
                .mm(financialPosition.getMm())
                .kindOfReport(financialPosition.getKindOfReport())
                .assets(financialPosition.getAssets())
                .build();
    }
}
