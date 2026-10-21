package com.htx.ecommerceds.service.impl;

import com.htx.ecommerceds.model.DetalleOrden;
import com.htx.ecommerceds.repository.DetalleOrdenRepository;
import com.htx.ecommerceds.service.DetalleOrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public List<DetalleOrden> listarTodos() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public DetalleOrden obtener(Long id) {
        return detalleOrdenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de orden no encontrado: " + id));
    }

    @Override
    public DetalleOrden guardar(DetalleOrden detalle) {
        return detalleOrdenRepository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        detalleOrdenRepository.deleteById(id);
    }
}