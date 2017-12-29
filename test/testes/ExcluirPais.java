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
public class ExcluirPais {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();

        // Para atualizar um registro, primeiro precisamos encontrá-lo no BD com o método find
        Pais p = em.find(Pais.class, 5);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
