package com.zegel.evc2.negocio;

import com.zegel.evc2.Entidades.Dispositivos;
import org.springframework.beans.factory.annotation.Autowired;
import com.zegel.evc2.repositorio.DRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DispositivosNegocio {
    @Autowired
    private DRepositorio dRepositorio;

    public Dispositivos Crear(Dispositivos dispositivos) {
        return dRepositorio.save(dispositivos);
    }

    public List<Dispositivos> LeerDispositivos() {
        return (List<Dispositivos>) dRepositorio.findAll();
    }

    public Dispositivos Actualizar(Dispositivos dispositivos) {
        Dispositivos d = dRepositorio.findById(dispositivos.getId()).get();
        if (d != null) {
            return dRepositorio.save(dispositivos);
        } else {
            return null;
        }
    }

    public Dispositivos BorrarDispositivos(Long id) {
        Dispositivos dispositivos = dRepositorio.findById(id).get();

        if (dispositivos != null) {
            dRepositorio.delete(dispositivos);
        } else {
            return null;
        }
        return dispositivos;
    }


}


