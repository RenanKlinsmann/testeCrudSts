package com.renanmendonca.domain.cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.renanmendonca.domain.Cliente;

@Repository
public interface ClienteRepositorio extends MongoRepository<Cliente, String>  {

}
