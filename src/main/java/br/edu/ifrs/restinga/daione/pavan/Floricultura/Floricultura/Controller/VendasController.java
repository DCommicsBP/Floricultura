/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Controller;

import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.DAO.VendasDAO;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Cliente;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Planta;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Usuario;
import br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model.Venda;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
 * @author daione
 */

@RestController
@CrossOrigin
public class VendasController {
     @Autowired
    VendasDAO vDAO;

    @RequestMapping(path = "/venda/", method = RequestMethod.GET)
    public Iterable<Venda> ListarAutores() {
        Iterable<Venda> venda = vDAO.findAll();
        
        return venda;
    }
    // 2 - insere nova venda
    @RequestMapping(path = "/venda/", method = RequestMethod.POST)
    public Optional<Venda> inserir(@RequestBody Venda venda) {
        List<Planta> p = new ArrayList<Planta>(); 
        Usuario u = new Usuario(); 
        Cliente c = new Cliente(); 
       double total = 0; 
             for(Planta plan: venda.getPlantas()){
             Planta planta = new Planta(); 
             planta.setId(plan.getId());
             planta.setNome(plan.getNome());
             planta.setQuantidade(venda.getQuantidade());
             planta.setValor(plan.getValor());
             planta.setTipo(plan.getTipo());
             
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
        v.setPagamento(venda.getPagamento());
        // v.setValorTotal(total)
         Calendar calendar = Calendar.getInstance();
         calendar.add(Calendar.DAY_OF_MONTH, 7);        
            
        v.setEntrega(new Date(System.currentTimeMillis()));
        v.setDataPrevista(calendar.getTime());
        v.setCompra(new Date(System.currentTimeMillis()));

        
        vDAO.save(v);
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
        public void atualizaBibliotecario(@PathVariable Integer id, @RequestBody Venda venda) {
        if (vDAO.existsById(id)) {
            venda.setId(id);
            vDAO.save(venda);
        } 
    }
        // 6 - Carrega pedidos pendentes
          @RequestMapping(path = "/venda/pendente/", method = RequestMethod.GET)
    public List<Venda> listarVendasPendentes() {
        Iterable<Venda> venda = vDAO.findAll();
        List<Venda> pendentes = new ArrayList<>(); 
        for(Venda v :venda){
            if(v.getEntrega().equals(v.getCompra())){
                pendentes.add(v); 
            }
            
        }
        
        return pendentes;
    }
        // 6 - Carrega pedidos pendentes
          @RequestMapping(path = "/venda/completas/", method = RequestMethod.GET)
    public List<Venda> listarVendasCompletas() {
        Iterable<Venda> venda = vDAO.findAll();
        List<Venda> pendentes = new ArrayList<>(); 
        for(Venda v :venda){
            if(!v.getEntrega().equals(v.getCompra())){
                pendentes.add(v); 
            }
        }
        return pendentes;
    }
    
}
