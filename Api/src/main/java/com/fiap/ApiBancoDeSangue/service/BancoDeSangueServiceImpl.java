package com.fiap.ApiBancoDeSangue.service;

import com.fiap.ApiBancoDeSangue.dto.BancoDeSagueCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.BancoDeSangueDTO;
import com.fiap.ApiBancoDeSangue.entity.BancoDeSangue;
import com.fiap.ApiBancoDeSangue.repository.BancoDeSangueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BancoDeSangueServiceImpl implements IBancoDeSangueService {

    private BancoDeSangueRepository bancoDeSangueRepository;

    public BancoDeSangueServiceImpl(BancoDeSangueRepository bancoDeSangueRepository) {
        this.bancoDeSangueRepository = bancoDeSangueRepository;
    }

    @Override
    public List<BancoDeSangueDTO> findAll(String search) {
        String searchTerm = search == null ? "" : search;
        List<BancoDeSangueDTO> bancoDeSangueList = bancoDeSangueRepository.buscaPorNome(searchTerm)
                .stream()
                .map(bancoDeSangue -> new BancoDeSangueDTO(bancoDeSangue))
                .collect(Collectors.toList());

        return bancoDeSangueList;

    }

    @Override
    public BancoDeSangueDTO findById(Long id) {
        BancoDeSangue bancoDeSangue = getBancoDeSangueById(id);
        return  new BancoDeSangueDTO(bancoDeSangue);
    }

    @Override
    public BancoDeSangueDTO create(BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO) {

        BancoDeSangue bancoDeSangue = new BancoDeSangue(bancoDeSagueCreateUpdateDTO);
        BancoDeSangue savedBancoDeSangue = bancoDeSangueRepository.save(bancoDeSangue);

        return new BancoDeSangueDTO(savedBancoDeSangue);
    }

    @Override
    public BancoDeSangueDTO update(BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO, Long id) {
        BancoDeSangue bancoDeSangue = getBancoDeSangueById(id);
        bancoDeSangue.setNome(bancoDeSagueCreateUpdateDTO.getNome());
        bancoDeSangue.setEndereco(bancoDeSagueCreateUpdateDTO.getEndereco());
        bancoDeSangue.setTelefone(bancoDeSagueCreateUpdateDTO.getTelefone());
        bancoDeSangue.setDeficitSanguineo(bancoDeSagueCreateUpdateDTO.getDeficitSanguineo());
        bancoDeSangue.setEmail(bancoDeSagueCreateUpdateDTO.getEmail());

        BancoDeSangue bancoDeSangueSaved = bancoDeSangueRepository.save(bancoDeSangue);
        return new BancoDeSangueDTO(bancoDeSangueSaved);
    }

    @Override
    public void delete(Long id) {
        BancoDeSangue bancoDeSangue = getBancoDeSangueById(id);
        bancoDeSangue.setAtivo(false);
        bancoDeSangueRepository.save(bancoDeSangue);
    }

    private BancoDeSangue getBancoDeSangueById(Long id) {
        return bancoDeSangueRepository.findByIdAndAtivoIsTrue(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
