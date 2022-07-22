package com.accountBook.book.domain.repository;

import com.accountBook.book.domain.entity.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyRepository {

    @PersistenceContext
    private EntityManager em;

    public void saveAll(List<Company> companies) {
        for(Company company : companies){
            em.persist(company);
        }
    }
}
