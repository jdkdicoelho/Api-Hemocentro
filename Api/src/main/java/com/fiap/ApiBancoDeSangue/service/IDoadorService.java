package com.fiap.ApiBancoDeSangue.service;

import java.util.List;

import com.fiap.ApiBancoDeSangue.dto.DoadorCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.DoadorDTO;

public interface IDoadorService {


	List<DoadorDTO> findAll(String search);

	DoadorDTO findById(Long id);

	DoadorDTO create(DoadorCreateUpdateDTO doadorCreateUpdateDTO);

	DoadorDTO update(DoadorCreateUpdateDTO doadorCreateUpdateDTO, Long id);

	void delete(Long id);
}

