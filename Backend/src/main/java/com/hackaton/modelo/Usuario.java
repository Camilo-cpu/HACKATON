package com.hackaton.modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
/**
 *
 * @author IngSB
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", indexes = @Index(name = "id", columnList = "usuario", unique = true))

public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @NonNull
    @Column(name = "edad", nullable = false)    
    private Integer edad;
    @NonNull
    @Column(name = "usuario", nullable = false)
    private String usuario;
    @NonNull
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    /**
     *
     * Relacion entre usuario y recorrido
     */
    //@OneToMany(cascade = {CascadeType.PERSIST},mappedBy="usuario")
    //@JsonIgnoreProperties({"usuario"})
    //public List<Recorrido>recorrido;
    
}