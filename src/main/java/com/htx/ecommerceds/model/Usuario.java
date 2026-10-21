package com.htx.ecommerceds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    /** Sin cifrar por ahora; Spring Security lo reemplazará con BCrypt. */
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 20)
    private String rol; // "ADMIN" | "CLIENTE"

    /** 1:N — Un usuario puede vender muchos productos. */
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

    /** 1:N — Un usuario puede tener muchas órdenes como comprador. */
    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Orden> ordenes = new ArrayList<>();
}