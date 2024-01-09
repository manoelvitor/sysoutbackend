package com.projeto.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.Historico;
import com.projeto.model.InformacoesTecnicaOs;
import com.projeto.model.OrdemServico;
import com.projeto.model.Produto;
import com.projeto.model.Resposta;
import com.projeto.model.Servico;
import com.projeto.model.enums.StatusOrdemServico;
import com.projeto.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoController implements ControllerInterface<OrdemServico> {

	@Autowired
	private OrdemServicoService service;

	@Override
	@GetMapping("/empresa/{idEmpresa}")
	public ResponseEntity<List<OrdemServico>> getAll(@PathVariable("idEmpresa") Long idEmpresa) {
		return ResponseEntity.ok(service.findAll(idEmpresa));
	}
	
	@GetMapping("/empresa/{idEmpresa}/cliente/nome/{nome}")
	public ResponseEntity<List<OrdemServico>> getByNomeCliente(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("nome") String nome) {
		return ResponseEntity.ok(service.findByNomeCliente(idEmpresa,nome));
	}
	
	@GetMapping("/empresa/{idEmpresa}/categoria/nome/{nome}")
	public ResponseEntity<List<OrdemServico>> getByNomeCategoria(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("nome") String nome) {
		return ResponseEntity.ok(service.findByNomeCategoria(idEmpresa,nome));
	}
	@GetMapping("/empresa/{idEmpresa}/status/{status}")
	public ResponseEntity<List<OrdemServico>> getByStatus(@PathVariable("idEmpresa") Long idEmpresa, @PathVariable("status") String status) {
		return ResponseEntity.ok(service.findByStatus(idEmpresa,status));
	}

	@GetMapping("/status")
	 public ResponseEntity<List<StatusOrdemServico>> getStatusList() {
        List<StatusOrdemServico> statusList = Arrays.asList(StatusOrdemServico.values());
        return ResponseEntity.ok(statusList);
    }
	
	@GetMapping("/tecnico/{id}")
	public ResponseEntity<?> findByIdTecnico(@PathVariable("id") Long id) {
		if (service.findByIdTecnico(id) != null)
			return ResponseEntity.ok(service.findByIdTecnico(id));
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Não há ordens de serviço com esse tecnico responsavel");
	}

	@GetMapping("/numero/{id}")
	public ResponseEntity<?> findByNrOrdemServico(@PathVariable("id") Long id) {
		if (service.findByNrOrdemServico(id) != null)
			return ResponseEntity.ok(service.findByNrOrdemServico(id));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de Servico não encontrada");
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<OrdemServico>> findByCpfCliente(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(service.findByCpfCliente(cpf));
	}

	@GetMapping("/cnpj/{cnpj}")
	public ResponseEntity<List<OrdemServico>> findByCnpjCliente(@PathVariable("cnpj") String cnpj) {
		return ResponseEntity.ok(service.findByCnpjCliente(cnpj));
	}

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		if (service.findById(id) != null)
			return ResponseEntity.ok(service.findById(id));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de Servico não encontrada");
	}

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@Override
	@PostMapping
	public ResponseEntity<OrdemServico> post(@RequestBody OrdemServico obj) {
		service.create(obj);
		service.geraNrOS(obj.getId());
		return ResponseEntity.ok(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody OrdemServico obj) {
		if (service.update(obj))
			return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel fazer a atualização");
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/transferir/{id}/{idTecnico}")
	public ResponseEntity<OrdemServico> transferirOrdemServico(@PathVariable Long id,@PathVariable Long idTecnico) {
		OrdemServico obj = service.findById(id);
		obj.setDataRepasse(LocalDateTime.now());
		if (service.transferirOrdemServico(id,idTecnico)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/historico/{id}")
	public ResponseEntity<List<Historico>> addHistorico(@PathVariable Long id, @RequestBody Historico historico) {
		service.addHistorico(id, historico);
		OrdemServico obj = service.findById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj.getHistorico());
	} 
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/servico/{idOs}/{idServ}")
	public ResponseEntity<List<Servico>> addServico(@PathVariable Long idOs, @PathVariable Long idServ) {
		service.addServico(idOs, idServ);
		OrdemServico obj = service.findById(idOs);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj.getServicosEfetuados());
	}   
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/produto/{idOs}/{idProd}")
	public ResponseEntity<List<Produto>> addProduto(@PathVariable Long idOs, @PathVariable Long idProd) {
		service.addProduto(idOs, idProd);
		OrdemServico obj = service.findById(idOs);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj.getProdutos());
	}  
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/infotec/{id}")
	public ResponseEntity<?> addInfoTec(@PathVariable Long id, @RequestBody InformacoesTecnicaOs infoTec) {
		service.infoTec(id, infoTec);
		return ResponseEntity.status(HttpStatus.CREATED).body("Adicionado com sucesso");
	} 
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/addprodutos/{id}")
	public ResponseEntity<?> addProdutos(@PathVariable Long id, @RequestBody List<Produto> produtos) {
		service.adicionarProdutos(id, produtos);
		return ResponseEntity.status(HttpStatus.CREATED).body("Adicionado com sucesso");
	} 

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/geranros/{id}")
	public ResponseEntity<?> geraNrOs(@PathVariable Long id) {
		service.geraNrOS(id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Nr gerado com sucesso");
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@PutMapping("/atualiza/geral/{id}")
	public ResponseEntity<?> atualizaInfGeral(@PathVariable Long id, @RequestBody OrdemServico os) {
		service.atualizarInfGeral(id, os);
		return ResponseEntity.status(HttpStatus.CREATED).body("Informações atualizadas com sucesso!");
	}

	@PreAuthorize("hasAnyRole('ADMIN','TECNICO')")
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Resposta> delete(@PathVariable("id") Long id) {
		OrdemServico obj = service.findById(id);
		if (service.delete(id)) {

			Resposta resposta = new Resposta("Deletado com sucesso!");

			return ResponseEntity.ok().body(resposta);
		}
			Resposta resposta = new Resposta("Falha ao deletar!");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
	}
	
	

}
