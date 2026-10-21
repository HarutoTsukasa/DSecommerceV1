// ProductoRepository.java
package com.htx.ecommerceds.repository;
import com.htx.ecommerceds.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Producto, Long> { }