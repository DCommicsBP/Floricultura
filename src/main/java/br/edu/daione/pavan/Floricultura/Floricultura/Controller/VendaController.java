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
    public Optional<Venda> inserir(@RequestBody Venda venda) {
        List<Planta> p = new ArrayList<Planta>(); 
        Usuario u = new Usuario(); 
        Cliente c = new Cliente(); 
        
         for(Planta plan: venda.getPlantas()){
             Planta planta = new Planta(); 
             planta.setId(plan.getId());
             planta.setNome(plan.getNome());
             planta.setQuantidadeDisponivel(plan.getQuantidadeDisponivel());
             planta.setValor(plan.getValor());
             p.add(plan); 
         }
         u.setId(venda.getUsuario().getId());
         u.setNome(venda.getUsuario().getNome());
         u.setIsVisible(venda.getUsuario().isIsVisible());
         u.setLogin(venda.getUsuario().getLogin());
         u.setSenha(venda.getUsuario().getSenha());
         
         c.setEmail(venda.getCliente().getEmail());
         c.setEndereco(venda.getCliente().getEndereco());
         c.setId(venda.getCliente().getId());
         c.setNome(venda.getCliente().getNome());
         c.setIsVisible(venda.getCliente().isIsVisible());
         c.setTelefone(venda.getCliente().getTelefone());
         
        Venda v = new Venda();
        v.setCliente(c);
        v.setPlantas(p);
        v.setUsuario(u);
        v.setId(0);
        
        v = vDAO.save(venda);
        return null;
    }

    // 3 - carrega uma venda
    @RequestMapping(path = "/venda/{id}", method = RequestMethod.GET)
    public Optional<Venda> getUsuario(@PathVariable Integer id) {
        Optional<Venda> v = vDAO.findById(id);
        if (v != null) {
            return v;
        }
        return null;
    }
    
    // 4 - exclui uma venda
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
    
    

