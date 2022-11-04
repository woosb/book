package com.accountBook.company.service;

import com.accountBook.company.domain.entity.Company;
import com.accountBook.company.domain.entity.FinancialPosition;
import com.accountBook.company.domain.repository.CompanyRepository;
import com.accountBook.company.dto.CompanyDto;
import com.accountBook.company.dto.FinancialPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return companyRepository.findAll(pageable).map(company -> CompanyDto.builder()
                .companyId(company.getCompanyId())
                .code(company.getCode())
                .kindOfMarket(company.getKindOfMarket())
                .name(company.getName())
                .sectors_name(company.getSectorsName())
                .sectors_code(company.getSectorsCode())
//                .financialPositionDtos(findPositionListByCompanyId(company.getCompanyId()))
                .build());
    }

    public List<FinancialPositionDto> findPositionListByCompanyId(Long id){
        Optional<Company> companyOptional = companyRepository.findById(id);
        List<FinancialPosition> financialPositions = companyOptional.map(Company::getFinancialPositionList).orElse(null);

        List<FinancialPositionDto> financialPositionDtos = new ArrayList<>();
        assert financialPositions != null;
        for(FinancialPosition financialPosition : financialPositions){
            FinancialPositionDto financialPositionDto = FinancialPositionDto.build(financialPosition);
            financialPositionDtos.add(financialPositionDto);
        }
        return financialPositionDtos;
    }
}
