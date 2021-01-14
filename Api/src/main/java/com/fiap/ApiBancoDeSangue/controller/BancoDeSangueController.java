package com.fiap.ApiBancoDeSangue.controller;

import com.fiap.ApiBancoDeSangue.config.ProducerConfig;
import com.fiap.ApiBancoDeSangue.dto.BancoDeSagueCreateUpdateDTO;
import com.fiap.ApiBancoDeSangue.dto.BancoDeSangueDTO;
import com.fiap.ApiBancoDeSangue.service.IBancoDeSangueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/bancos-de-sangue")
public class BancoDeSangueController {

    private final IBancoDeSangueService bancoDeSangueService;

    public BancoDeSangueController(IBancoDeSangueService bancoDeSangueService) {
        this.bancoDeSangueService = bancoDeSangueService;
    }


    @GetMapping
    @Operation(description = "Listagem de bancos de sangue")
    public List<BancoDeSangueDTO> findAll(@RequestParam(required = false, value = "nome") String nome) {
        return bancoDeSangueService.findAll(nome);
    }

    @GetMapping("{id}")
    @Operation(description = "Recupera um bancos de sangue por id")
    public BancoDeSangueDTO findById(@PathVariable Long id) {
        return bancoDeSangueService.findById(id);
    }

    @PostMapping
    @Operation(description = "Cria um novo bancos de sangue")
    @ResponseStatus(HttpStatus.CREATED)
    public BancoDeSangueDTO create(@RequestBody BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO) {
        RabbitAdmin admin = new RabbitAdmin(ProducerConfig.getConnection());
        Queue queueDoador = new Queue("drone.inf");

        final String exchange = "exchange.drone";

        admin.declareQueue(queueDoador);

        DirectExchange exchangeDoador = new DirectExchange(exchange);
        admin.declareExchange(exchangeDoador);

        admin.declareBinding(BindingBuilder.bind(queueDoador).to(exchangeDoador).with("inf"));

        RabbitTemplate template = new RabbitTemplate(ProducerConfig.getConnection());

        template.convertAndSend(exchange, "inf", bancoDeSagueCreateUpdateDTO.getNome() + ";hemocentro;"+bancoDeSagueCreateUpdateDTO.getEmail());
        return bancoDeSangueService.create(bancoDeSagueCreateUpdateDTO);
    }

    @PutMapping("{id}")
    @Operation(description = "Atualiza um banco de sangue")
    public BancoDeSangueDTO update(@RequestBody BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO, @PathVariable Long id) {
        return bancoDeSangueService.update(bancoDeSagueCreateUpdateDTO, id);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Deleta um banco de sangue")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bancoDeSangueService.delete(id);
    }

}
