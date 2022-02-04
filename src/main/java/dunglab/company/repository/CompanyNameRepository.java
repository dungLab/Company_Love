package dunglab.company.repository;

import dunglab.company.domain.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyNameRepository extends JpaRepository<CompanyName, Long> {

    @Query("select cn from CompanyName cn where cn.name= ?1")
    public List<CompanyName> findByName(String name);

}
