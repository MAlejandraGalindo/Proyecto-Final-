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

import javax.persistence.Table;


@Entity
@Table(name="especialidades")


public class Especialidades {
    @Id
    @GeneratedValue
    private Long id;
   
    
    private String nombre;
    private String area;
    private String hospital;

    public Especialidades(String nombre, String area, String hospital) {
        this.nombre = nombre;
        this.area = area;
        this.hospital = hospital;
    }

    public Especialidades(Long id, String nombre, String area, String hospital) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.hospital = hospital;
    }

    Especialidades(String nombre) {
        
    }
    
    

    @Override
    public String toString() {
        return "Especialidades{" + "id=" + id + ", nombre=" + nombre + ", area=" + area + ", hospital=" + hospital + '}';
    }

    public Especialidades() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    
}
