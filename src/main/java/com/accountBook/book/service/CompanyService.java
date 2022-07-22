package com.accountBook.book.service;

import com.accountBook.book.domain.entity.Company;
import com.accountBook.book.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public void saveAll(List<Company> list){
        companyRepository.saveAll(list);
    }
}
