
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
    Factores factor;
    /**
     * Instancia de la clase Recorridos
     */
    Recorridos recorrido;
    
    public List<Recorridos> getAll(){
        return recorridoRepository.getAll();
    }
    
    public Optional<Recorridos> getRecorrido(Integer id){
        return recorridoRepository.getRecorrido(id);
    }
    
    /**
     * Método usado para calcular la huella de carbono usando como datos de
     * entrada la distancia recorrida y el combustible usado en el recorrido
     * @param distancia distancia recorrida en Km
     * @param combustible combustible usado, puede ser Gasolina, Diesel o Gas
     * @return valor de la huella de carbono en KgCO2/Km
     */
    private void calcularHuella(){
        
        if("gasolina".equals(recorrido.getCombustible().toLowerCase())){
            recorrido.setResultado(recorrido.getDistancia() * factor.getGASOLINA());
        } else if("diesel".equals(recorrido.getCombustible())){
            recorrido.setResultado(recorrido.getDistancia() * factor.getDIESEL());
        } else if("gas".equals(recorrido.getCombustible())){
            recorrido.setResultado(recorrido.getDistancia() * factor.getGAS());
        }

    }
    
    
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
    
    public List<Recorridos> busquedaBarrio(String barrio){
        return recorridoRepository.busquedaBarrio(barrio);
    }
    
    public Double resultadoMayor(){
        return recorridoRepository.resultadoMayor();
    }
    
    
}
