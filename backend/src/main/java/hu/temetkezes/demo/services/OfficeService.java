package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.Office;

import java.util.List;


public interface OfficeService {
    Office getOfficeById(Long id);
    void saveOffice(Office office);
    void updateOffice(Office office);
    void deleteOffice(Long id);


    List<Office> getOffices();
}
