package rn;

import entity.DoseVacina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class DoseVacinaRN {

    public DoseVacinaRN() {

    }

    public DoseVacina inserir(DoseVacina doseVacina) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(doseVacina);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacina);

    }

    public DoseVacina buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        DoseVacina doseVacina = manager.find(DoseVacina.class, id);
        //Verificacao de id
        manager.close();
        return doseVacina;
    }

    public DoseVacina atualizar(DoseVacina doseVacina) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        doseVacina = manager.merge(doseVacina);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacina);
    }

    public DoseVacina deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        DoseVacina doseVacina = manager.find(DoseVacina.class, id);

        manager.getTransaction().begin();
        manager.remove(doseVacina);
        manager.getTransaction().commit();

        manager.close();

        return (doseVacina);

    }

    public List<DoseVacina> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from DoseVacina c");
        List<DoseVacina> listaDoseVacinas = query.getResultList();
        return listaDoseVacinas;
    }

}
