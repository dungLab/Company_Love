package dunglab.company.service;


import dunglab.company.domain.CompanyName;
import dunglab.company.repository.CompanyNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyNameService {
    private final CompanyNameRepository companyNameRepository;

    @Transactional
    public CompanyName createCompanyName(CompanyName companyName) {
        CompanyName savedCompanyName = companyNameRepository.save(companyName);
        return savedCompanyName;
    }

    @Transactional
    public void deleteCompanyName(Long id) {
        companyNameRepository.deleteById(id);
    }

    @Transactional
    public CompanyName getCompanyNameById(Long id) {
        return companyNameRepository.findById(id).get();
    }

    @Transactional
    public List<CompanyName> getCompanyNameByName(String name) {
        return companyNameRepository.findByName(name);
    }
}
