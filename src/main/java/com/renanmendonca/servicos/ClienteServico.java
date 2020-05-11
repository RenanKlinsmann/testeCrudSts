package com.renanmendonca.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanmendonca.domain.Cliente;
import com.renanmendonca.domain.cliente.ClienteRepositorio;
import com.renanmendonca.dto.ClienteDto;
import com.renanmendonca.servicos.execoes.ExcecaoDeObjetosNaoEncontrados;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio repos;
	
	public List<Cliente> findAll() {
		return repos.findAll();
	}
	
	public Cliente findById(String id) {
		Optional<Cliente> obj = repos.findById(id);
		return obj.orElseThrow(() -> new ExcecaoDeObjetosNaoEncontrados("Objeto não encontrado"));
	}
	
	public Cliente insert(Cliente obj) {
		return repos.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repos.deleteById(id);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repos.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public Cliente fromDTO(ClienteDto objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), "", "", "", objDto.getEmail(), "", "", "", null, "", "", "", "");
	}
	
	
}
