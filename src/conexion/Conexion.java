package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion 
{
    
    private static Conexion instancia = new Conexion();
    
    private EntityManagerFactory fabrica;
    
    private Conexion ()
    {
        fabrica =  Persistence.createEntityManagerFactory("concurso_preguntas_respuestasPU");
    }

    public static Conexion getInstancia() {
        return instancia;
    }

    public static void setInstancia(Conexion instancia) {
        Conexion.instancia = instancia;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }

    public void setFabrica(EntityManagerFactory fabrica) {
        this.fabrica = fabrica;
    }
    
    
            
    
}
