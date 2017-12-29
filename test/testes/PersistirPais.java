/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
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
        p.setNome("Zimbabwe");
        p.setIso("ZBW"
                + "");

        // Operaçao de persistencia
        em.getTransaction().begin(); // inicia a transaçao
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validator.validate(p);
        if (erros.size() > 0) {
            for (ConstraintViolation<Pais> erro : erros) {
                //System.out.println("Erro " + erro.getMessage());
                String str = "Erro " + erro.getMessage();
                JOptionPane.showMessageDialog(null, str);
            }
        } else {
            try {
                em.persist(p); // persiste o objeto
                em.getTransaction().commit(); // confirma a transaçao
            } catch (Exception e) {
                em.getTransaction().rollback(); // anula a operaçao em caso de erro
            } finally {
                em.close();
                emf.close();
            }
        }
    }

}
