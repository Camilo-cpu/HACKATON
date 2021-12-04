/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackaton.controlador.repositorio.crud;

import com.hackaton.modelo.Recorridos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * Interfaz que contiene las operaciones CRUD necesarias para el funcionamiento
 * del proyecto
 * @author Alejandro Giraldo
 */
public interface RecorridoCrudRepository extends CrudRepository<Recorridos, Integer>{
    
    /**
     * Método que realiza una busqueda de información por barrio
     * @param barrio barrio a buscar
     * @return Lista con la información de los recorridos recolectados en cada barrio
     */
    public List<Recorridos> findAllByBarrio(String barrio);
    
    
    @Query(value="SELECT TOP 1 FROM RECORRIDO ORDER BY resultado DESC", nativeQuery=true)
    public Double findMaxResultado();
}
