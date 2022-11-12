package com.accountBook.company.domain.repository;

import com.accountBook.company.domain.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findAll(Pageable pageable);
    Optional<Company> findById(Long id);

}
