package com.accountBook.book.controller;

import com.accountBook.book.dto.CompanyDto;
import com.accountBook.book.dto.FinancialPositionDto;
import com.accountBook.book.service.CompanyService;
import com.accountBook.book.service.FinancialPositionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@AllArgsConstructor
public class CompanyRestController {
    private CompanyService companyService;
    private FinancialPositionService financialPositionService;
    @RequestMapping("/get")
    public List<CompanyDto> getCompany(Pageable pageable, Model model){
        List<CompanyDto> companies = companyService.findAll(pageable).getContent();
        return companies;
    }

    @RequestMapping("financialPosition/get")
    public FinancialPositionDto getFinancialPosition(Long companyId, Model model){
        return financialPositionService.findFinancialPositionCompanyId(companyId);
    }
}

