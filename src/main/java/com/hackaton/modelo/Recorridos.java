package com.hackaton.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que crea la entidad recorridos
 * La anotación Entity le da propiedades de entidad a la clase
 * La anotación Data permite la creación automatica de los métodos get y set
 * La anotación NoArgsConstructor genera un constructor vacío
 * La anotación AllArgsConstructor genera un constructor con todos sus valores
 * @author Alejandro Giraldo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECORRIDO")
public class Recorridos implements Serializable{
    
    /**
     * Generación de la llave principal de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Número de identificador del usuario, se autogenera
     */
    private Integer id;
    /**
     * Fecha en la que se realizó el recorrido
     */
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    /**
     * Ciudad en la que se realizó el recorrido
     */
    private String ciudad;
    /**
     * Barrio en el que se realizó el recorrido
     */
    private String barrio;
    /**
     * Tipo de vehiculo en el que se realizó el recorrido, la entrada de este
     * dato se limita a opciones definidas en el formulario html
     */
    private String vehiculo;
    /**
     * Distancia recorrida en Kilómetros
     */
    private Integer distancia;
    /**
     * Tipo de combustible usado en el recorrido, la entrada de este dato se
     * limita a opciones definidas en el formulario html
     */
    private String combustible;
    /**
     * Tipo de recorrido, se refiere a si el recorrido fue plano, en subida,
     * en bajada o mixto. También se limita a opciones definidas en el formulario
     * html
     */
    private String tipoRecorrido;
    /**
     * Cálculo de la huella de carbono, el resultado proviene del método
     * calcularHuella.
     */
    private Double resultado;
    
    
    private Integer calficación(Double resultado){
        return null;
    }
    
}
