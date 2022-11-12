package com.accountBook.company.domain.repository;

import com.accountBook.company.domain.entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void saveTest(){
        //Company(id=null, financialPositionList=null, code=211270, name=AP위성, market=코스닥시장상장법인, sectorCode=264, sectorName=통신 및 방송 장비 제조업)
        Company company = Company.builder().code("211270").name("AP위성").market("코스닥시장상장법인").sectorCode("265").sectorName("테스트").build();

        companyRepository.save(company);
        long count = companyRepository.count();
        Assertions.assertEquals(1,count);
    }

}