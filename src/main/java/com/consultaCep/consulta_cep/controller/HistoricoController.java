package com.consultaCep.consulta_cep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultaCep.consulta_cep.entity.Historico;
import com.consultaCep.consulta_cep.service.HistoricoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/historico")
public class HistoricoController {
    private HistoricoService historicoService;
    
    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    @PostMapping
    Historico create(@RequestBody Historico historico){
        return historicoService.create(historico.getCep());
    }

    @GetMapping
    List<Historico> read(){
        return historicoService.read();
    }

    @PutMapping
    Historico update(@RequestBody Historico historico){
        return historicoService.update(historico);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id){
        historicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
