package com.accountBook.company.domain.entity;

import com.accountBook.company.dto.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    /*
    * 양방향 맵핑 시 entity를 바로 response로 반환하게 되면 순환참조가 일어나게 된다.(ex toString) 때문에
    * @JsonManagedReference
    * 어노테이션을 이용하는 방법도 있지만
    * dto객체를 만들어서 반환하는것이 더 좋다.
    * entity는 변경될 여지가 있지만 api 명세상 반환하는 내용이 변하게 된다면 api를 신뢰할 수 없게 되고 나중에 되돌릴 수 없는 상황이 발생할 수 있기 때문이다.
    *
    * */
    @OneToMany(mappedBy = "company", cascade= CascadeType.ALL)
    private List<BalanceSheet> balanceSheetList = new ArrayList<>();

    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MARKET")
    private String market;
    @Column(name = "SECTOR_CODE")
    private String sectorCode;
    @Column(name = "SECTOR_NAME")
    private String sectorName;

    public CompanyDto toDto(){
        return CompanyDto.builder()
                .id(this.id)
                .code(this.code)
                .name(this.name)
                .market(this.market)
                .sectorCode(this.sectorCode)
                .sectorName(this.sectorName)
                .balanceSheetList(this.balanceSheetList).build();
    }
}
