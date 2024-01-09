package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.InformacoesTecnicaOs;

@Repository
public interface InformacoesTecnicaOsRepository extends JpaRepository<InformacoesTecnicaOs,Long>  {

}
