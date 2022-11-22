package com.accountBook.company.controller;

import com.accountBook.company.common.DartFileParser;
import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.service.BalanceSheetService;
import com.accountBook.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final BalanceSheetService balanceSheetService;

    @RequestMapping("/detail/{companyCode}") //TODO kindOfReport -> enum class로 코드 관리 하기.
    public String companyDetail(@PathVariable("companyCode") String companyCode, Model model){
        System.out.println(companyCode);
        model.addAttribute("companyCode", companyCode);
        return "companyDetail";
    }

    @RequestMapping("/setCompany")
    public String setCompany() throws IOException, SQLException {
        DartFileParser fileUtil = new DartFileParser();
//        List<Company> companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_3분기보고서_01_재무상태표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_3분기보고서_01_재무상태표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_02_손익계산서_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_02_손익계산서_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_03_포괄손익계산서_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_03_포괄손익계산서_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/CF/20221111/2022_1분기보고서_04_현금흐름표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/CF/20221111/2022_1분기보고서_04_현금흐름표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/CE/20221111/2022_1분기보고서_05_자본변동표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.setCompany(new File("/D:/Intellij_projects/book/out/production/resources/dart/CE/20221111/2022_1분기보고서_05_자본변동표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);

        List<Company> allCompanies = companyService.findAll();
        List<Company> companies = fileUtil.setBalanceSheet(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_3분기보고서_01_재무상태표_20221111.txt"), allCompanies);
        companyService.saveAllEntity(companies);
        companies = fileUtil.setBalanceSheet(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_1분기보고서_01_재무상태표_20221112.txt"), allCompanies);
        companyService.saveAllEntity(companies);
        companies = fileUtil.setBalanceSheet(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_반기보고서_01_재무상태표_20221112.txt"), allCompanies);
        companyService.saveAllEntity(companies);

        return "";
    }
}
