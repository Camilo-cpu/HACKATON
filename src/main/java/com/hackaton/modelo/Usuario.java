package com.hackaton.modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")    
    private String email;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    
    /**
     *
     * Relacion entre usuario y recorrido
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="usuario")
    @JsonIgnoreProperties({"usuario"})
    public List<Recorrido>recorrido;
}