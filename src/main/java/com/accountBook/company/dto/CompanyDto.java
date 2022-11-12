package com.accountBook.company.dto;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.entity.BalanceSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CompanyDto {

    private Long id;
    private String code;
    private String name;
    private String market;
    private String sectorCode;
    private String sectorName;
    private List<BalanceSheet> balanceSheetList;

    public Company toEntity(){
        return Company.builder()
                .id(this.id)
                .code(this.code)
                .name(this.name)
                .market(this.market)
                .sectorCode(this.sectorCode)
                .sectorName(this.sectorName)
                .balanceSheetList(this.balanceSheetList).build();
    }

}
