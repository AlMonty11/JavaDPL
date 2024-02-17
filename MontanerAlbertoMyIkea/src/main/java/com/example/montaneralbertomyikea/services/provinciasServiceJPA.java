package com.example.montaneralbertomyikea.services;

import com.example.montaneralbertomyikea.interfaces.provinciasService;
import com.example.montaneralbertomyikea.models.MunicipiosEntity;
import com.example.montaneralbertomyikea.models.ProvinciasEntity;
import com.example.montaneralbertomyikea.repositories.municipiosRepository;
import com.example.montaneralbertomyikea.repositories.provinciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class provinciasServiceJPA implements provinciasService {
    @Autowired
    private provinciasRepository pr;
    @Override
    public List<ProvinciasEntity> listarProvincias() {
        return pr.findAll();
    }

}
