package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.InformacoesEmpresa;

@Repository
public interface InformacoesEmpresaRepository extends JpaRepository<InformacoesEmpresa, Long> {

}
