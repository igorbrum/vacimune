package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 631610042
 */
@XmlRootElement
@Entity
public class EapvSofrido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Eapv eapv;
    // Para verificar se um eapvSofrido é referente a mais de uma vacina, 
    // verificar se o idEapvSofrido estah em mais de uma linha da base VacinaAplicada.
    // Assim, nao considerei colocar, nessa tabela, a lista de vacinasAplicadas associadas a cada eapv.
    // Ou seja, 
    //ManyToMany com VacinaAplicada eh unidirecional. Logo, nao preciso constar a lista de vacinasAplicadas aqui
    // Caso quisesse bidirecional, implantaria o seguinte (gerando os getter and setter):
    //@ManyToMany
    //private List<VacinaAplicada> vacinaAplicada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eapv getEapv() {
        return eapv;
    }

    public void setEapv(Eapv eapv) {
        this.eapv = eapv;
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
        if (!(object instanceof EapvSofrido)) {
            return false;
        }
        EapvSofrido other = (EapvSofrido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Endereco[ id=" + id + " ]";
    }
    
}
