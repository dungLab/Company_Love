package dunglab.company.controller;

import dunglab.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    //그냥 예시로 get메서드 사용햇숨
    @GetMapping
    public String createCompany(){
        this.companyService.createdCompany();

        return "회사생성성공";
    }
}
