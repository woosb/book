package com.accountBook.company.controller;

import com.accountBook.company.dto.CompanyDto;
import com.accountBook.company.dto.BalanceSheetDto;
import com.accountBook.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyRestController {
    private final CompanyService companyService;
    @RequestMapping("/")
    public List<CompanyDto> getCompany(Pageable pageable, Model model){
        // http://localhost:8080/company/?page=0&size=30&sort=sectorsName,ASC&sort=code,DESC
        return companyService.findAll(pageable);
    }

    @RequestMapping("balanceSheet/{companyId}")
    public List<BalanceSheetDto> getBalanceSheet(@PathVariable("companyId") Long id){
        return companyService.findBalanceSheetByCompanyId(id);
    }
}

