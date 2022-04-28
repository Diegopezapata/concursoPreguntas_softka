
package controlador;

import conexion.Conexion;
import entidades.PregunConcurso;
import entidades.Premio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ControladorPremio {
    
    private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear (Premio premio) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(premio);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (Premio premio) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(premio);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<Premio> listarPremios()
    {
        Query query = entityManager().createQuery("SELECT p FROM Premio p");
        
        return query.getResultList();
    }  
    
}
