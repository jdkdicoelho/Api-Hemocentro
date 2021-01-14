package com.fiap.ApiBancoDeSangue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.ApiBancoDeSangue.dto.DoadorCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.DoadorDTO;
import com.fiap.ApiBancoDeSangue.entity.Doador;
import com.fiap.ApiBancoDeSangue.repository.DoadorRepository;


@Service
public class DoadorServiceImpl implements IDoadorService {

	private DoadorRepository doadorRepository;

	public DoadorServiceImpl(DoadorRepository doadorRepository) {
		this.doadorRepository = doadorRepository;
	}

	@Override
	public List<DoadorDTO> findAll(String search) {
		String searchTerm = search == null ? "" : search;
		List<DoadorDTO> doadorList = doadorRepository.buscaPorNome(searchTerm).stream()
				.map(doador -> new DoadorDTO(doador)).collect(Collectors.toList());

		return doadorList;

	}

	@Override
	public DoadorDTO findById(Long id) {
		Doador doador = getDoadorById(id);
		return new DoadorDTO(doador);
	}

	@Override
	public DoadorDTO create(DoadorCreateUpdateDTO doadorCreateUpdateDTO) {

		Doador doador = new Doador(doadorCreateUpdateDTO);
		Doador savedDoador = doadorRepository.save(doador);

		return new DoadorDTO(savedDoador);
	}

	@Override
	public DoadorDTO update(DoadorCreateUpdateDTO doadorCreateUpdateDTO, Long id) {
		Doador doador = getDoadorById(id);
		doador.setNome(doadorCreateUpdateDTO.getNome());
		doador.setIdade(doadorCreateUpdateDTO.getIdade());
		doador.setTiposanguineo(doadorCreateUpdateDTO.getTiposanguineo());
		doador.setRg(doadorCreateUpdateDTO.getRg());
		doador.setEmail(doadorCreateUpdateDTO.getEmail());

		Doador doadorSaved = doadorRepository.save(doador);
		return new DoadorDTO(doadorSaved);
	}

	@Override
	public void delete(Long id) {
		Doador doador = getDoadorById(id);
		doador.setAtivo(false);
		doadorRepository.save(doador);
	}

	private Doador getDoadorById(Long id) {
		return doadorRepository.findByIdAndAtivoIsTrue(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
