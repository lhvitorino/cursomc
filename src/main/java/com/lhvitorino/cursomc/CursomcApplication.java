package com.lhvitorino.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lhvitorino.cursomc.domain.Categoria;
import com.lhvitorino.cursomc.domain.Cidade;
import com.lhvitorino.cursomc.domain.Cliente;
import com.lhvitorino.cursomc.domain.Endereco;
import com.lhvitorino.cursomc.domain.Estado;
import com.lhvitorino.cursomc.domain.Produto;
import com.lhvitorino.cursomc.domain.enums.TipoCliente;
import com.lhvitorino.cursomc.repositories.CategoriaRepository;
import com.lhvitorino.cursomc.repositories.CidadeRepository;
import com.lhvitorino.cursomc.repositories.ClienteRepository;
import com.lhvitorino.cursomc.repositories.EnderecoRepository;
import com.lhvitorino.cursomc.repositories.EstadoRepository;
import com.lhvitorino.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "657.890.324-00", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("98345-4567","99345-8976"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "143", "Ap-104", "Jardins", "88904-78", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "901", "Sala 800", "Centro", "83456-90", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
