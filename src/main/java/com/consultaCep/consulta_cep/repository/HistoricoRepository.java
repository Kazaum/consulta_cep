package com.consultaCep.consulta_cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultaCep.consulta_cep.entity.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long>{
    
}
