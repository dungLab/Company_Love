package dunglab.company.service;

import dunglab.company.domain.Company;
import dunglab.company.domain.CompanyName;
import dunglab.company.repository.CompanyNameRepository;
import dunglab.company.repository.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class CompanyNameServiceTest {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyNameService companyNameService;
    @Autowired
    CompanyNameRepository companyNameRepository;


    @Nested
    class SaveCompanyName {
        private CompanyName companyName;

        @BeforeEach
        void beforeEach() {
            Company company = companyRepository.save(Company.createCompany("pornhub"));
            companyName = CompanyName.createCompany("pornhub", "en", company);
        }

        @Test
        void success() {
            CompanyName createdCompanyName = companyNameService.createCompanyName(companyName);

            Optional<CompanyName> foundCompanyName = companyNameRepository.findById(createdCompanyName.getId());
            Assertions.assertEquals(companyName.getName(), foundCompanyName.get().getName());
        }

        @Test
        void fail() {
            //TODO: company create fail 구현
        }
    }

    @Nested
    class DeleteCompanyName {
        private CompanyName savedCompanyName;

        @BeforeEach
        void beforeEach() {
            Company company = companyRepository.save(Company.createCompany("pornhub"));
            CompanyName companyName = CompanyName.createCompany("pornhub", "en", company);
            savedCompanyName = companyNameRepository.save(companyName);
        }

        @Test
        void success() {
            companyNameService.deleteCompanyName(savedCompanyName.getId());

            Optional<CompanyName> foundCompanyName = companyNameRepository.findById(savedCompanyName.getId());
            Assertions.assertTrue(foundCompanyName.isEmpty());
        }

        @Test
        void fail() {
            //TODO: delete companyName fail 구현
        }
    }

    @Nested
    class FindCompanyNameById {
        private CompanyName savedCompanyName;

        @BeforeEach
        void beforeEach() {
            Company company = companyRepository.save(Company.createCompany("pornhub"));
            CompanyName companyName = CompanyName.createCompany("pornhub", "en", company);
            savedCompanyName = companyNameRepository.save(companyName);
        }

        @Test
        void success() {
            CompanyName foundCompanyName = companyNameService.getCompanyNameById(savedCompanyName.getId());

            Assertions.assertEquals(savedCompanyName.getName(), foundCompanyName.getName());
        }

        @Test
        void fail() {
            //TODO: find companyName fail 구현
        }
    }

    @Nested
    class FindCompanyNameByName {
        private CompanyName savedCompanyName;

        @BeforeEach
        void beforeEach() {
            Company company = companyRepository.save(Company.createCompany("pornhub"));
            CompanyName companyName = CompanyName.createCompany("pornhub", "en", company);
            savedCompanyName = companyNameRepository.save(companyName);
        }

        @Test
        void get() {
            List<CompanyName> foundCompanyNames = companyNameService.getCompanyNameByName(savedCompanyName.getName());
            Assertions.assertEquals(1, foundCompanyNames.size());
            Assertions.assertEquals(savedCompanyName.getName(), foundCompanyNames.get(0).getName());

        }
    }
}