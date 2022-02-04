package dunglab.company.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyName extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "char(2)")
    private String lang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // == 양방향 편의 메서드 (Company, CompanyName) == //
    public void addCompanyName(Company company){
        this.company = company;
        company.getCompanyNames().add(this);
    }

    // == 생성 메서드 == //
    public static CompanyName createCompanyName(String name, String lang, Company company){
        CompanyName companyName = new CompanyName();

        companyName.name = name;
        companyName.lang = lang;
        companyName.addCompanyName(company);

        return companyName;
    }
}
