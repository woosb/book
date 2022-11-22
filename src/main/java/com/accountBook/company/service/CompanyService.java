package com.accountBook.company.service;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.repository.CompanyRepository;
import com.accountBook.company.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void saveAll(List<CompanyDto> list){
        companyRepository.saveAll(list.stream().map((dto) -> dto.toEntity()).collect(Collectors.toList()));
    }

    public void saveAllEntity(List<Company> companies){
        companyRepository.saveAll(companies);
    }

    public void save(Company company){
        System.out.println("service save");
        System.out.println(company);
        companyRepository.save(company);
    }

    public Long count(){
        return companyRepository.count();
    }

    public List<CompanyDto> findAll(Pageable pageable){
        return companyRepository.findAll(pageable).stream().map((e)-> e.toDto()).collect(Collectors.toList());
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

}
