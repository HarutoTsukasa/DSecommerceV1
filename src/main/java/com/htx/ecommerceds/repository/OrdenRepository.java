// OrdenRepository.java
package com.htx.ecommerceds.repository;
import com.htx.ecommerceds.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrdenRepository extends JpaRepository<Orden, Long> { }