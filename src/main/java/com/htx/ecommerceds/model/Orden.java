package com.htx.ecommerceds.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime fecha;

	/** PENDIENTE | ENVIADO | ENTREGADO | CANCELADO */
	@Column(nullable = false, length = 20)
	private String estado;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal total;

	/** N:1 — Comprador. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comprador_id", nullable = false)
	private Usuario comprador;

	/** 1:N — Líneas de la orden. */
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleOrden> detalles = new ArrayList<>();
}