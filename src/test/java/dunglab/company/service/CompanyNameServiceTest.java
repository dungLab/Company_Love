package dunglab.company.service;

import dunglab.company.repository.CompanyNameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CompanyNameServiceTest {
    @Autowired
    CompanyNameService companyNameService;
    @Autowired
    CompanyNameRepository companyNameRepository;

    @Test
    @DisplayName("해당 검색어로 조회되는 회사 없음")
    void company_search_result_not_existed(){
        //given


        //when

        //then

    }
}