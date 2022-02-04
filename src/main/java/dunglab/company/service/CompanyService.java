package dunglab.company.service;

import dunglab.company.domain.Company;
import dunglab.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public Company createdCompany(String name) {
        Company company = Company.createCompany(name);
        Company savedCompany = this.companyRepository.save(company);
        return savedCompany;
    }

    public Company findCompanyByName(String name) {
        Optional<Company> foundCompany = companyRepository.findByName(name);
        //TODO:exception 정의
        return foundCompany.get();
    }

    public Company findCompanyById(Long id) {
        Optional<Company> foundCompany = companyRepository.findById(id);
        //TODO:exception 정의
        return foundCompany.get();
    }
}
