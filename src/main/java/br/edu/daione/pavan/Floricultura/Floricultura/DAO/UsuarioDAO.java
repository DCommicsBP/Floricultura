/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.daione.pavan.Floricultura.Floricultura.DAO;

import br.edu.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daione.pavan
 */
@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    
    
}
