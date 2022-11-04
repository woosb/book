package com.accountBook.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CompanyDto {

    private Long companyId;
    private String code;
    private String name;
    private String kindOfMarket;
    private String sectors_code;
    private String sectors_name;

}
