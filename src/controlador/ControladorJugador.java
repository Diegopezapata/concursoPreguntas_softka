/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import entidades.Jugador;
import entidades.OpcionesPreguntas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class ControladorJugador {
    
    private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear(Jugador jugador) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(jugador);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (Jugador jugador) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(jugador);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<Jugador> listarJugadores()
    {
        Query query = entityManager().createQuery("SELECT j FROM Jugador j");
        
        return query.getResultList();
    }  
    
}
