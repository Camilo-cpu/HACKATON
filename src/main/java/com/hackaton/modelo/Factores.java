/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackaton.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Clase con los factores de emisión usados para
 * calcular la huella de carbono
 * @author Ale Giraldo
 */
@Data
@Entity
public class Factores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactor;
    /**
     * Factor de emisión para Gasolina en KgCO2/Km
     */
    private Double GASOLINA = 0.2215;
    /**
     * Factor de emisión para Diesel en KgCO2/Km
     */
    private Double DIESEL = 0.19269231;
    /**
     * Factor de emisión para Gas natural vehicular en KgCO2/Km
     */
    private Double GAS = 0.14307682;
}
