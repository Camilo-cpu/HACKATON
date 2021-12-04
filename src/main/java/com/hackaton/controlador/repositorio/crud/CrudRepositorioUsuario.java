package com.hackaton.controlador.repositorio.crud;
import com.hackaton.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author IngSB
 */
/**
 *
 * Interface Crud repositorio para la entidad Usuario
 */
public interface CrudRepositorioUsuario extends CrudRepository<Usuario,Integer>{
    /**
     *
     * Interface Crud repositorio para la entidad Machine (máquina) vacío intencionalmente
     */  
    
}