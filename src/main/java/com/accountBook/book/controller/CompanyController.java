package com.accountBook.book.controller;

import com.accountBook.book.common.TextFileReader;
import com.accountBook.book.domain.entity.Company;
import com.accountBook.book.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @RequestMapping("/setCompany")
    public String setCompany() throws IOException {

        ClassPathResource resource = new ClassPathResource("/dart/2022_1분기보고서_01_재무상태표_20220608utf8.txt");
        File file = resource.getFile();

        TextFileReader tfr = new TextFileReader();
        List<Company> list = null;
        try {
            list = tfr.getFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        companyService.saveAll(list);
        return "index";
    }
}
