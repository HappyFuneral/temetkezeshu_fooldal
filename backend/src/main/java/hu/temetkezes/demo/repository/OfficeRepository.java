package hu.temetkezes.demo.repository;

import hu.temetkezes.demo.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OfficeRepository extends JpaRepository<Office,Long> {
}
