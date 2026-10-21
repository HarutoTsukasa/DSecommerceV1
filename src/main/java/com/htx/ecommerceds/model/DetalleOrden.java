package com.htx.ecommerceds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_orden")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer cantidad;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precioUnitario;

	/** N:1 — Orden a la que pertenece. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orden_id", nullable = false)
	@JsonIgnore
	private Orden orden;

	/** N:1 — Producto referenciado. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;
}