package com.htx.ecommerceds.service;

import com.htx.ecommerceds.model.Orden;
import java.util.List;

/** Contrato de operaciones sobre órdenes de compra. */
public interface OrdenService {

    List<Orden> listarTodas();

    /** Lanza IllegalArgumentException si el id no existe. */
    Orden obtener(Long id);

    /** Crea una orden calculando el total a partir de sus detalles y fecha actual. */
    Orden crear(Orden orden);

    /** Cambia el estado de una orden; no valida que la transición sea legítima. */
    Orden actualizarEstado(Long id, String nuevoEstado);

    void eliminar(Long id);
}