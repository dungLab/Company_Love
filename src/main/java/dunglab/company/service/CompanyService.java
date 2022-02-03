package dunglab.company.service;

import dunglab.company.domain.Company;
import dunglab.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    // command 7 누르면 해당 클래스의 모든 멤버를 볼수있음 롬복으로 만들어진 생성자 볼수있숨. RequiredArgsConstructor는 final 멤버변수 생성자임.
    // 생성자 DI를 통해서 스프링 컨테이너에 등록된 CompanyRepository 스프링 빈을 의존한거임
    // Autowired는 생략가능함

    private final CompanyRepository companyRepository;

    // 롬복을 사용하지 않는다면 아래처럼 해야 CompanyRepository빈을 DI받을수 있음
//    @Autowired - 이건 생성자 하나면 생략가능함 Autowired를 통해서 스프링 컨테이너에 등록된 빈을 DI할수있음 우린 롬복을 이용하니
// 더 간단하게 @RequiredArgsConstructor만 사용하면 자동으로 DI됨
//    public CompanyService(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }

    //예시 1 - 회사 추가
    @Transactional
    public Company createdCompany(){
        Company company = Company.createCompany();
        Company savedCompany = this.companyRepository.save(company);
        return savedCompany;
    }
}
