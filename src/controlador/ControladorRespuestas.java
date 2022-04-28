/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import entidades.PregunConcurso;
import entidades.Respuesta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class ControladorRespuestas {
    
    private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear (Respuesta respuesta) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(respuesta);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (Respuesta respuesta) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(respuesta);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<Respuesta> listarRespuestas()
    {
        Query query = entityManager().createQuery("SELECT r FROM Respuesta r");
        
        return query.getResultList();
    }  
    
}
