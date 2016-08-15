/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

/**
 *
 * @author Samanta
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="doctores")

public class Doctores {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="id_especialidad")        
    private Especialidades espe;
    
    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;

    public Doctores(Especialidades espe, String nombre, String cedula, String telefono, String direccion) {
        this.espe = espe;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Doctores(Long id, Especialidades espe, String nombre, String cedula, String telefono, String direccion) {
        this.id = id;
        this.espe = espe;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    Doctores(Especialidades esp, String nombre) {
        
    }
    
     

    @Override
    public String toString() {
        return "Doctores{" + "id=" + id + ", espe=" + espe + ", nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", direccion=" + getDireccion() + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Especialidades getEspe() {
        return espe;
    }

    public void setEspe(Especialidades espe) {
        this.espe = espe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

  
    
    //contructor
    public Doctores() {
    }
    
    
    
}
