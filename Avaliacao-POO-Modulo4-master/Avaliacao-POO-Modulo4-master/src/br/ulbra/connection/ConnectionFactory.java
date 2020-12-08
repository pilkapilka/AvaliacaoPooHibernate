package br.ulbra.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author abi
 */
public class ConnectionFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaHib");

    public EntityManager getConnection() {
        return emf.createEntityManager();
    }
   
}
