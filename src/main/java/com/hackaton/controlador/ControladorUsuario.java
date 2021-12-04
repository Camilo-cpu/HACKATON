package com.hackaton.controlador;
import com.hackaton.controlador.servicio.ServicioUsuario;
import com.hackaton.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author IngSB
 */
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class ControladorUsuario {        
    /**
     *
     * Método para traer los datos desde Servicios hacia la URL
     */ 
    @Autowired
    private ServicioUsuario servicioUsuario;    
    /**
     *
     * Método para mostrar los datos de la base de datos mediante URL
     * @return 
     */ 
    
    @GetMapping("/all")
    public List<Usuario> getAll() {
        return servicioUsuario.getAll();
    }

    /**
     *
     * Método para mostrar un objeto específico de la base de datos mediante URL
     * @param id
     * @return 
     */    
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id){
        return servicioUsuario.getUsuario(id);
    }
    /**
     *
     * Método para guardar información en la base de datos mediante URL
     * @param usuario
     * @return 
     */ 
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return servicioUsuario.save(usuario);
    }
    /**
     *
     * Método para actualizar información en la base de datos mediante URL
     * @param usuario
     * @return 
     */ 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario){
        return servicioUsuario.update(usuario);
    }    
    /**
     *
     * Método para eliminar información en la base de datos mediante URL
     * @param usuarioId
     * @return 
     */ 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuario(@PathVariable("id") int usuarioId){
        return servicioUsuario.deleteUsuario(usuarioId);
    }
}