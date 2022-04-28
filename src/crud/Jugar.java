/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import controlador.ControladorCategoria;
import controlador.ControladorHistorialJuego;
import controlador.ControladorJugador;
import controlador.ControladorOpciones;
import controlador.ControladorPartida;
import controlador.ControladorPremio;
import controlador.ControladorRespuestas;
import controlador.ControladorResultado;
import controlador.Controlador_Preguntas;
import controlador.Controlador_Ronda;
import entidades.CategoriaPregunta;
import entidades.Jugador;
import entidades.OpcionesPreguntas;
import entidades.Partida;
import entidades.PregunConcurso;
import entidades.Premio;
import entidades.Respuesta;
import entidades.Resultado;
import entidades.Ronda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Analista de sistemas
 */
public class Jugar 
{
  //---  Atributos Controladores de las entidades
    
    private ControladorCategoria categoria;
    private Controlador_Preguntas pregunta;
    private ControladorOpciones opciones;  
    private ControladorPartida partida;    
    private ControladorPremio premio;    
    private Controlador_Ronda ronda;    
    private ControladorRespuestas respuesta;    
    private ControladorJugador jugador;    
    private ControladorResultado resultado;    
    private ControladorHistorialJuego historial;
    
  //Listas de las entidades
    
    private List<CategoriaPregunta> lista_categorias;
    private List<PregunConcurso> listaPreguntas;
    private List<OpcionesPreguntas> lista_opciones;
    private List<Respuesta> lista_respuestas;
    private List<Resultado> lista_resultado;
    private List<Ronda> lista_Ronda;
    private List<Premio> lista_premios;

    public void llenarLListaOpciones() {
        lista_opciones =  opciones.listarOpciones();
    }


    
    public Jugar()
    {
        categoria = new ControladorCategoria();
        pregunta = new Controlador_Preguntas();
        opciones = new ControladorOpciones();
        partida = new ControladorPartida();
        premio = new ControladorPremio();
        ronda = new Controlador_Ronda();
        respuesta = new ControladorRespuestas();
        jugador = new ControladorJugador();
        resultado = new ControladorResultado();
        historial = new ControladorHistorialJuego();
        

    }
    
    public void llenarListas()
    {
        listaPreguntas = pregunta.listarPreguntas();
        lista_opciones = opciones.listarOpciones();
        lista_respuestas = respuesta.listarRespuestas();
        lista_categorias = categoria.listarCategorias();
        lista_Ronda = ronda.listarRonda();
        lista_premios = premio.listarPremios();
        
    }
    
    public PregunConcurso seleccionarPreguntaParaRonda (int pRonda)
    {
        List<PregunConcurso> listaTemporal = new ArrayList<PregunConcurso>();
        List<PregunConcurso> listaPreguntas = pregunta.listarPreguntas();
        
        String categoria = buscarCategoriaPorRonda(pRonda);
        BigDecimal categoriaPregunta = buscarIdCategoriaPorDescripcion(categoria);
        
        for (int i=1; i<listaPreguntas.size();i++){
            
            BigDecimal id_categoria = listaPreguntas.get(i).getIdCategoria().getIdCategoria();
            if (id_categoria.equals(categoriaPregunta)) {
                listaTemporal.add(listaPreguntas.get(i));
            }
            
        }
        
        int min = 0;
        int max = 3;

	Random random = new Random();
        
        int valorAleatorio = random.nextInt(max+min)+min;
        
        
        
//        for (int d=0;d<listaTemporal.size();d++){
//            System.out.println(listaTemporal.get(d).getDescripPregunta());
//        }
        return listaTemporal.get(valorAleatorio);
 
    }
    
    public List<OpcionesPreguntas> listaOpcionesParaPregunta(PregunConcurso pPregunta)
    {   
        
        List<OpcionesPreguntas> listaOpciones = new ArrayList<OpcionesPreguntas>();
        List<OpcionesPreguntas> listaOpciones2 = opciones.listarOpciones();
        
        for (int i=1;i<listaOpciones2.size();i++)
        {
            if (listaOpciones2.get(i).getIdPreguntaRaiz().getIdPregunta().equals(pPregunta.getIdPregunta()))
            {
                listaOpciones.add(listaOpciones2.get(i));
            }
        }
        
        return listaOpciones;
    }
    
//    public boolean validarPregunta(OpcionesPreguntas opcionSeleccionada)
//    {
//        boolean correcto = true;
//      
//    }
    
    public boolean existeJugador(BigDecimal cedula)
    {
        boolean existeJugador = false;
        
        List<Jugador> listaJugadores = jugador.listarJugadores();
        
        for (int i = 0; i< listaJugadores.size();i++)
        {
            if (listaJugadores.get(i).getIdJugador().equals(cedula)) 
            {
                existeJugador = true;
            }
        }
        
        return existeJugador;
    }
    
    public void registrarJugador(Jugador pJugador)
    {
        jugador.crear(pJugador);
    }
    
    public boolean esCorrectaLaRespuesta(String pDescripcionRespuesta)
    {
        boolean existe = false;
        List<Respuesta> respuestas = respuesta.listarRespuestas();
        BigDecimal idBuscado = buscarIdRespuesta(pDescripcionRespuesta);
        
        for (int i = 0; i < respuestas.size(); i ++)
        {
           
            if (respuestas.get(i).getIdOpcionfk().getIdOpcion().equals(idBuscado))
             {
                   existe = true;     
             }
        }
        
        return existe;
        
    }
    
    public void crearPartida()
    {
        List<Partida> listaPartidas =  partida.listarPartidas();
        BigDecimal ultimoId = new BigDecimal(0);
        for (int i = 0; i<listaPartidas.size();i ++)
        {
            ultimoId = listaPartidas.get(i).getIdPartida();
        }
        int numero = ultimoId.intValue() + 1;
        
        BigDecimal actual = new BigDecimal(numero);
        
        Partida partidaHoy = new Partida(actual, new Date());
        partida.crear(partidaHoy);
    }
    
    public BigDecimal buscarIdRespuesta(String pDescripcionRespuesta)
    {
        List<OpcionesPreguntas> listaOpciones = this.opciones.listarOpciones();
        BigDecimal respuesta = new BigDecimal(78787);
        
        for (int i= 0; i< listaOpciones.size();i++)
        {
            if (listaOpciones.get(i).getDescripcionOpcion().equals(pDescripcionRespuesta))
            {
                respuesta = listaOpciones.get(i).getIdOpcion();
            }
        }
        return respuesta;
    }

    /*
       @return Devuelve la categoria que corresponde a la ronda dada por parámetro
        
    */
    public String buscarCategoriaPorRonda (int pRonda) 
    {
        llenarLListaOpciones();
        
        String categoriaBuscada = "";
       
        switch (pRonda) {
        case  1:
            categoriaBuscada = "DEPORTES";
            break;
        case  2:
            categoriaBuscada = "TECNOLOGIA";
            break;   
        case  3:
            categoriaBuscada = "CIENCIA";
            break;    
        case  4:
            categoriaBuscada = "ARTE";
            break;    
        case  5:
            categoriaBuscada = "HISTORIA";
            break;    
        }
                
          return  categoriaBuscada;   
        
    }
    
    public BigDecimal buscarIdCategoriaPorDescripcion(String pDescripcion){
        
        BigDecimal idBuscado = null;
        List <CategoriaPregunta> listaCategorias = categoria.listarCategorias();
        for (int i= 0; i < listaCategorias.size();i++) {
            
            String dscripcion = listaCategorias.get(i).getNombreCategoria();
            if (dscripcion.equals(pDescripcion)  ) {
                idBuscado = listaCategorias.get(i).getIdCategoria();
                
            }
        }
        return idBuscado;
    }
    
   
    
    
    
}
