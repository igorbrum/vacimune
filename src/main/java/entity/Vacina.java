package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 631610042
 */
@XmlRootElement
@Entity
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int numeroDeDoses; 
    
    // nao faz sentido a vacina carregar as aplicacoes em sua tabela:
    //@OneToMany
    //private List<VacinaAplicada> vacinaAplicada;
    
    @ManyToMany
    private List<Doenca> doenca;

    public Vacina(Long id, String nome, int numeroDeDoses, List<Doenca> doenca) {
        this.id = id;
        this.nome = nome;
        this.numeroDeDoses = numeroDeDoses;
        this.doenca = doenca;
    }

    public Vacina() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeDoses() {
        return numeroDeDoses;
    }

    public void setNumeroDeDoses(int numeroDeDoses) {
        this.numeroDeDoses = numeroDeDoses;
    }

    public List<Doenca> getDoenca() {
        return doenca;
    }

    public void setDoenca(List<Doenca> doenca) {
        this.doenca = doenca;
    }






    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Cliente[ id=" + id + " ]";
    }
    
}
