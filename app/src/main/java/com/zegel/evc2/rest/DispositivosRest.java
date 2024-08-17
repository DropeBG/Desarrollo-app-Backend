package com.zegel.evc2.rest;

import com.zegel.evc2.Entidades.Dispositivos;
import com.zegel.evc2.Entidades.seguridad.User;
import com.zegel.evc2.negocio.DispositivosNegocio;
import com.zegel.evc2.negocio.UserNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivosRest {
    @Autowired
    private DispositivosNegocio dispositivosNegocio;
    @Autowired
    private UserNegocio userNegocio;


    @PostMapping("/dispositivo")
    public Dispositivos Crear(@RequestBody Dispositivos dispositivos) {
        return dispositivosNegocio.Crear(dispositivos);
    }

    @GetMapping("dispositivos")
    public List<Dispositivos> LeerDispositivos() {
        try {
            return dispositivosNegocio.LeerDispositivos();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("/actualizar")
    public Dispositivos Actualizar(@RequestBody Dispositivos dispositivos){
        try{
            return dispositivosNegocio.Actualizar(dispositivos);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar");
        }
    }

    @DeleteMapping("/dispositivos/{id}")
    public Dispositivos BorrarDispositivos(@PathVariable(value = "id") Long id){
        return dispositivosNegocio.BorrarDispositivos(id);
    }

    @PostMapping("/service/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = userNegocio.grabar(user);
        return ResponseEntity.ok("User created successfully with id: " + newUser.getId());
    }

    @GetMapping("/service/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userNegocio.obtenerUsuarios();
        return ResponseEntity.ok(users);
    }

    }
