package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.Company;
import hu.temetkezes.demo.repository.CompanyRepository;
import hu.temetkezes.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServImpl implements CompanyService
{
private final CompanyRepository companyRepository;

@Autowired
public CompanyServImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
}


@Override
public Company getById(Long id) {
    return companyRepository.findById(id).orElse(null);
}

@Override
public void save(Company company) {
    companyRepository.save(company);
}

@Override
public void update(Company company) {
    companyRepository.save(company);
}

@Override
public void delete(Long id) {
    companyRepository.deleteById(id);
}

@Override
public List<Company> getAll() {
    return companyRepository.findAll();
}
}
