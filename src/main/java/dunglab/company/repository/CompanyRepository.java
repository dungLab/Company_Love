package dunglab.company.repository;

import dunglab.company.domain.Company;
import dunglab.company.domain.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c where c.name= ?1")
    public Optional<Company> findByName(String name);
}
