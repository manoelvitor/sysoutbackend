package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Historico;

@Repository
public interface HistoricoRepository  extends JpaRepository<Historico, Long>  {

}
