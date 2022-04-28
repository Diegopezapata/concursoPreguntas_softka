/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Analista de sistemas
 */
@Embeddable
public class HistorialJuegoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_partida")
    private BigInteger idPartida;
    @Basic(optional = false)
    @Column(name = "id_jugador")
    private BigInteger idJugador;

    public HistorialJuegoPK() {
    }

    public HistorialJuegoPK(BigInteger idPartida, BigInteger idJugador) {
        this.idPartida = idPartida;
        this.idJugador = idJugador;
    }

    public BigInteger getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(BigInteger idPartida) {
        this.idPartida = idPartida;
    }

    public BigInteger getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(BigInteger idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialJuegoPK)) {
            return false;
        }
        HistorialJuegoPK other = (HistorialJuegoPK) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.HistorialJuegoPK[ idPartida=" + idPartida + ", idJugador=" + idJugador + " ]";
    }
    
}
