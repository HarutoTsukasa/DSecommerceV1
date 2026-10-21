package com.htx.ecommerceds.service;

import com.htx.ecommerceds.model.DetalleOrden;
import java.util.List;

/**
 * Contrato de operaciones sobre líneas de orden.
 * Normalmente se gestionan en cascada desde Orden, pero se exponen
 * aquí para operaciones puntuales (ajustes, migraciones, borrados manuales).
 */
public interface DetalleOrdenService {

    List<DetalleOrden> listarTodos();

    /** Lanza IllegalArgumentException si el id no existe. */
    DetalleOrden obtener(Long id);

    DetalleOrden guardar(DetalleOrden detalle);

    void eliminar(Long id);
}