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
public class ControladorDoctores {
    @Autowired DAOEspecialidades daoesp;
    @Autowired DAODoctores daodoc;
    
    @CrossOrigin
    @RequestMapping(value="/doctor/{id_especialidad}/{nombre}/{cedula}/{telefono}/{direccion}", method=RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Long id_especialidad, @PathVariable String nombre) throws Exception{
        Especialidades esp=daoesp.findOne(id_especialidad);
        Doctores d=new Doctores(esp,nombre);
        daodoc.save(d);
        return "Doctor guardado con exito";
    }

    @RequestMapping("/actualizar-doctor")
    @ResponseBody String actualizar(Long id, Long id_especialidad, String nombre, String cedula,
        String telefono, String direccion){
        String mensajito="nada";
        try{
           Doctores d=daodoc.findOne(id);
           d.setNombre(nombre);
           
           daodoc.save(d);
           mensajito="Doctor actualizado con exito";
        }catch(Exception e){
            mensajito=e.getMessage();
        }
        return mensajito;
    }
    
     @RequestMapping("/buscardoctor-porid")
    @ResponseBody String buscarPorId(Long id){
        String mensajito="nada";
        try{
            Doctores d= daodoc.findOne(id);
            mensajito=d.toString();
        }catch(Exception e){
            mensajito=e.getMessage();
            
        }
        return mensajito;
    }
    
     @CrossOrigin
    @RequestMapping(value="/doctor", method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String buscarTodos() throws JsonProcessingException{
         String mensajito="nada";
         
             ArrayList<Doctores> doctores=  (ArrayList<Doctores>) daodoc.findAll();
             //usamos del paquete fasterxml de json la clase objetMapper
             ObjectMapper maper=new ObjectMapper();
             return maper.writeValueAsString(doctores);
                
    }
    
    @RequestMapping("/borrar-doctor")
    @ResponseBody String borrardoctor(Long id){
        String mensajito="nada";
        try{
            daodoc.delete(id);
            mensajito="se borro tu resgitro con exito";
            
        }catch(Exception e){
            mensajito=e.getMessage();
        }
        return mensajito;
    }
    /*
    @RequestMapping("/buscarDoctor-pornombre")
    @ResponseBody String buscarPorNombre(String nombre){
        String mensajito="nada";
        StringBuilder builder=new StringBuilder();
        try{
        for(Doctores d:daodoc.findByNombre(nombre)){
            builder.append("<br>"+d.toString());
        }
         mensajito=builder.toString();
         }catch(Exception e){
             mensajito=e.getMessage();
         }
         return mensajito;
    }
*/
}
