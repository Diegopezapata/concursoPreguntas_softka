
package crud;

import Interfaz.InterfazInicio;
import controlador.Controlador_Preguntas;
import controlador.Controlador_Ronda;
import entidades.OpcionesPreguntas;
import entidades.PregunConcurso;
import entidades.Ronda;
import java.time.Clock;
import java.util.List;



public class ejecutar {

    
    public static void main(String[] args) {
      
//        Controlador_Ronda ronda = new Controlador_Ronda();
//        Controlador_Preguntas pregunta = new Controlador_Preguntas();
//        
//        List <Ronda> listaRondas = ronda.listarRonda();
//        
//        for (int i=0; i<listaRondas.size();i++)
//        {
//            System.out.println(String.valueOf(listaRondas.get(i).getIdRonda()) );
//        }
//        
//        List <PregunConcurso> listaPreguntas = pregunta.listarPreguntas();
//        
//        for (int i=0; i<listaPreguntas.size();i++)
//        {
//            System.out.println( listaPreguntas.get(i).getDescripPregunta());
//        }

       InterfazInicio inicio = new InterfazInicio();

       inicio.setVisible(true);
        
        
    }
    
}
