// DetalleOrdenRepository.java
package com.htx.ecommerceds.repository;
import com.htx.ecommerceds.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> { }