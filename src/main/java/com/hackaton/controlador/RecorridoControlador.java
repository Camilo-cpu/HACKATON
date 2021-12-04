
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
 *
 * @author Ale Giraldo
 */
@RestController
@RequestMapping("/api/recorrido")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RecorridoControlador {
    
    @Autowired
    RecorridoService recorridoService;
    
    @GetMapping("/all")
    public List<Recorridos> getAll(){
        return recorridoService.getAll();
    }
    
    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Recorridos save(@RequestBody Recorridos recorrido){
        return recorridoService.save(recorrido);
    }
    
    @GetMapping("/mayor")
    public Double estadisticasBasicas(){
        return recorridoService.resultadoMayor();
    }
    
    @GetMapping("{barrio}")
    public List<Recorridos> busquedaBarrio(@PathVariable("barrio") String barrio){
        return recorridoService.busquedaBarrio(barrio);
    }
}
