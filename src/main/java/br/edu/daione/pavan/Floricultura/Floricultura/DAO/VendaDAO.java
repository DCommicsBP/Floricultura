package br.edu.daione.pavan.Floricultura.Floricultura.DAO;

import br.edu.daione.pavan.Floricultura.Floricultura.Model.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daione.pavan
 */
@Repository
public interface VendaDAO extends CrudRepository<Venda, Integer> {
    
}
