package dunglab.company.repository;

import dunglab.company.domain.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyNameRepository extends JpaRepository<CompanyName, Long> {
}
