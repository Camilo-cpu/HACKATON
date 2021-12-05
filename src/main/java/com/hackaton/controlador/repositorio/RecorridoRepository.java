package com.hackaton.controlador.repositorio;

import com.hackaton.controlador.repositorio.crud.RecorridoCrudRepository;
import com.hackaton.modelo.Recorridos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio en el cual se generan los métodos a usar a partir de los
 * métodos crud del crud repository
 * @author Alejandro Giraldo
 */
@Repository
public class RecorridoRepository {
    
    /**
     * Inyección de la clase RecorridoCrudRepository
     */
    @Autowired
    RecorridoCrudRepository recorridoCrudRepository;
    
    /**
     * Método usado para encontrar todos los registros generados
     * @return lista con los registros generados
     */
    public List<Recorridos> getAll(){
        return (List<Recorridos>) recorridoCrudRepository.findAll();
    }
    
    /**
     * Método usado para encontar un recorrido por su id
     * @param id Identificador del recorrido
     * @return Objeto de tipo optional que puede contener la información o devolver un objeto vacío
     */
    public Optional<Recorridos> getRecorrido(Integer id){
        return recorridoCrudRepository.findById(id);
    }
    
    /**
     * Método usado para guardar un recorrido
     * @param recorrido recorrido a guardar
     * @return recorrido guardado
     */
    public Recorridos save(Recorridos recorrido){
        return recorridoCrudRepository.save(recorrido);
    }
    
    /**
     * Método que busca los recorridos realizados en un barrio especifico
     * @param barrio barrio a buscar
     * @return lista con la información solicitada
     */
    public List<Recorridos> busquedaBarrio(String barrio){
        return recorridoCrudRepository.findAllByBarrio(barrio);
    }
     
}
