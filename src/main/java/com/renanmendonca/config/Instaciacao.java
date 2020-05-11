package com.renanmendonca.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renanmendonca.domain.Cliente;
import com.renanmendonca.domain.cliente.ClienteRepositorio;

@Configuration
public class Instaciacao implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		clienteRepositorio.deleteAll();
		
		Cliente renan = new Cliente(null, "Renan", "cpf", "rg", "dataNascimento", "renan@renan.com", "telefone", "cep", "endereço", 0, "bairro", "cidade", "uf", "pais");
		Cliente robert = new Cliente(null, "Robert", "cpf", "rg", "dataNascimento", "robert@robert.com", "telefone", "cep", "endereço", 0, "bairro", "cidade", "uf", "pais");
		
		clienteRepositorio.saveAll(Arrays.asList(renan, robert));
		
	}

}
