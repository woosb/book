package com.accountBook.book.controller;

import com.accountBook.book.domain.entity.FinancialPosition;
import com.accountBook.book.dto.CompanyDto;
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
    @RequestMapping("/get")
    public List<CompanyDto> getCompany(Pageable pageable, Model model){
        return companyService.findAll(pageable).getContent();
    }

    @RequestMapping("financialPosition/get/{companyId}")
    public List<FinancialPosition> getFinancialPosition(@PathVariable("companyId") Long companyId, Model model){
        // financialposition -> financialpositionDto 로 변경해야함
        System.out.println(companyId);
        System.out.println(companyService.findPositionListByCompanyId(companyId));
        return companyService.findPositionListByCompanyId(companyId);
    }
}

