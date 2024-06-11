package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.Company;
import hu.temetkezes.demo.models.FuneralService;

import java.util.List;

public interface FuneralServiceService {

    FuneralService getById(Long id);
    void save(FuneralService funeralService);
    void update(FuneralService funeralService);
    void delete(Long id);

    List<FuneralService> getAll();
}
