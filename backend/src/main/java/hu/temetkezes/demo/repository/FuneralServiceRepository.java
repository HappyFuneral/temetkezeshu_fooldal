package hu.temetkezes.demo.repository;

import hu.temetkezes.demo.models.FuneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuneralServiceRepository extends JpaRepository< FuneralService, Long> {
}
