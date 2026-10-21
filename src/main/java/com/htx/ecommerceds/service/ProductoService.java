package com.htx.ecommerceds.service;

import com.htx.ecommerceds.model.Producto;
import java.util.List;

/** Contrato de operaciones sobre productos. */
public interface ProductoService {

    List<Producto> listarTodos();

    /** Lanza IllegalArgumentException si el id no existe. */
    Producto obtener(Long id);

    /** Persiste un producto nuevo o actualiza uno existente (id no nulo). */
    Producto guardar(Producto producto);

    /** Falla silenciosamente si el id no existe; usa obtener(id) si necesitas validar. */
    void eliminar(Long id);
}