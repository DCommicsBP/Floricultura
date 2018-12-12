/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.daione.pavan.Floricultura.Floricultura.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.daione.pavan.Floricultura.Floricultura.Model.Planta;
/**
 * @author daione.pavan
 */

@Repository
public interface PlantaDAO extends CrudRepository<Planta, Integer>{
    
}
