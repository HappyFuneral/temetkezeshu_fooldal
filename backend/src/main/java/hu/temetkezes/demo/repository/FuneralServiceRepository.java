package hu.temetkezes.demo.repository;

import hu.temetkezes.demo.models.FuneralService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuneralServiceRepository extends JpaRepository< FuneralService, Long> {
}
