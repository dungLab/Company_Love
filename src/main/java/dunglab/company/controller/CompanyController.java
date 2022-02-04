package dunglab.company.controller;

import dunglab.company.domain.Company;
import dunglab.company.service.CompanyNameService;
import dunglab.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyNameService companyNameService;

    @GetMapping("{name}")
    public String createCompany(@PathVariable("name") String name, @RequestHeader("x-wanted-language") String lang) {
        /*
            1. Company service에서 findByName호출해서 회사이름에 해당하는 company_id 찾아옴
            2. Company_name service에서 company_id과 lang에 연관있는 이름들을 모두 가져옴
         */
        Company foundCompany = companyService.findCompanyByName(name);

        return "";
    }
}
