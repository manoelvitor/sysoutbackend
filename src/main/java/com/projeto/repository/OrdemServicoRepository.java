package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.OrdemServico;
import com.projeto.model.Produto;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

	List<OrdemServico> findByIdEmpresa(Long idEmpresa);
	
	OrdemServico findByNrOrdemServico(Long id);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.cliente.cpf = ?1")
	List<OrdemServico> findByCpfCliente(String cpf);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.cliente.cnpj = ?1")
	List<OrdemServico> findByCnpjCliente(String cnpj);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.idEmpresa = ?1	AND os.cliente.nome LIKE %?2% ")
	List<OrdemServico> findByNomeCliente(Long idEmpresa, String nome);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.idEmpresa = ?1	AND os.categoria.nome = ?2 ")
	List<OrdemServico> findByNomeCategoria(Long idEmpresa, String nome);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.idEmpresa = ?1	AND os.status = ?2 ")
	List<OrdemServico> findByNomeStatus(Long idEmpresa, String status);
	
	@Query("SELECT os FROM OrdemServico os WHERE os.tecnicoResponsavel.id = ?1")
	List<OrdemServico> findByIdTecnico(Long id);
}
