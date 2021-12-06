package com.hackaton.controlador.servicio;
import com.hackaton.controlador.repositorio.RepositorioUsuario;
import com.hackaton.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author IngSB
 */
@Service
public class ServicioUsuario {
    /**
     *
     * Método para traer los datos desde el repositorio
     */ 
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    /**
     *
     * Método para el servicio de mostrar
     * @return 
     */ 
    public List<Usuario> getAll(){
        return repositorioUsuario.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */ 
    public Optional<Usuario> getUsuario(int id){
        return repositorioUsuario.getUsuario(id);
    }
    /**
     *
     * Método para el servicio de verificar existencia de email
     * @param email
     * @return 
     */ 
    public boolean existeEmail(String email) {
        return repositorioUsuario.existeEmail(email);
    }
    /**
     *
     * Método para el servicio de verificar existencia de email
     * @param email
     * @param contrasena
     * @return 
     */ 
    public Usuario existeUsuario(String email, String contrasena) {
        Optional<Usuario> usuario = repositorioUsuario.existeUsuario(email, contrasena);
        if (usuario.isEmpty()) {
            return new Usuario();
        } else {
            return usuario.get();
        }
    }
    /**
     *
     * Método para el servicio de guardar
     * @param usuario
     * @return 
     */ 
    public Usuario save(Usuario usuario){
        if(usuario.getId()==null){
            return repositorioUsuario.save(usuario);
        }else{
            Optional<Usuario> evt=repositorioUsuario.getUsuario(usuario.getId());
            if(evt.isEmpty()){
                return repositorioUsuario.save(usuario);
            }else{
                return usuario;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar
     * @param usuario
     * @return 
     */ 
    public Usuario update(Usuario usuario){
        if (usuario.getId() != null) {
            Optional<Usuario> actualizar = repositorioUsuario.getUsuario(usuario.getId());
            if (!actualizar.isEmpty()) {
                if (usuario.getNombre() != null) {
                    actualizar.get().setNombre(usuario.getNombre());
                }
                if (usuario.getEmail() != null) {
                    actualizar.get().setEmail(usuario.getEmail());
                }
                if (usuario.getUsuario() != null) {
                    actualizar.get().setUsuario(usuario.getUsuario());
                }
                if (usuario.getContrasena() != null) {
                    actualizar.get().setContrasena(usuario.getContrasena());
                }
                repositorioUsuario.save(actualizar.get());
                return actualizar.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param usuarioId
     * @return 
     */    
    public boolean deleteUsuario(int usuarioId){
        Boolean aBoolean = getUsuario(usuarioId).map(usuario -> {
            repositorioUsuario.delete(usuario);
            return true;
        }).orElse(false);
        return aBoolean;
    } 

    /**
     *
     * @param usuario
     * @return
     */
    public Usuario borrarUsuario(Usuario usuario){
        if (usuario.getId() != null) {
            Optional<Usuario> borrarUsuario = repositorioUsuario.getUsuario(usuario.getId());
            if (!borrarUsuario.isEmpty()) {
                if (usuario.getNombre() != null) {
                    borrarUsuario.get().setNombre(" ");
                }
                if (usuario.getEmail() != null) {
                    borrarUsuario.get().setEmail(" ");
                }
                if (usuario.getUsuario() != null) {
                    borrarUsuario.get().setUsuario(" ");
                }
                if (usuario.getContrasena() != null) {
                    borrarUsuario.get().setContrasena(" ");
                }
                repositorioUsuario.save(borrarUsuario.get());
                return borrarUsuario.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
}    