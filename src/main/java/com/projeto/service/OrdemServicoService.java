package com.projeto.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Cliente;
import com.projeto.model.Historico;
import com.projeto.model.InformacoesTecnicaOs;
import com.projeto.model.OrdemServico;
import com.projeto.model.Produto;
import com.projeto.model.Servico;
import com.projeto.model.Usuario;
import com.projeto.repository.ClienteRepository;
import com.projeto.repository.HistoricoRepository;
import com.projeto.repository.InformacoesTecnicaOsRepository;
import com.projeto.repository.OrdemServicoRepository;
import com.projeto.repository.UsuarioRepository;

@Service
public class OrdemServicoService implements ServiceInterface<OrdemServico> {


	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired
	private HistoricoRepository histRepository;
	
	@Autowired
	private InformacoesTecnicaOsRepository infTecRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public OrdemServico create(OrdemServico obj) {
		repository.save(obj);
		InformacoesTecnicaOs info = new InformacoesTecnicaOs();
		info.setIdEmpresa(obj.getIdEmpresa());
		info.setHardDisk(false);
		info.setSsd(false);
		infoTec(obj.getId(), info);
		obj.setInfoTec(info);
		return repository.save(obj);
	}

	@Override
	public OrdemServico findById(Long id) {
		Optional<OrdemServico> _ordemServico = repository.findById(id);
		return _ordemServico.orElse(null);	
	}
	
	public List<OrdemServico> findByIdTecnico(Long id) {
		return repository.findByIdTecnico(id);	
	}
	
	public List<OrdemServico> findByNomeCliente(Long idEmpresa, String nome) {
		return repository.findByNomeCliente(idEmpresa,nome.toUpperCase());	
	}
	
	public List<OrdemServico> findByStatus(Long idEmpresa, String status) {
		return repository.findByNomeStatus(idEmpresa,status);	
	}
	
	public List<OrdemServico> findByNomeCategoria(Long idEmpresa, String nome) {
		return repository.findByNomeCategoria(idEmpresa,nome.toUpperCase());	
	}

	public OrdemServico findByNrOrdemServico(Long nrOs) {
		return repository.findByNrOrdemServico(nrOs);	
	}
	
	public List<OrdemServico> findByCpfCliente(String cpf) {
		return repository.findByCpfCliente(cpf);	
	}
	
	public List<OrdemServico> findByCnpjCliente(String cnpj) {
		return repository.findByCnpjCliente(cnpj);	
	}

	@Override
	public List<OrdemServico> findAll(Long idEmpresa) {
		return repository.findByIdEmpresa(idEmpresa);
	}

	@Override
	public boolean update(OrdemServico obj) {
		if(repository.existsById(obj.getId())){
			repository.save(obj);
			return true;
		}
		return false;
	}
	
	
	public boolean transferirOrdemServico(Long id, Long idTecnico) {
		if(repository.findById(id) != null) {
			OrdemServico obj = repository.findById(id).get();
			obj.setTecnicoResponsavelAnterior(obj.getTecnicoResponsavel());
			Usuario tecnico = usuarioRepository.findById(idTecnico).get();
			obj.setTecnicoResponsavel(tecnico);
			repository.save(obj);
			return true;	
		}	
		return false;
	}
	
	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}	
	
	public Historico addHistorico(Long id, Historico historico) {
		Historico  hist = new Historico(historico.getSituacao(), historico.getInformacao());
		Historico histSalvo =  histRepository.save(hist);
		OrdemServico obj = repository.findById(id).get();
		obj.getHistorico().add(histSalvo);
		obj.setSituacaoAtual(histSalvo.getSituacao());
		repository.save(obj);
		return histSalvo;
	}
	
	public Servico addServico(Long id, Long idServico) {
		Servico servico = servicoService.findById(idServico);
		OrdemServico os = repository.findById(id).get();
		os.getServicosEfetuados().add(servico);
		update(os);
		return servico;
	}
	
	public Produto addProduto(Long id, Long idProduto) {
		Produto produto = produtoService.findById(idProduto);
		OrdemServico os = repository.findById(id).get();
		os.getProdutos().add(produto);
		update(os);
		return produto;
	}
	
	public InformacoesTecnicaOs infoTec(Long id, InformacoesTecnicaOs info) {	
		InformacoesTecnicaOs infoTecSalvo = infTecRepository.save(info);
		OrdemServico obj = repository.findById(id).get();
		obj.setInfoTec(infoTecSalvo);
		repository.save(obj);
		return infoTecSalvo;
	}
	
	public List<Produto> adicionarProdutos(Long id, List<Produto> produtos) {	
		OrdemServico obj = repository.findById(id).get();
		obj.getProdutos().addAll(produtos);
		repository.save(obj);
		return produtos;
	}
	
	public String geraNrOS(Long id) {
		OrdemServico os = repository.getById(id);
		String nrOS = "";
		nrOS = os.getCliente().getId().toString() +  os.getTecnicoResponsavel().getId().toString() + os.getId();
		os.setNrOrdemServico(Long.parseLong(nrOS));
		repository.save(os);
		return nrOS;
	}
	
	public OrdemServico atualizarInfGeral(Long id, OrdemServico osAtualizado) {
		OrdemServico os = repository.findById(id).get();
		os.setCliente(osAtualizado.getCliente());
		os.setMarca(osAtualizado.getMarca());
		os.setModelo(osAtualizado.getModelo());
		os.setNrSerie(osAtualizado.getNrSerie());
		os.setCategoria(osAtualizado.getCategoria());
		os.setAcessorios(osAtualizado.getAcessorios());
		os.setDsDefeitoCliente(osAtualizado.getDsDefeitoCliente());
		os.setDsDefeitoTecnico(osAtualizado.getDsDefeitoTecnico());
		os.setOsbservacao(osAtualizado.getOsbservacao());
		repository.save(os);
		return os;
	}
	
	
//	public void calculaOs(OrdemServico os) {
//		BigDecimal valor = new BigDecimal(0);
//			for(Produto produto : os.getProdutos()) {
//				valor.add(produto.getValor() != null ? produto.getValor() : new BigDecimal(0));
//			
//		}
//			for(Servico servico : os.getServicosEfetuados()) {
//				valor.add(servico.getValor() != null ? servico.getValor() : new BigDecimal(0));
//			} 
//		
//			valor.add(os.getValorOrcamento());
//		
//			valor.subtract(os.getValorDesconto());
//		
//		os.setValorTotal(valor);
//	}
}
