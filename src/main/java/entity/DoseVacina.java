package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author awilly
 */
@Entity
public class DoseVacina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idadeAplicacaoMes;
    
    @OneToOne
    private Vacina vacina;

    public DoseVacina() {
    }

    public DoseVacina(Long id, String nome, int idadeAplicacaoMes, Vacina vacina) {
        this.id = id;
        this.nome = nome;
        this.idadeAplicacaoMes = idadeAplicacaoMes;
        this.vacina = vacina;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdadeAplicacaoMes() {
        return idadeAplicacaoMes;
    }

    public void setIdadeAplicacaoMes(int idadeAplicacaoMes) {
        this.idadeAplicacaoMes = idadeAplicacaoMes;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof DoseVacina)) {
            return false;
        }
        DoseVacina other = (DoseVacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DoseVacina[ id=" + id + " ]";
    }
    
}