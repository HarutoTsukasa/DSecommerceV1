// ProductoRepository.java
package com.htx.ecommerceds.repository;

import com.htx.ecommerceds.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Override
	@EntityGraph(attributePaths = { "vendedor" })
	List<Producto> findAll();
}