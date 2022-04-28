/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import entidades.CategoriaPregunta;
import entidades.OpcionesPreguntas;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Analista de sistemas
 */
public class ControladorCategoria {
    
     private EntityManager entityManager()
    {
        return Conexion.getInstancia().getFabrica().createEntityManager();
        
    }
    
    public void crear (CategoriaPregunta categoria) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.persist(categoria);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public void editar (CategoriaPregunta categoria) 
    {
        EntityManager em = entityManager();
        
        try {
            
             em.getTransaction().begin();
             em.merge(categoria);
             em.getTransaction().commit();
             
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }

    }
    
    public List<CategoriaPregunta> listarCategorias()
    {
        Query query = entityManager().createQuery("SELECT c FROM CategoriaPregunta c");
        
        return query.getResultList();
    }  
    
    public BigDecimal darIdPorCategoria(String pCategoria){
        
        Query query = entityManager().createQuery("SELECT c.idCategoria FROM CategoriaPregunta c WHERE c.nombreCategoria = :" + pCategoria);
        return (BigDecimal)query.getSingleResult();
    }
}
