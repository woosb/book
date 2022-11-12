package com.accountBook.company.controller;

import com.accountBook.company.common.DartFileParser;
import com.accountBook.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @RequestMapping("/setCompany")
    public String setCompany() throws IOException, SQLException {
        DartFileParser fileUtil = new DartFileParser();
//        List<Company> companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_3분기보고서_01_재무상태표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/BS/20221111/2022_3분기보고서_01_재무상태표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_02_손익계산서_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_02_손익계산서_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_03_포괄손익계산서_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/PL/20221111/2022_1분기보고서_03_포괄손익계산서_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/CF/20221111/2022_1분기보고서_04_현금흐름표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/CF/20221111/2022_1분기보고서_04_현금흐름표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/CE/20221111/2022_1분기보고서_05_자본변동표_20221111.txt"));
//        companyService.saveAllEntity(companies);
//
//        companies = fileUtil.parseFile(new File("/D:/Intellij_projects/book/out/production/resources/dart/CE/20221111/2022_1분기보고서_05_자본변동표_연결_20221111.txt"));
//        companyService.saveAllEntity(companies);
        return "index";
    }
}
