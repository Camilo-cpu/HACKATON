
package com.hackaton.controlador;

import com.hackaton.controlador.servicio.RecorridoService;
import com.hackaton.modelo.Recorridos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que construye las peticiones API a usar
 * @author Alejandro Giraldo
 */
@RestController
@RequestMapping("/api/recorrido")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RecorridoControlador {
    
    /**
     * Inyección de la clase RecorridoService
     */
    @Autowired
    RecorridoService recorridoService;
    
    /**
     * Petición /all
     * @return retorna todos los recorridos realizados
     */
    @GetMapping("/all")
    public List<Recorridos> getAll(){
        return recorridoService.getAll();
    }
    
    /**
     * Petición /nuevo, guarda un recorrido nuevo
     * @param recorrido recorrido a guardar en JSON
     * @return Código de estado 201
     */
    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Recorridos save(@RequestBody Recorridos recorrido){
        return recorridoService.save(recorrido);
    }
    
    /**
     * Petición /{barrio}, busca los recorridos realizados en un barrio
     * @param barrio barrio a buscar
     * @return JSON con los recorridos realizados en el barrio
     */
    @GetMapping("/{barrio}")
    public List<Recorridos> busquedaBarrio(@PathVariable("barrio") String barrio){
        return recorridoService.busquedaBarrio(barrio);
    }
}
