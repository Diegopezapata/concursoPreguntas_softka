/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import entidades.HistorialJuego;
import entidades.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class ControladorHistorialJuego {
    
        private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear (HistorialJuego historial) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(historial);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (HistorialJuego historial) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(historial);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<HistorialJuego> listarHistorialJuego()
    {
        Query query = entityManager().createQuery("SELECT h FROM HistorialJuego h");
        
        return query.getResultList();
    }  
    
}
