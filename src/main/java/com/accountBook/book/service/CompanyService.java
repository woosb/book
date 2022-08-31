package com.accountBook.book.service;

import com.accountBook.book.domain.entity.Company;
import com.accountBook.book.domain.repository.CompanyRepository;
import com.accountBook.book.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    @Transactional
    public void saveAll(List<Company> list) {
        companyRepository.saveAll(list);
    }
    public Page<CompanyDto> findAll(Pageable pageable) {
        Page<CompanyDto> companyDtos = companyRepository.findAll(pageable).map(new Function<Company, CompanyDto>() {
            @Override
            public CompanyDto apply(Company company) {
                CompanyDto dto = CompanyDto.builder().CompanyId(company.getCompanyId()).code(company.getCode()).kindOfMarket(company.getKindOfMarket()).name(company.getName()).sectors_name(company.getSectors_name()).sectors_code(company.getSectors_code()).build();
                return dto;
            }
        });
        return companyDtos;
    }
}
