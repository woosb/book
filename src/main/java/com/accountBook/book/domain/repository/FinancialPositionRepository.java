package com.accountBook.book.domain.repository;

import com.accountBook.book.domain.entity.FinancialPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialPositionRepository extends JpaRepository<FinancialPosition, Long> {
    public FinancialPosition findByCompanyId(Long companyId);
}
