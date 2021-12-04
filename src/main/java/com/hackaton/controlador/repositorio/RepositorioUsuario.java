package com.hackaton.controlador.repositorio;
import com.hackaton.modelo.Usuario;
import com.hackaton.controlador.repositorio.crud.CrudRepositorioUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author IngSB
 */
@Repository
public class RepositorioUsuario {
    /**
     *
     * método para traer informacion del crud repository
     */
    @Autowired
    private CrudRepositorioUsuario crudRepositorioUsuario;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Usuario> getAll(){
        return (List<Usuario>) crudRepositorioUsuario.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */
    public Optional<Usuario> getUsuario(int id){
        return  crudRepositorioUsuario.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param usuario
     * @return 
     */
    public Usuario save(Usuario usuario){
        return crudRepositorioUsuario.save(usuario);
    }
    /**
     *
     * método para eliminar información
     * @param usuario
     */
    public void delete (Usuario usuario){
        crudRepositorioUsuario.delete(usuario);
    }   
}