package rn;

import entity.DoseVacinaAplicada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class DoseVacinaAplicadaRN {

    public DoseVacinaAplicadaRN() {

    }


    public DoseVacinaAplicada inserir(DoseVacinaAplicada doseVacinaAplicada) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(doseVacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacinaAplicada);

    }

    public DoseVacinaAplicada buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        DoseVacinaAplicada doseVacinaAplicada = manager.find(DoseVacinaAplicada.class, id);
        //Verificacao de id
        manager.close();
        return doseVacinaAplicada;
    }

    public DoseVacinaAplicada atualizar(DoseVacinaAplicada doseVacinaAplicada) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        doseVacinaAplicada = manager.merge(doseVacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacinaAplicada);
    }

    public DoseVacinaAplicada deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        DoseVacinaAplicada doseVacinaAplicada = manager.find(DoseVacinaAplicada.class, id);

        manager.getTransaction().begin();
        manager.remove(doseVacinaAplicada);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacinaAplicada);

    }

    public List<DoseVacinaAplicada> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from DoseVacinaAplicada c");
        List<DoseVacinaAplicada> listaDoseVacinaAplicadas = query.getResultList();
        return listaDoseVacinaAplicadas;
    }

}
