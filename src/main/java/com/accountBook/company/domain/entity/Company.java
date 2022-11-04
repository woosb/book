package com.accountBook.company.domain.entity;

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
        this.sectorsCode = sectors_code;
        this.sectorsName = sectors_name;
    }

    @Id
    @GeneratedValue
    private Long companyId;

    @OneToMany(mappedBy = "company", cascade= CascadeType.ALL)
    /*
    * 양방향 맵핑 시 entity를 바로 response로 반환하게 되면 순환참조가 일어나게 된다.(ex toString) 때문에
    * @JsonManagedReference
    * 어노테이션을 이용하는 방법도 있지만
    * dto객체를 만들어서 반환하는것이 더 좋다.
    * entity는 변경될 여지가 있지만 api 명세상 반환하는 내용이 변하게 된다면 api를 신뢰할 수 없게 되고 나중에 되돌릴 수 없는 상황이 발생할 수 있기 때문이다.
    *
    * */
    public List<FinancialPosition> financialPositionList = new ArrayList<>();

    private String code;
    private String name;
    private String kindOfMarket;
    private String sectorsCode;
    private String sectorsName;
}
