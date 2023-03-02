package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.MvtStkDto;

import java.util.List;

public interface MvtStockService {
    MvtStkDto save(MvtStkDto mvtStkDto);

    MvtStkDto findById(Integer id);

    MvtStkDto findByCode(String code);

    List<MvtStkDto> findAll();

    void delete(Integer id);
}
