/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author T-107
 */
@Transactional
public interface DAOEspecialidades extends CrudRepository<Especialidades, Long>{
    List<Especialidades> findByNombre(String nombre);
    
    
}
