package rn;

import entity.Eapv;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class EapvRN {

    public EapvRN() {

    }

    public Eapv inserir(Eapv eapv) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(eapv);
        manager.getTransaction().commit();

        manager.close();

        return (eapv);

    }

    public Eapv buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Eapv eapv = manager.find(Eapv.class, id);
        //Verificacao de id
        manager.close();
        return eapv;
    }

    public Eapv atualizar(Eapv eapv) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        eapv = manager.merge(eapv);
        manager.getTransaction().commit();

        manager.close();

        return (eapv);
    }

    public Eapv deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Eapv eapv = manager.find(Eapv.class, id);

        manager.getTransaction().begin();
        manager.remove(eapv);
        manager.getTransaction().commit();

        manager.close();

        return (eapv);

    }

    public List<Eapv> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from Eapv c");
        List<Eapv> listaEapvs = query.getResultList();
        return listaEapvs;
    }

}