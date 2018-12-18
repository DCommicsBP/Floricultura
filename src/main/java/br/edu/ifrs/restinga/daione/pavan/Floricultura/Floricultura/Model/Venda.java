
package br.edu.ifrs.restinga.daione.pavan.Floricultura.Floricultura.Model;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author daione
 */
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @ManyToMany
    private List<Planta> plantas; 
    @ManyToOne
    private Cliente cliente; 
    @ManyToOne
    private Usuario usuario;

    
    private Date compra; 
    private Date dataPrevista; 
    private Date entrega; 

    public Date getCompra() {
        return compra;
    }

    public void setCompra(Date compra) {
        this.compra = compra;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
