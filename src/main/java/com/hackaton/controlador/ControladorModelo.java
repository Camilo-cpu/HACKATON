package com.hackaton.controlador;

import com.hackaton.controlador.servicio.ServicioModelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author IngSB
 */
@RestController
@RequestMapping("/api/user")
public class ControladorModelo {
    @Autowired
    private ServicioModelo servicioModelo;
    
        @GetMapping("/all")
    public List<User> getAll() {
        return servicioModelo.getAll();
    }
    
}