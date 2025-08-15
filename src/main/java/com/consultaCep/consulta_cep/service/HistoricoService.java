package com.consultaCep.consulta_cep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consultaCep.consulta_cep.entity.Historico;
import com.consultaCep.consulta_cep.repository.HistoricoRepository;

@Service
public class HistoricoService {
    @Value("${viacep.url}")
    private String viaCepUrl;
    private HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public Historico create(String cep){
        RestTemplate rest= new RestTemplate();
        ResponseEntity<Historico> response = 
            rest.getForEntity(
                String.format(
                    viaCepUrl, cep)
                , Historico.class);
        return historicoRepository.save(response.getBody());
    }

    public List<Historico> read(){
        Sort sort = Sort.by("dataConsulta").descending();
        return historicoRepository.findAll(sort);
    }

    public Historico update(Historico historico){
        return historicoRepository.save(historico);
    }

    public List<Historico> delete(Long id){
        historicoRepository.deleteById(id);
        return read();
    }
}
