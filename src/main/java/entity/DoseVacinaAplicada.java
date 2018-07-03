package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 631610042
 */
@XmlRootElement
@Entity
public class DoseVacinaAplicada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dataAplicacao;

    @OneToOne
    private DoseVacina doseVacina;
    @ManyToOne
    private Paciente paciente;
    @ManyToMany
    private List<EapvSofrido> eapvSofrido;

    public DoseVacinaAplicada() {
    }

    public DoseVacinaAplicada(Long id, String dataAplicacao, DoseVacina doseVacina, Paciente paciente, List<EapvSofrido> eapvSofrido) {
        this.id = id;
        this.dataAplicacao = dataAplicacao;
        this.doseVacina = doseVacina;
        this.paciente = paciente;
        this.eapvSofrido = eapvSofrido;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public DoseVacina getDoseVacina() {
        return doseVacina;
    }

    public void setDoseVacina(DoseVacina doseVacina) {
        this.doseVacina = doseVacina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public List<EapvSofrido> getEapvSofrido() {
        return eapvSofrido;
    }

    public void setEapvSofrido(List<EapvSofrido> eapvSofrido) {
        this.eapvSofrido = eapvSofrido;
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
        if (!(object instanceof DoseVacinaAplicada)) {
            return false;
        }
        DoseVacinaAplicada other = (DoseVacinaAplicada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.DoseVacinaAplicada[ id=" + id + " ]";
    }
    
}
