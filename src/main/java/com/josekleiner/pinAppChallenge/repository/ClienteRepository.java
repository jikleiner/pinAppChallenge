package com.josekleiner.pinAppChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josekleiner.pinAppChallenge.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
