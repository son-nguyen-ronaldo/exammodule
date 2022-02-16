package com.example.kiemtramd4.service.Nation;

import com.example.kiemtramd4.model.Nation;
import com.example.kiemtramd4.repository.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NationService implements INationService{
    @Autowired
    INationRepo nationRepo;
    @Override
    public List<Nation> findAll() {
        return (List<Nation>) nationRepo.findAll();
    }

    @Override
    public Nation findById(long id) {
        return nationRepo.findById(id).get();
    }
}
