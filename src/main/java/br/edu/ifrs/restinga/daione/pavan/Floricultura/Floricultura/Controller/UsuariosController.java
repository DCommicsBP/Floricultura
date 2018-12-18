/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Controller;

import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO.UsuariosDAO;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Cliente;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UsuariosController {
    
     @Autowired
    UsuariosDAO uDAO;

    @RequestMapping(path = "/usuario/", method = RequestMethod.GET)
    public Iterable<Usuario> ListarAutores() {
        Iterable<Usuario> clientes = uDAO.findAll();
        
        return clientes;
    }

    // 2 - insere novo usuario
    @RequestMapping(path = "/usuario/", method = RequestMethod.POST)
    public Optional<Cliente> inserir(@RequestBody Usuario usuario) {
        Usuario u = new Usuario();
        u.setId(0);
        u = uDAO.save(usuario);
        return null;
    }

    // 3 - carrega um usuario
    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuario(@PathVariable Integer id) {
        Optional<Usuario> u = uDAO.findById(id);
        if (u != null) {
            return u;

        }
        return null;
    }
    
    // 4 - exclui um usuario
    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (uDAO.existsById(id)) {
            uDAO.deleteById(id);
        }
    }
    // 5 - Edita um usuario
       @RequestMapping(path = "/usuario/{id}", method = RequestMethod.PUT)
        public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if (uDAO.existsById(id)) {
            usuario.setId(id);
            uDAO.save(usuario);
        } 

    }    


    
    
}
