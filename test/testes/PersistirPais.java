/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pais;

/**
 *
 * @author sigaln
 */
public class PersistirPais {

    public static void main(String[] args) {

        // Para fazer persistencia com JPA preciso de uma EntityManager. Para ter uma EntityManager preciso de uma fábrica de EntityManager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();

        Pais p = new Pais();
        // p.setId(1);
        p.setNome("Brasil");
        p.setIso("pt-BR");

        // Operaçao de persistencia
        em.getTransaction().begin(); // inicia a transaçao
        try {
            em.persist(p); // persiste o objeto
            em.getTransaction().commit(); // confirma a transaçao
        } catch (Exception e) {
            em.getTransaction().rollback(); // anula a operaçao em caso de erro
        } finally {
            em.close();
        }
    }

}
