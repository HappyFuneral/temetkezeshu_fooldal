package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.Company;

import java.util.List;

public interface CompanyService {

    Company getById(Long id);
    void save(Company company);
    void update(Company company);
    void delete(Long id);

    List<Company> getAll();
}
