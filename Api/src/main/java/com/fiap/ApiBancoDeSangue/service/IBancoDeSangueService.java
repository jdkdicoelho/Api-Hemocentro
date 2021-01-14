package com.fiap.ApiBancoDeSangue.service;

import java.util.List;

import com.fiap.ApiBancoDeSangue.dto.BancoDeSagueCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.BancoDeSangueDTO;
import com.fiap.ApiBancoDeSangue.dto.DoadorDTO;

public interface IBancoDeSangueService {

    List<BancoDeSangueDTO> findAll(String search);

    BancoDeSangueDTO findById(Long id);

    BancoDeSangueDTO create(BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO);

    BancoDeSangueDTO update(BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO, Long id);

    void delete(Long id);
}
