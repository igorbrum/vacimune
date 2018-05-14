package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 631610042
 */ //http://localhost:8084/Vacimuni/api/eapv/
// cria um SQL, e coloca na conexão criada. 
// create database eapv
// se vc quiser trocar tipo de campo, em uma entidade, de um:
// drop table eapv
// por exemplo...

public class JPAUtil {
    private static final String NOMEPU= "VacimuniPU";
    private static EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory(NOMEPU);
    
    public static EntityManager createManager(){
        return factory.createEntityManager();
    }
}
