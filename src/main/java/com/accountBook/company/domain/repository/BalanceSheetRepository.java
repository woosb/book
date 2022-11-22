package com.accountBook.company.domain.repository;

import com.accountBook.company.domain.entity.BalanceSheet;
import com.accountBook.company.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {

    List<BalanceSheet> findByCompanyCode(String companyCode);
    List<BalanceSheet> findByCompanyAndKindOfReport(Company company, String kindOfReport);
}
