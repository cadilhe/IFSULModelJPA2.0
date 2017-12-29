/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import javax.persistence.EntityManager;
import junit.framework.Assert;
import modelo.Estado;
import modelo.Pais;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.FabricaEM;

/**
 *
 * @author carlosafc
 */
public class PersistirEstado {
    
    
    EntityManager em;
    
    public PersistirEstado() {
    }
    
    @Before
    public void setUp() {
        em = FabricaEM.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void teste(){
    
        boolean exception = false;
        
        try {            
            Estado estado = new Estado();
            estado.setNome("São Paulo");
            estado.setUf("SP");
            estado.setPais(em.find(Pais.class,1));
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    
    }
}
