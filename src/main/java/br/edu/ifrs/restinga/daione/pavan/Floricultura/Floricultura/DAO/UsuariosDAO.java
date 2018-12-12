/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO;

import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daione
 */
@Repository
public interface UsuariosDAO extends CrudRepository<Usuario, Integer> {
    
}

