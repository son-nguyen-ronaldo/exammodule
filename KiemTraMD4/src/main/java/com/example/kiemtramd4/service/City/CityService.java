package com.example.kiemtramd4.service.City;

import com.example.kiemtramd4.model.City;
import com.example.kiemtramd4.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityService implements ICityService {
    @Autowired
    ICityRepo cityRepo;

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepo.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    public void delete(long id) {
        cityRepo.deleteById(id);
    }

    @Override
    public Optional<City> findByID(long id) {
        return cityRepo.findById(id);
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }
}
