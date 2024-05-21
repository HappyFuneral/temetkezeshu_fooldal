package hu.temetkezes.demo.repository;

import hu.temetkezes.demo.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByShortName(String shortName);
}
