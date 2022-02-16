package com.example.kiemtramd4.service.Nation;

import com.example.kiemtramd4.model.Nation;

import java.util.List;

public interface INationService {
    public List<Nation> findAll();
    public Nation findById(long id);
}
