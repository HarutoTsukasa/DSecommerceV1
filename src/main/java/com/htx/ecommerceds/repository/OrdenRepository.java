// OrdenRepository.java
package com.htx.ecommerceds.repository;

import com.htx.ecommerceds.model.Orden;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

	@Override
	@EntityGraph(attributePaths = { "comprador" })
	List<Orden> findAll();

}