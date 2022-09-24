package com.accountBook.book.controller;

import com.accountBook.book.dto.CompanyDto;
import com.accountBook.book.dto.FinancialPositionDto;
import com.accountBook.book.service.CompanyService;
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
        //http://localhost:8080/company/?page=0&size=3&sort=name,ASC
        return companyService.findAll(pageable).getContent();
    }

    @RequestMapping("financialPosition/{companyId}")
    public List<FinancialPositionDto> getFinancialPosition(@PathVariable("companyId") Long companyId, Model model){
        return companyService.findPositionListByCompanyId(companyId);
    }
}

