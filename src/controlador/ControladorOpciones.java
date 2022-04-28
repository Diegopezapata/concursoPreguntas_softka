

package controlador;

import conexion.Conexion;
import entidades.OpcionesPreguntas;
import entidades.PregunConcurso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class ControladorOpciones {
    
   private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear (OpcionesPreguntas opciones) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(opciones);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (OpcionesPreguntas opciones) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(opciones);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<OpcionesPreguntas> listarOpciones()
    {
        Query query = entityManager().createQuery("SELECT o FROM OpcionesPreguntas o");
        
        return query.getResultList();
    }  
    
}
