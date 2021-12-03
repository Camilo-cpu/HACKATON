package com.hackaton.modelo;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author IngSB
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {
    @Id
    private Integer id;
    private String nombre;
    private Integer edad;
    private String usuario;
    private String contrasena;
    private String mediotransporte;
    private Integer kmrecorrido;
    
}
