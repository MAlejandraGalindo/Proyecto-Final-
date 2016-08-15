/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorEspecialidades {

    @Autowired
    DAOEspecialidades daoesp;

    //creamos el metodo para guardar un departamento
    @CrossOrigin
    @RequestMapping(value = "/especialidades/{nombre}/{area}/{hospital}",
            method = RequestMethod.POST, headers = {"Accept=text/html"})
    @ResponseBody
    String guardarEspecialidad(@PathVariable String nombre, @PathVariable String area, @PathVariable String hospital) {
        //generamos el objeto de tipo departamento
        Especialidades es = new Especialidades(nombre, area, hospital);
        String mensaje = "nada";
        try {
            daoesp.save(es);
            mensaje = "Especialidad guardada con exito";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @RequestMapping(value = "/actualizar-especialidad/{id}/{nombre}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    @ResponseBody
    String actualizar(@PathVariable Long id, @PathVariable String nombre) {
        String mensajito = "nada";
        try {
            Especialidades e = daoesp.findOne(id);
            e.setNombre(nombre);

            daoesp.save(e);
            mensajito = "Especialidad actualizado con exito";
        } catch (Exception e) {
            mensajito = e.getMessage();
        }
        return mensajito;
    }

    @RequestMapping("/buscarespecialidad-porid")
    @ResponseBody
    String buscarPorId(Long id) {
        String mensajito = "nada";
        try {
            Especialidades e = daoesp.findOne(id);
            mensajito = e.toString();
        } catch (Exception e) {
            mensajito = e.getMessage();

        }
        return mensajito;
    }

    //a) VERIFICAR LA ANOTACION DE CROSS ORIGIN
    @CrossOrigin
    @RequestMapping(value = "/especialidad", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody
    String buscarTodos() throws Exception {
        String mensajito = "nada";
        ObjectMapper maper = new ObjectMapper();

        ArrayList<Especialidades> especialidad = new ArrayList<Especialidades>();
        especialidad = (ArrayList<Especialidades>) daoesp.findAll();
        //usamos del paquete fasterxml de json la clase objetMapper

        return maper.writeValueAsString(especialidad);

    }

    @RequestMapping("/borrar-especialidades")
    @ResponseBody
    String borrarespecialidades(Long id) {
        String mensajito = "nada";
        try {
            daoesp.delete(id);
            mensajito = "se borro tu resgitro con exito";

        } catch (Exception e) {
            mensajito = e.getMessage();
        }
        return mensajito;
    }
    /* @RequestMapping("/buscarEspecialidad-pornombre")
    @ResponseBody String buscarPorNombre(String nombre){
        String mensajito="nada";
        StringBuilder builder=new StringBuilder();
        try{
        for(Especialidades es:daoesp.findByNombre(nombre)){
            builder.append("<br>"+es.toString());
        }
         mensajito=builder.toString();
         }catch(Exception e){
             mensajitopackage org.unitec;

/**
 *
 * @author Samanta
     */

    import javax.persistence.Entity ;
    import javax.persistence.GeneratedValue ;
    import javax.persistence.Id ;
    import javax.persistence.JoinColumn ;
    import javax.persistence.ManyToOne ;
    import javax.persistence.Table ;

    @Entity
    @Table(name = "doctores")

    public class Doctores {

        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_especialidad")
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
      = e.getMessage();
}
return mensajito;
    }
     */

}
