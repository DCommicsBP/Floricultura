/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Controller;

import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO.VendasDAO;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Venda;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author daione
 */

public class VendasController {
     @Autowired
    VendasDAO vDAO;

    @RequestMapping(path = "/vendas/", method = RequestMethod.GET)
    public Iterable<Venda> ListarAutores() {
        Iterable<Venda> venda = vDAO.findAll();
        
        return venda;
    }

    // 2 - insere novo usuario
    @RequestMapping(path = "/venda/", method = RequestMethod.POST)
    public Optional<Venda> inserir(@RequestBody Venda venda) {
        Venda v = new Venda();
        v.setId(0);
        v = vDAO.save(venda);
        return null;
    }

    // 3 - carrega um usuario
    @RequestMapping(path = "/venda/{id}", method = RequestMethod.GET)
    public Optional<Venda> getUsuario(@PathVariable Integer id) {
        Optional<Venda> v = vDAO.findById(id);
        if (v != null) {
            return v;
        }
        return null;
    }
    
    // 4 - exclui um usuario
    @RequestMapping(path = "/venda/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (vDAO.existsById(id)) {
            vDAO.deleteById(id);
        }
    }
    // 5 - Edita um usuario
       @RequestMapping(path = "/venda/{id}", method = RequestMethod.PUT)
        public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Venda venda) {
        if (vDAO.existsById(id)) {
            venda.setId(id);
            vDAO.save(venda);
        } 

    }    


    
}
