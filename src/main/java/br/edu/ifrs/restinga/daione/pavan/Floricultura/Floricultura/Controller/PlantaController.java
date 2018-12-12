/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Controller;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO.PlantasDAO;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Planta;
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
public class PlantaController {
     @Autowired
    PlantasDAO pDAO;

    @RequestMapping(path = "/planta/", method = RequestMethod.GET)
    public Iterable<Planta> Listar() {
        Iterable<Planta> plantas = pDAO.findAll();
        
        return plantas;
    }

    // 2 - insere nova Planta
    @RequestMapping(path = "/planta/", method = RequestMethod.POST)
    public Optional<Planta> inserir(@RequestBody Planta planta) {
        Planta p = new Planta();
        p.setId(0);
        p = pDAO.save(planta);
        return null;
    }

    // 3 - carrega uma planta
    @RequestMapping(path = "/planta/{id}", method = RequestMethod.GET)
    public Optional<Planta> getUsuario(@PathVariable Integer id) {
        Optional<Planta> p = pDAO.findById(id);
        if (p!= null) {
            return p;

        }
        return null;
    }
    
    // 4 - exclui uma planta
    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (pDAO.existsById(id)) {
            pDAO.deleteById(id);
        }
    }
    // 5 - Edita uma planta
       @RequestMapping(path = "/bibliotecarios/{id}", method = RequestMethod.PUT)
        public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Planta planta) {
        if (pDAO.existsById(id)) {
            planta.setId(id);
            pDAO.save(planta);
        } 

    }    


    
}
