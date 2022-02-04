package dunglab.company.service;

import dunglab.company.domain.Company;
import dunglab.company.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CompanyServiceTest {

    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @Nested
    class FindCompanyById {
        private Company savedCompany;
        @BeforeEach
        void beforeEach() {
            Company company=Company.createCompany("dung-lab");
            savedCompany= companyRepository.save(company);
        }

        @Test
        void success() {
            Company foundCompany=companyService.findCompanyById(savedCompany.getId());

            Assertions.assertEquals(savedCompany.getName(), foundCompany.getName());
        }

        @Test
        void fail() {
            //TODO: findCompanyById fail 작성
        }
    }

    @Nested
    class FindCompanyByName {
        private Company savedCompany;
        @BeforeEach
        void beforeEach() {
            Company company=Company.createCompany("dung-lab");
            savedCompany= companyRepository.save(company);
        }

        @Test
        void success() {
            Company foundCompany=companyService.findCompanyByName(savedCompany.getName());

            Assertions.assertEquals(savedCompany.getId(), foundCompany.getId());
        }

        @Test
        void fail() {
            //TODO: findCompanyById fail 작성
            Assertions.assertTrue(true);
        }
    }
}
