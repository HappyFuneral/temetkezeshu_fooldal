package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.Office;
import hu.temetkezes.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfficeServiceImpl implements OfficeService{

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office getOfficeById(Long id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        return optionalOffice.orElse(null);
    }

    @Override
    public void saveOffice(Office office) {
        officeRepository.save(office);
    }

    @Override
    public void updateOffice(Office office) {
        officeRepository.save(office);
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }



    public List<Office> getOffices(){
        return officeRepository.findAll();
    }
}
