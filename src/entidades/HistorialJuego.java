/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Analista de sistemas
 */
@Entity
@Table(name = "historial_juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialJuego.findAll", query = "SELECT h FROM HistorialJuego h")
    , @NamedQuery(name = "HistorialJuego.findByIdPartida", query = "SELECT h FROM HistorialJuego h WHERE h.historialJuegoPK.idPartida = :idPartida")
    , @NamedQuery(name = "HistorialJuego.findByIdJugador", query = "SELECT h FROM HistorialJuego h WHERE h.historialJuegoPK.idJugador = :idJugador")})
public class HistorialJuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistorialJuegoPK historialJuegoPK;
    @JoinColumn(name = "id_opcionseleccionada", referencedColumnName = "id_opcion")
    @ManyToOne
    private OpcionesPreguntas idOpcionseleccionada;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta")
    @ManyToOne
    private PregunConcurso idPregunta;
    @JoinColumn(name = "id_premio", referencedColumnName = "id_premio")
    @ManyToOne
    private Premio idPremio;
    @JoinColumn(name = "id_resultado", referencedColumnName = "id_resultado")
    @ManyToOne
    private Resultado idResultado;
    @JoinColumn(name = "id_ronda", referencedColumnName = "id_ronda")
    @ManyToOne
    private Ronda idRonda;

    public HistorialJuego() {
    }

    public HistorialJuego(HistorialJuegoPK historialJuegoPK) {
        this.historialJuegoPK = historialJuegoPK;
    }

    public HistorialJuego(BigInteger idPartida, BigInteger idJugador) {
        this.historialJuegoPK = new HistorialJuegoPK(idPartida, idJugador);
    }

    public HistorialJuegoPK getHistorialJuegoPK() {
        return historialJuegoPK;
    }

    public void setHistorialJuegoPK(HistorialJuegoPK historialJuegoPK) {
        this.historialJuegoPK = historialJuegoPK;
    }

    public OpcionesPreguntas getIdOpcionseleccionada() {
        return idOpcionseleccionada;
    }

    public void setIdOpcionseleccionada(OpcionesPreguntas idOpcionseleccionada) {
        this.idOpcionseleccionada = idOpcionseleccionada;
    }

    public PregunConcurso getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(PregunConcurso idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Premio getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(Premio idPremio) {
        this.idPremio = idPremio;
    }

    public Resultado getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Resultado idResultado) {
        this.idResultado = idResultado;
    }

    public Ronda getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(Ronda idRonda) {
        this.idRonda = idRonda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialJuegoPK != null ? historialJuegoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialJuego)) {
            return false;
        }
        HistorialJuego other = (HistorialJuego) object;
        if ((this.historialJuegoPK == null && other.historialJuegoPK != null) || (this.historialJuegoPK != null && !this.historialJuegoPK.equals(other.historialJuegoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.HistorialJuego[ historialJuegoPK=" + historialJuegoPK + " ]";
    }
    
}
