/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Controller;

import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO.ClientesDAO;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Cliente;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daione
 */
@RestController
public class ClientesController {

    @Autowired
    ClientesDAO cDAO;

    @RequestMapping(path = "/cliente/", method = RequestMethod.GET)
    public Iterable<Cliente> ListarAutores() {
        Iterable<Cliente> clientes = cDAO.findAll();
        if (clientes == null) {
            //throw new ERROR400("Não foi possivel encontrar um registro"); 
        }
        return clientes;
    }

    // 2 - insere novo cliente
    @RequestMapping(path = "/cliente/", method = RequestMethod.POST)
    public Optional<Cliente> inserir(@RequestBody Cliente cliente) {
        Cliente c = new Cliente();
        c.setId(0);
        c = cDAO.save(cliente);
        return null;
    }

    // 3 - carrega um cliente
    @RequestMapping(path = "/cliente/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getUsuario(@PathVariable Integer id) {
        Optional<Cliente> c = cDAO.findById(id);
        if (c != null) {
            return c;

        }
        return c;
    }
    
    // 4 - exclui um cliente
    @RequestMapping(path = "/cliente/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (cDAO.existsById(id)) {
            cDAO.deleteById(id);
        }
    }
    // 5 - Edita um cliente
       @RequestMapping(path = "/cliente/{id}", method = RequestMethod.PUT)
        public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Cliente cliente) {
        if (cDAO.existsById(id)) {
            cliente.setId(id);
            cDAO.save(cliente);
        } 

    }    


}
