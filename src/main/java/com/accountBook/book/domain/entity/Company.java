package com.accountBook.book.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

    public Company(String code, String name, String kindOfMarket, String sectors_code, String sectors_name){
        this.code = code;
        this.name = name;
        this.kindOfMarket = kindOfMarket;
        this.sectors_code = sectors_code;
        this.sectors_name = sectors_name;
    }

    @Id @GeneratedValue
    private Long CompanyId;

    @OneToMany(mappedBy = "company", cascade= CascadeType.ALL)
//    @JsonManagedReference
    public List<FinancialPosition> financialPositionList = new ArrayList<>();

    private String code;
    private String name;
    private String kindOfMarket;
    private String sectors_code;
    private String sectors_name;
}
