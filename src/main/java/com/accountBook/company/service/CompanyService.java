package com.accountBook.company.service;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.entity.BalanceSheet;
import com.accountBook.company.domain.repository.CompanyRepository;
import com.accountBook.company.dto.CompanyDto;
import com.accountBook.company.dto.BalanceSheetDto;
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

    public List<BalanceSheetDto> findPositionListByCompanyId(Long id){
        Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회사코드가 존재하지 않습니다"));
        List<BalanceSheet> balanceSheets = company.getBalanceSheetList();

        assert balanceSheets != null;
        List<BalanceSheetDto> balanceSheetDtos = balanceSheets.stream().map((e) -> e.toDto()).collect(Collectors.toList());
        return balanceSheetDtos;
    }
}
