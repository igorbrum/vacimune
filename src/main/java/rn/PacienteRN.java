package rn;

import entity.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author 631610042
 */
public class PacienteRN {

    public PacienteRN() {

    }

    public Paciente inserir(Paciente paciente) {
        //Validacoes - Exemplo:
        //if(motor.getNome()==null || motor.getNome().isEmpty()){
        //    throw new Exception();
        //}
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(paciente);
        manager.getTransaction().commit();

        manager.close();

        return (paciente);

    }

    public Paciente buscarPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Paciente paciente = manager.find(Paciente.class, id);
        //Verificacao de id
        manager.close();
        return paciente;
    }

    public Paciente atualizar(Paciente paciente) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        paciente = manager.merge(paciente);
        manager.getTransaction().commit();

        manager.close();

        return (paciente);
    }

    public Paciente deletar(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Paciente paciente = manager.find(Paciente.class, id);

        manager.getTransaction().begin();
        manager.remove(paciente);
        manager.getTransaction().commit();

        manager.close();

        return (paciente);

    }

    public List<Paciente> listar() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select c from Paciente c");
        List<Paciente> listaPacientes = query.getResultList();
        return listaPacientes;
    }

}
