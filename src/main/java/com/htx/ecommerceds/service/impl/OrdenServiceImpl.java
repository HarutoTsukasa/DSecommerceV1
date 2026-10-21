package com.htx.ecommerceds.service.impl;

import com.htx.ecommerceds.model.DetalleOrden;
import com.htx.ecommerceds.model.Orden;
import com.htx.ecommerceds.repository.OrdenRepository;
import com.htx.ecommerceds.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;

    @Override
    public List<Orden> listarTodas() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden obtener(Long id) {
        return ordenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada: " + id));
    }

    /** @Transactional no es opcional aquí: hay varios inserts en cascada. */
    @Override
    @Transactional
    public Orden crear(Orden orden) {
        orden.setFecha(LocalDateTime.now());
        if (orden.getEstado() == null) {
            orden.setEstado("PENDIENTE");
        }
        BigDecimal total = BigDecimal.ZERO;
        for (DetalleOrden d : orden.getDetalles()) {
            d.setOrden(orden);
            total = total.add(d.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(d.getCantidad())));
        }
        orden.setTotal(total);
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional
    public Orden actualizarEstado(Long id, String nuevoEstado) {
        Orden o = obtener(id);
        o.setEstado(nuevoEstado);
        return ordenRepository.save(o);
    }

    @Override
    public void eliminar(Long id) {
        ordenRepository.deleteById(id);
    }
}