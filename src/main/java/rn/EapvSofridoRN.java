package rn;

import entity.EapvSofrido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class EapvSofridoRN {

    public EapvSofridoRN() {

    }

    public EapvSofrido inserir(EapvSofrido eapvSofrido) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(eapvSofrido);
        manager.getTransaction().commit();

        manager.close();

        return (eapvSofrido);

    }

    public EapvSofrido buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        EapvSofrido eapvSofrido = manager.find(EapvSofrido.class, id);
        //Verificacao de id
        manager.close();
        return eapvSofrido;
    }

    public EapvSofrido atualizar(EapvSofrido eapvSofrido) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        eapvSofrido = manager.merge(eapvSofrido);
        manager.getTransaction().commit();

        manager.close();

        return (eapvSofrido);
    }

    public EapvSofrido deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        EapvSofrido eapvSofrido = manager.find(EapvSofrido.class, id);

        manager.getTransaction().begin();
        manager.remove(eapvSofrido);
        manager.getTransaction().commit();

        manager.close();

        return (eapvSofrido);

    }

    public List<EapvSofrido> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from EapvSofrido c");
        List<EapvSofrido> listaEapvSofridos = query.getResultList();
        return listaEapvSofridos;
    }

}
