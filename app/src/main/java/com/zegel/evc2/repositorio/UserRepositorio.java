package com.zegel.evc2.repositorio;

import com.zegel.evc2.Entidades.seguridad.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorio extends CrudRepository<User, Long> {
    User findByUsername(String username);
}