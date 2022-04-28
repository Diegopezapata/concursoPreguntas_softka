/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import conexion.Conexion;
import entidades.Ronda;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class Controlador_Ronda 
{
    private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }    
    
    public void crear (Ronda ronda) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(ronda);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (Ronda ronda) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(ronda);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<Ronda> listarRonda()
    {
        Query query = entityManager().createQuery("SELECT r FROM Ronda r");
        
        return query.getResultList();
    } 
    
}
 