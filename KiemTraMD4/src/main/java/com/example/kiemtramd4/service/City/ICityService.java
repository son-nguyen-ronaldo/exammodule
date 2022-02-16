package com.example.kiemtramd4.service.City;

import com.example.kiemtramd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    public List<City> findAll();
    public Page<City> findAll(Pageable pageable);
    public void save(City city);
    public void delete(long id);
    public Optional<City> findByID(long id);
    public List<City> findByName(String name);
}
