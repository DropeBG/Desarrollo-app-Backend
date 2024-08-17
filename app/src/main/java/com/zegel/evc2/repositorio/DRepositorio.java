package com.zegel.evc2.repositorio;

import com.zegel.evc2.Entidades.Dispositivos;
import org.springframework.data.repository.CrudRepository;

public interface DRepositorio extends CrudRepository<Dispositivos, Long> {
    }