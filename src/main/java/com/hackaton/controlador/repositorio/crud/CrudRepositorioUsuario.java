package com.hackaton.controlador.repositorio.crud;
import com.hackaton.modelo.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author IngSB
 */
/**
 *
 * Interface Crud repositorio para la entidad usuarioooooo
 */
public interface CrudRepositorioUsuario extends CrudRepository<Usuario,Integer>{
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndContrasena (String email,String contrasena);
}