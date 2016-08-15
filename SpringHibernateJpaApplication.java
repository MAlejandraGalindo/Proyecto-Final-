package org.unitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHibernateJpaApplication implements CommandLineRunner{
//ESTA ES LA INYECCION DE DEPENDENCIAS, autoconecta, tambien se llama inversion de control
    @Autowired DAOEspecialidades daoesp;
    @Autowired DAODoctores daodoc;
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        /*
        System.out.println("antes de hacer el insert en la tabla o en la entidad Especialidades");
        //paso1 creamos un objeto de tipo Deparmaento
        Especialidades espe=new Especialidades("Cardiologia");
        //VERIFICAR QUE TENGAS LA ANOTACION DE INYECCION DE DEPENDENCIAS EN ESTA CLASE
        //guardar el departamento
        daoesp.save(espe);
        
        Especialidades esp=daoesp.findOne(1l);
        Doctores doc=new Doctores(esp, "Juan");
        daodoc.save(doc);
        
        
        //invocacion de objetos en cadena  es para sustituir los joins
        // hacer un query donde se muestre el usuario cuyo id es 2 y que se muestre sus nombre y el nombre
        //del departamento donde esta asignado
        
       // Empleado emp= daoemp.findOne(1L);
        
        //ejercicio: generar un controlado
        
        
       // System.out.println("query: id: " + emp.getId() + "emplado: " + emp.getNombre()+ "depto: " +emp.getDepa().getNombre());
    */

}
}
