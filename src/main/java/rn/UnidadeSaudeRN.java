package rn;

import entity.UnidadeSaude;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class UnidadeSaudeRN {

    public UnidadeSaudeRN() {

    }

    public UnidadeSaude inserir(UnidadeSaude unidadeSaude) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(unidadeSaude);
        manager.getTransaction().commit();

        manager.close();

        return (unidadeSaude);

    }

    public UnidadeSaude buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        UnidadeSaude unidadeSaude = manager.find(UnidadeSaude.class, id);
        //Verificacao de id
        manager.close();
        return unidadeSaude;
    }

    public UnidadeSaude atualizar(UnidadeSaude unidadeSaude) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        unidadeSaude = manager.merge(unidadeSaude);
        manager.getTransaction().commit();

        manager.close();

        return (unidadeSaude);
    }

    public UnidadeSaude deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        UnidadeSaude unidadeSaude = manager.find(UnidadeSaude.class, id);

        manager.getTransaction().begin();
        manager.remove(unidadeSaude);
        manager.getTransaction().commit();

        manager.close();

        return (unidadeSaude);

    }

    public List<UnidadeSaude> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from UnidadeSaude c");
        List<UnidadeSaude> listaUnidadeSaudes = query.getResultList();
        return listaUnidadeSaudes;
    }

}
