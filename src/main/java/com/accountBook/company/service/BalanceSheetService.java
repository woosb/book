package com.accountBook.company.service;

import com.accountBook.company.domain.entity.BalanceSheet;
import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.repository.BalanceSheetRepository;
import com.accountBook.company.domain.repository.CompanyRepository;
import com.accountBook.company.dto.BalanceSheetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BalanceSheetService {
    private final BalanceSheetRepository balanceSheetRepository;
    private final CompanyRepository companyRepository;

    public List<BalanceSheet> findBalanceSheetByCompanyCode(String companyCode){
        return balanceSheetRepository.findByCompanyCode(companyCode);
    }



    public List<BalanceSheetDto> findByCompanyCodeAndKindOfReport(String companyCode, String kindOfReport){
        Company company = companyRepository.findByCode(companyCode).orElseThrow(() -> new IllegalArgumentException("해당 회사코드가 존재하지 않습니다"));
        List<BalanceSheet> byCompanyCodeAndKindOfReport = balanceSheetRepository.findByCompanyAndKindOfReport(company, kindOfReport);
        List<BalanceSheetDto> balanceSheetDtos = byCompanyCodeAndKindOfReport.stream().map((e) -> e.toDto()).collect(Collectors.toList());
        return balanceSheetDtos;
    }
}
