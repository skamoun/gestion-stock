package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.FournisseurDto;
import com.kamoun.gestiondestock.repository.FournisseurRepository;
import com.kamoun.gestiondestock.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return null;
    }

    @Override
    public FournisseurDto findByCode(String code) {
        return null;
    }

    @Override
    public List<FournisseurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
