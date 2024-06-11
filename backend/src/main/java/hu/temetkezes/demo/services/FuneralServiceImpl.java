package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.FuneralService;
import hu.temetkezes.demo.repository.FuneralServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuneralServiceImpl implements FuneralServiceService {
    private final FuneralServiceRepository funeralServiceRepository;

    @Autowired
    public FuneralServiceImpl(FuneralServiceRepository funeralServiceRepository) {
        this.funeralServiceRepository = funeralServiceRepository;
    }


    @Override
    public FuneralService getById(Long id) {
        return funeralServiceRepository.findById(id).orElse(null);
    }


    @Override
    public void save(FuneralService funeralService) {
        funeralServiceRepository.save(funeralService);
    }

    @Override
    public void update(FuneralService funeralService) {
        funeralServiceRepository.save(funeralService);
    }

    @Override
    public void delete(Long id) {
        funeralServiceRepository.deleteById(id);
    }

    @Override
    public List<FuneralService> getAll() {
        return funeralServiceRepository.findAll();
    }
}
