package rn;

import entity.VacinaAplicada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class VacinaAplicadaRN {

    public VacinaAplicadaRN() {

    }

    public VacinaAplicada inserir(VacinaAplicada vacinaAplicada) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(vacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (vacinaAplicada);

    }

    public VacinaAplicada buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        VacinaAplicada vacinaAplicada = manager.find(VacinaAplicada.class, id);
        //Verificacao de id
        manager.close();
        return vacinaAplicada;
    }

    public VacinaAplicada atualizar(VacinaAplicada vacinaAplicada) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        vacinaAplicada = manager.merge(vacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (vacinaAplicada);
    }

    public VacinaAplicada deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        VacinaAplicada vacinaAplicada = manager.find(VacinaAplicada.class, id);

        manager.getTransaction().begin();
        manager.remove(vacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (vacinaAplicada);

    }

    public List<VacinaAplicada> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from VacinaAplicada c");
        List<VacinaAplicada> listaVacinaAplicadas = query.getResultList();
        return listaVacinaAplicadas;
    }

    public List<VacinaAplicada> buscarPacientePorID(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Query query = manager.createQuery("SELECT c FROM VacinaAplicada c WHERE c.paciente.id = 107");
        List<VacinaAplicada> listaVacinaAplicadas = query.getResultList();
        return listaVacinaAplicadas;
    }

}
