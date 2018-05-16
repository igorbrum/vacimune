package rn;

import entity.Doenca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author ibrum
 */
public class DoencaRN {
    public DoencaRN() {

    }

    public Doenca inserir(Doenca doenca) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(doenca);
        manager.getTransaction().commit();

        manager.close();

        return (doenca);

    }
    
    public Doenca buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Doenca doenca = manager.find(Doenca.class, id);
        //Verificacao de id
        manager.close();
        return doenca;
    }

    public Doenca atualizar(Doenca doenca) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        doenca = manager.merge(doenca);
        manager.getTransaction().commit();

        manager.close();

        return (doenca);
    }

    public Doenca deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Doenca doenca = manager.find(Doenca.class, id);

        manager.getTransaction().begin();
        manager.remove(doenca);
        manager.getTransaction().commit();

        manager.close();

        return (doenca);

    }

    public List<Doenca> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from Doenca c");
        List<Doenca> listaDoencas = query.getResultList();
        return listaDoencas;
    }
}
