package com.htx.ecommerceds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	
	@Column(nullable = false, length = 5000)
	private String descripcion;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	@Column(length = 500)
	private String imagenUrl;

	@Column(nullable = false)
	private Integer stock;

	/** N:1 — Vendedor del producto. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id", nullable = false)
	private Usuario vendedor;

	/** 1:N — Un producto puede aparecer en muchos detalles de orden. */
	@OneToMany(mappedBy = "producto")
	@JsonIgnore
	private List<DetalleOrden> detalles = new ArrayList<>();
}