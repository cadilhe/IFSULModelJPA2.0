
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author carlosafc
 */
public class FabricaEM {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
        
    public static EntityManager getEntityManager(){
        
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        if(em == null)
            em = emf.createEntityManager();

        return em;
    }
    
}
