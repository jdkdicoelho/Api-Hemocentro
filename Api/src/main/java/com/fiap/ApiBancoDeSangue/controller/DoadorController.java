package com.fiap.ApiBancoDeSangue.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import com.fiap.ApiBancoDeSangue.dto.DoadorCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.DoadorDTO;
import com.fiap.ApiBancoDeSangue.service.IDoadorService;

import io.swagger.v3.oas.annotations.Operation;

import com.fiap.ApiBancoDeSangue.config.ProducerConfig;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/doadores")
public class DoadorController {

    private final IDoadorService doadorService;

    public DoadorController(IDoadorService doadorService) {
        this.doadorService = doadorService;
    }


    @GetMapping
    @Operation(description = "Listagem de doadores")
    public List<DoadorDTO> findAll(@RequestParam(required = false, value = "nome") String nome) {
        return doadorService.findAll(nome);
    }

    @GetMapping("{id}")
    @Operation(description = "Recupera um doador por id")
    public DoadorDTO findById(@PathVariable Long id) {
        return doadorService.findById(id);
    }

    @PostMapping
    @Operation(description = "Cria um novo doador")
    @ResponseStatus(HttpStatus.CREATED)
    public DoadorDTO create(@RequestBody DoadorCreateUpdateDTO doadorCreateUpdateDTO) {
        RabbitAdmin admin = new RabbitAdmin(ProducerConfig.getConnection());
        Queue queueDoador = new Queue("drone.inf");

        final String exchange = "exchange.drone";

        admin.declareQueue(queueDoador);

        DirectExchange exchangeDoador = new DirectExchange(exchange);
        admin.declareExchange(exchangeDoador);

        admin.declareBinding(BindingBuilder.bind(queueDoador).to(exchangeDoador).with("inf"));

        RabbitTemplate template = new RabbitTemplate(ProducerConfig.getConnection());

        template.convertAndSend(exchange, "inf", doadorCreateUpdateDTO.getNome() + ";doador;"+doadorCreateUpdateDTO.getEmail());

        return doadorService.create(doadorCreateUpdateDTO);
    }

    @PutMapping("{id}")
    @Operation(description = "Atualiza um doador")
    public DoadorDTO update(@RequestBody DoadorCreateUpdateDTO doadorCreateUpdateDTO, @PathVariable Long id) {
        return doadorService.update(doadorCreateUpdateDTO, id);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Deleta um doador")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	doadorService.delete(id);
    }

}

