package rn;

import entity.Vacina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class VacinaRN {

    public VacinaRN() {

    }

    public Vacina inserir(Vacina vacina) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(vacina);
        manager.getTransaction().commit();

        manager.close();

        return (vacina);

    }

    public Vacina buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Vacina vacina = manager.find(Vacina.class, id);
        //Verificacao de id
        manager.close();
        return vacina;
    }

    public Vacina atualizar(Vacina vacina) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        vacina = manager.merge(vacina);
        manager.getTransaction().commit();

        manager.close();

        return (vacina);
    }

    public Vacina deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Vacina vacina = manager.find(Vacina.class, id);

        manager.getTransaction().begin();
        manager.remove(vacina);
        manager.getTransaction().commit();

        manager.close();

        return (vacina);

    }

    public List<Vacina> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from Vacina c");
        List<Vacina> listaVacinas = query.getResultList();
        return listaVacinas;
    }

}
