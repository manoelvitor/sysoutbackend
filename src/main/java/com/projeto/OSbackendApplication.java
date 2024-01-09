package com.projeto;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.model.Acessorio;
import com.projeto.model.Categoria;
import com.projeto.model.Cliente;
import com.projeto.model.InformacoesEmpresa;
import com.projeto.model.Servico;
import com.projeto.model.Situacao;
import com.projeto.model.Usuario;
import com.projeto.repository.AcessorioRepository;
import com.projeto.repository.CategoriaRepository;
import com.projeto.repository.InformacoesEmpresaRepository;
import com.projeto.repository.ServicoRepository;
import com.projeto.repository.SituacaoRepository;
import com.projeto.service.ClienteService;
import com.projeto.service.UsuarioService;

@SpringBootApplication
public class OSbackendApplication  implements CommandLineRunner{
	
	public static void main(String[] args) {
		
		SpringApplication.run(OSbackendApplication.class, args);	
	}
	
	@Autowired
	ServicoRepository servicoRepository;
	@Autowired
	AcessorioRepository acessorioRepository;
	@Autowired
	SituacaoRepository situacaoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	InformacoesEmpresaRepository empresaRepository;
	@Autowired
	ClienteService clienteService;

	@Override
	public void run(String... args) throws Exception {
		Servico s1 = new Servico();
		s1.setNome("FORMATAÇÃO WINDOWS");
		s1.setDescricao("Formatação para sistemas operacionais windows");
		s1.setValor(new BigDecimal("150.00"));
		
		Servico s2 = new Servico();
		s2.setNome("FORMATAÇÃO MAC");
		s2.setDescricao("Formatação para sistemas operacionais apple");
		s2.setValor(new BigDecimal("270.00"));
		
		Servico s3 = new Servico();
		s3.setNome("FORMATAÇÃO LINUX");
		s3.setDescricao("Formatação para sistemas operacionais linux");
		s3.setValor(new BigDecimal("150.00"));
		
		Servico s4 = new Servico();
		s4.setNome("INSTALAÇÃO HD/SSD DESKTOP");
		s4.setDescricao("Instalação hd ou ssd para desktops");
		s4.setValor(new BigDecimal("100.00"));
		
		Servico s5 = new Servico();
		s5.setNome("INSTALAÇÃO HD/SSD LAPTOPS");
		s5.setDescricao("Instalação hd ou ssd para laptops");
		s5.setValor(new BigDecimal("160.00"));
		
		Servico s6 = new Servico();
		s6.setNome("TROCA TELA LAPTOP");
		s6.setDescricao("Troca de tela laptops");
		s6.setValor(new BigDecimal("250.00"));
		
		Servico s7 = new Servico();
		s7.setNome("TROCA TECLADO LAPTOP");
		s7.setDescricao("Troca de teclado laptop");
		s7.setValor(new BigDecimal("180.00"));
		
		Servico s8 = new Servico();
		s8.setNome("INSTALAÇÃO MEMORIA RAM DESKTOP");
		s8.setDescricao("Instalação de memória ram para desktops");
		s8.setValor(new BigDecimal("80.00"));
		
		Servico s9 = new Servico();
		s9.setNome("INSTALAÇÃO MEMORIA RAM LAPTOPS");
		s9.setDescricao("Instalação de memória ram para laptops");
		s9.setValor(new BigDecimal("120.00"));
		
		Servico s10 = new Servico();
		s10.setNome("INSTALAÇÃO FONTE ATX");
		s10.setDescricao("Instalação de fonte atx para desktops");
		s10.setValor(new BigDecimal("80.00"));
		
		Servico s11 = new Servico();
		s11.setNome("INSTALAÇÃO FONTE ATX GAMER");
		s11.setDescricao("Instalação de fonte atx para desktops gamers");
		s11.setValor(new BigDecimal("160.00"));
		
		Servico s12 = new Servico();
		s12.setNome("MONTAGEM PC ESCRITORIO/COMERCIO");
		s12.setDescricao("Montagem de computadores de escritorio ou comércio");
		s12.setValor(new BigDecimal("200.00"));
		
		Servico s13 = new Servico();
		s13.setNome("MONTAGEM PC GAMER");
		s13.setDescricao("Montagem de computador gamer");
		s13.setValor(new BigDecimal("400.00"));
		
		Servico s14 = new Servico();
		s14.setNome("INSTALAÇÃO PLACA REDE/WIRELLES DESKTOP");
		s14.setDescricao("Instalação placa de redes e drivers necessários");
		s14.setValor(new BigDecimal("180.00"));
		
		Servico s15 = new Servico();
		s15.setNome("INSTALAÇÃO PLACA REDE/WIRELLES LAPTOP");
		s15.setDescricao("Instalação placa de rede e drivers necessários");
		s15.setValor(new BigDecimal("200.00"));
		
		Servico s16= new Servico();
		s16.setNome("BACKUP ATÉ 250 GIGAS");
		s16.setDescricao("Backup até 250 gigas");
		s16.setValor(new BigDecimal("200.00"));
		
		Servico s17 = new Servico();
		s17.setNome("BACKUP ATÉ 500 GIGAS");
		s17.setDescricao("Backup até 500 gigas");
		s17.setValor(new BigDecimal("300.00"));
		
		Servico s18 = new Servico();
		s18.setNome("BACKUP ATÉ 1 TERA");
		s18.setDescricao("Backup até 1000 gigas");
		s18.setValor(new BigDecimal("450.00"));
		
		s1.setIdEmpresa(1l);
		s2.setIdEmpresa(1l);
		s3.setIdEmpresa(1l);
		s4.setIdEmpresa(1l);
		s5.setIdEmpresa(1l);
		s6.setIdEmpresa(1l);
		s7.setIdEmpresa(1l);
		s8.setIdEmpresa(1l);
		s9.setIdEmpresa(1l);
		s10.setIdEmpresa(1l);
		s11.setIdEmpresa(1l);
		s12.setIdEmpresa(1l);
		s13.setIdEmpresa(1l);
		s14.setIdEmpresa(1l);
		s15.setIdEmpresa(1l);
		s16.setIdEmpresa(1l);
		s17.setIdEmpresa(1l);
		s18.setIdEmpresa(1l);

		
		servicoRepository.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18));
		
		
		Situacao st1 = new Situacao();
		st1.setNome("AGUARDANDO APROVAÇÃO");
		st1.setDescricao("Aguardando aprovação do cliente para dar andamento ao serviço");
		Situacao st2 = new Situacao();
		st2.setNome("AGUARDANDO RETIRADA");
		st2.setDescricao("Aguardando retirada do equipamento");
		Situacao st3 = new Situacao();
		st3.setNome("AGUARDANDO PEÇA PARA REPARO/REPOSIÇÃO");
		st3.setDescricao("Aguardando peça para reparo/reposição do equipamento");
		Situacao st4 = new Situacao();
		st4.setNome("SERVIÇO EFETUADO");
		st4.setDescricao("Serviço efetuado, aguardando retirada do cliente");
		Situacao st5 = new Situacao();
		st5.setNome("ORÇAMENTO REJEITADO");
		st5.setDescricao("Orçamento rejeitado, aguardando retirada do cliente");
		Situacao st6 = new Situacao();
		st6.setNome("SERVIÇO EM ANDAMENTO");
		st6.setDescricao("Técnico está efetuando o serviço");
		
		st1.setIdEmpresa(1l);
		st2.setIdEmpresa(1l);
		st3.setIdEmpresa(1l);
		st4.setIdEmpresa(1l);
		st5.setIdEmpresa(1l);
		st6.setIdEmpresa(1l);
		
		situacaoRepository.saveAll(Arrays.asList(st1,st2,st3,st4,st5,st6));
		
		Acessorio a1 = new Acessorio();
		a1.setNome("CABO DE ALIMENTAÇÃO ENERGIA DESKTOP");
		Acessorio a2 = new Acessorio();
		a2.setNome("CABO FONTE ALIMENTAÇÃO/CARREGADOR LAPTOP");
		Acessorio a3 = new Acessorio();
		a3.setNome("MOUSE");
		Acessorio a4 = new Acessorio();
		a4.setNome("TECLADO");
		Acessorio a5 = new Acessorio();
		a5.setNome("FONE/HEADSET");
		Acessorio a6 = new Acessorio();
		a6.setNome("HD EXTERNO");
		Acessorio a7 = new Acessorio();
		a7.setNome("PEN DRIVE");
		Acessorio a8 = new Acessorio();
		a8.setNome("CARTAO DE MEMÓRIA");
		
		a1.setIdEmpresa(1l);
		a2.setIdEmpresa(1l);
		a3.setIdEmpresa(1l);
		a4.setIdEmpresa(1l);
		a5.setIdEmpresa(1l);
		a6.setIdEmpresa(1l);
		a7.setIdEmpresa(1l);
		a8.setIdEmpresa(1l);
		
		acessorioRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8));
		
		
		Categoria c1 = new Categoria();
		c1.setNome("DESKTOP MICRO ATX");
		Categoria c2 = new Categoria();
		c2.setNome("DESKTOP MINI ATX");
		Categoria c3 = new Categoria();
		c3.setNome("DESKTOP GAMER");
		Categoria c4 = new Categoria();
		c4.setNome("LAPTOP NOTBOOK");
		Categoria c5 = new Categoria();
		c5.setNome("LAPTOP ULTRABOOK");
		Categoria c6 = new Categoria();
		c6.setNome("LAPTOP APPLE");
		Categoria c7 = new Categoria();
		c7.setNome("LAPTOP GAMER");
		
		c1.setIdEmpresa(1l);
		c2.setIdEmpresa(1l);
		c3.setIdEmpresa(1l);
		c4.setIdEmpresa(1l);
		c5.setIdEmpresa(1l);
		c6.setIdEmpresa(1l);
		c7.setIdEmpresa(1l);
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		
		InformacoesEmpresa empresaTeste = new InformacoesEmpresa();
		empresaTeste.setCnpj("80.734.117/0001-38");
		empresaTeste.setEmail("manoelvitor4g2@gmail.com");
		empresaTeste.setRazaoSocial("Sysout ME");
		empresaTeste.setNomeFantasia("Sysout Ordem de Serviço");
		empresaTeste.setSite("https://www.sysoutos.com.br/");
		empresaTeste.setEndereco("Rua inventada nº000, São Paulo/SP");
		empresaTeste.setTelefone("(13)99999-8888");
		empresaRepository.save(empresaTeste);
		
		
		Cliente cli1 = new Cliente();
		cli1.setNome("Wersi Cornell");
		cli1.setEmail("cli1@emailficiticio.com.brs");
		cli1.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli1.setTelefone("11999999999");
		cli1.setCnpj("00000000000000");
		cli1.setCpf("00000000000");
		cli1.setRg("000000000");

		Cliente cli2 = new Cliente();
		cli2.setNome("Wersi Cobain");
		cli2.setEmail("cli2@emailficiticio.com.brs");
		cli2.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli2.setTelefone("11999999999");
		cli2.setCnpj("00000000000000");
		cli2.setCpf("00000000000");
		cli2.setRg("000000000");


		Cliente cli3 = new Cliente();
		cli3.setNome("Duraromi Jackson");
		cli3.setEmail("cli3@emailficiticio.com.brs");
		cli3.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli3.setTelefone("11999999999");
		cli3.setCnpj("00000000000000");
		cli3.setCpf("00000000000");
		cli1.setRg("000000000");


		Cliente cli4 = new Cliente();
		cli4.setNome("Usut Joplin");
		cli4.setEmail("janis@emailficiticio.com.brs");
		cli4.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli4.setTelefone("11999999999");
		cli4.setCnpj("00000000000000");
		cli4.setCpf("00000000000");
		cli4.setRg("000000000");


		Cliente cli5 = new Cliente();
		cli5.setNome("Loidu da Silva");
		cli5.setEmail("tirasilva@emailficiticio.com.brs");
		cli5.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli5.setTelefone("11999999999");
		cli5.setCnpj("00000000000000");
		cli5.setCpf("00000000000");
		cli5.setRg("000000000");


		Cliente cli6 = new Cliente();
		cli6.setNome("Tigia Drumond Andrade");
		cli6.setEmail("drumond@emailficiticio.com.brs");
		cli6.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli6.setTelefone("11999999999");
		cli6.setCnpj("00000000000000");
		cli6.setCpf("00000000000");
		cli6.setRg("000000000");


		Cliente cli7 = new Cliente();
		cli7.setNome("Rodel Christina");
		cli7.setEmail("christina@emailficiticio.com.brs");
		cli7.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli7.setTelefone("11999999999");
		cli7.setCnpj("00000000000000");
		cli7.setCpf("00000000000");
		cli7.setRg("000000000");


		Cliente cli8 = new Cliente();
		cli8.setNome("Wacay Catra");
		cli8.setEmail("mariaalice@emailficiticio.com.brs");
		cli8.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli8.setTelefone("11999999999");
		cli8.setCnpj("00000000000000");
		cli8.setCpf("00000000000");
		cli8.setRg("000000000");


		Cliente cli9 = new Cliente();
		cli9.setNome("Dawima Carreiro");
		cli9.setEmail("carreirobeto@emailficiticio.com.brs");
		cli9.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli9.setTelefone("11999999999");
		cli9.setCnpj("00000000000000");
		cli9.setCpf("00000000000");
		cli9.setRg("000000000");


		Cliente cli10 = new Cliente();
		cli10.setNome("Kyamimea Wanehouse");
		cli10.setEmail("wanehouse@emailficiticio.com.brs");
		cli10.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli10.setTelefone("11999999999");
		cli10.setCnpj("00000000000000");
		cli10.setCpf("00000000000");
		cli10.setRg("000000000");


		Cliente cli11 = new Cliente();
		cli11.setNome("Keyzen Soares");
		cli11.setEmail("jo@emailficiticio.com.brs");
		cli11.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli11.setTelefone("11999999999");
		cli11.setCnpj("00000000000000");
		cli11.setCpf("00000000000");
		cli11.setRg("000000000");


		Cliente cli12 = new Cliente();
		cli12.setNome("Mecay Vicius");
		cli12.setEmail("cid@emailficiticio.com.brs");
		cli12.setEndereco("Rua dos bobos nº 0, Brasilía/DF");
		cli12.setTelefone("11999999999");
		cli12.setCnpj("00000000000000");
		cli12.setCpf("00000000000");
		cli12.setRg("000000000");
		
		cli1.setIdEmpresa(1l);
		cli2.setIdEmpresa(1l);
		cli3.setIdEmpresa(1l);
		cli4.setIdEmpresa(1l);
		cli5.setIdEmpresa(1l);
		cli6.setIdEmpresa(1l);
		cli7.setIdEmpresa(1l);
		cli8.setIdEmpresa(1l);
		cli9.setIdEmpresa(1l);
		cli10.setIdEmpresa(1l);
		cli11.setIdEmpresa(1l);
		cli12.setIdEmpresa(1l);
		
		
		clienteService.create(cli1);		
		clienteService.create(cli2);		
		clienteService.create(cli3);		
		clienteService.create(cli4);		
		clienteService.create(cli5);		
		clienteService.create(cli6);		
		clienteService.create(cli7);		
		clienteService.create(cli8);		
		clienteService.create(cli9);		
		clienteService.create(cli10);		
		clienteService.create(cli11);		
		clienteService.create(cli12);		
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin("manoel");
		usuario.setNome("Manoel Vitor");
		usuario.setEmail("manoelvitor4g2@gmail.com");
		usuario.setSenha("123");
		usuario.setCpf("00000000000");
		usuario.setRg("0000000000");
		usuario.setIdEmpresa(empresaTeste.getId());
		usuarioService.createAdm(usuario);
		
		
		
	}
	

}
