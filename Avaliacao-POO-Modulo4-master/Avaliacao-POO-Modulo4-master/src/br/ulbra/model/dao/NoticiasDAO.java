package br.ulbra.model.dao;

import br.ulbra.connection.ConnectionFactory;
import br.ulbra.model.bean.Noticias;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author abi
 */
public class NoticiasDAO {

    public void save(Noticias noticias) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            if (noticias.getId() == null) {
                em.persist(noticias);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Notícia adiciona com sucesso!");
            } else {
                em.merge(noticias);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Notícia editada com sucesso!");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Noticias remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Noticias noticias = null;
        try {
            noticias = em.find(Noticias.class, id);
            em.getTransaction().begin();
            em.remove(noticias);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return noticias;
    }

    public Noticias findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Noticias noticias = null;

        try {
            noticias = em.find(Noticias.class, id);

        } catch (Exception e) {
            System.err.println(e);

        } finally {
            em.close();

        }
        return noticias;

    }

    public List<Noticias> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Noticias> noticias = null;
        try {
            noticias = em.createQuery("from Noticias p").getResultList();

        } catch (Exception e) {
            System.err.println(e);

        } finally {
            em.close();
        }
        return noticias;
    }

}
