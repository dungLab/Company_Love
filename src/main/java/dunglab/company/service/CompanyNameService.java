package dunglab.company.service;

import dunglab.company.repository.CompanyNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyNameService {
    private final CompanyNameRepository companyNameRepository;


}
