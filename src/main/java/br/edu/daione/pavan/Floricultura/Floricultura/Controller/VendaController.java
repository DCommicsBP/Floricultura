package br.edu.daione.pavan.Floricultura.Floricultura.Controller;

import br.edu.daione.pavan.Floricultura.Floricultura.DAO.ClienteDAO;
import br.edu.daione.pavan.Floricultura.Floricultura.DAO.PlantaDAO;
import br.edu.daione.pavan.Floricultura.Floricultura.DAO.UsuarioDAO;
import br.edu.daione.pavan.Floricultura.Floricultura.DAO.VendaDAO;
import br.edu.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import br.edu.daione.pavan.Floricultura.Floricultura.Model.Venda;
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
 * @author daione.pavan
 */

@RestController
public class VendaController {
    @Autowired
    PlantaDAO pDAO; 
    @Autowired
    ClienteDAO cDAO; 
    @Autowired
    UsuarioDAO uDAO; 
    @Autowired
    VendaDAO vDAO; 

    @RequestMapping(path = "/venda/", method = RequestMethod.GET)
    public Iterable<Venda> listar() {
        Iterable<Venda> vendas = vDAO.findAll();
        
        return vendas;
    }

    // 2 - insere nova venda
    @RequestMapping(path = "/venda/", method = RequestMethod.POST)
    public Optional<Usuario> inserir(@RequestBody Venda venda) {
        Venda v = new Venda();
        v.setId(0);
        v = vDAO.save(venda);
        return null;
    }

    // 3 - carrega venda
    @RequestMapping(path = "/venda/{id}", method = RequestMethod.GET)
    public Optional<Venda> getUsuario(@PathVariable Integer id) {
        Optional<Venda> v = vDAO.findById(id);
        if (v != null) {
            return v;
        }
        return null;
    }
    // 4 - exclui uma  venda
    @RequestMapping(path = "/venda/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable int id) {
        if (vDAO.existsById(id)) {
            vDAO.deleteById(id);
        }
    }
    // 5 - Edita uma venda
       @RequestMapping(path = "/venda/{id}", method = RequestMethod.PUT)
        public void atualizar(@PathVariable Integer id, @RequestBody Venda venda) {
        if (vDAO.existsById(id)) {
            venda.setId(id);
            vDAO.save(venda);
        } 

    }    

}
    
    

