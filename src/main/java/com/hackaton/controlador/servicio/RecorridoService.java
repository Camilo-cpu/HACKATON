
package com.hackaton.controlador.servicio;

import com.hackaton.controlador.repositorio.RecorridoRepository;
import com.hackaton.modelo.Factores;
import com.hackaton.modelo.Recorridos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que crea los servicios necesarios para el funcionamiento del proyecto
 * @author Ale Giraldo
 */
@Service
public class RecorridoService {
     /**
      * Inyección de la clase RecorridoRepository
      */
    @Autowired
    RecorridoRepository recorridoRepository;
    /**
     * Instancia de la clase Factores
     */
    
    
    /**
     * Método que llama todos los elementos de la tabla
     * @return lista con todos los elementos presentes en la tabla
     */
    public List<Recorridos> getAll(){
        return recorridoRepository.getAll();
    }
    
    /**
     * Método para obtener un recorrido por su id
     * @param id Id del recorrido
     * @return Valores del recorrido o un elemento vacío en caso de que este no exista
     */
    public Optional<Recorridos> getRecorrido(Integer id){
        return recorridoRepository.getRecorrido(id);
    }
    
    /**
     * Método para guardar un recorrido. Verifica que el id no exista, en caso de que
     * exista revisa si el elemento es vacío o no
     * @param recorrido recorrido a guardar
     * @return recorrido en caso de que el id ya exista y esté lleno
     */
    public Recorridos save(Recorridos recorrido){
        if(recorrido.getId() == null){
            return recorridoRepository.save(recorrido);
        } else {
            Optional<Recorridos> recorridoAux = recorridoRepository.getRecorrido(recorrido.getId());
            if(recorridoAux.isEmpty()){
                return recorridoRepository.save(recorrido);
            } else {
                return recorrido;
            }
        }
    }
    
    /**
     * Método que busca los recorridos realizados en un barrio
     * @param barrio barrio a buscar
     * @return lista de los recorridos realizados en dicho barrio
     */
    public List<Recorridos> busquedaBarrio(String barrio){
        return recorridoRepository.busquedaBarrio(barrio);
    }
}
