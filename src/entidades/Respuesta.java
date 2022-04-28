/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_respuesta")
    private BigDecimal idRespuesta;
    @JoinColumn(name = "id_opcionfk", referencedColumnName = "id_opcion")
    @ManyToOne
    private OpcionesPreguntas idOpcionfk;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta")
    @ManyToOne
    private PregunConcurso idPregunta;

    public Respuesta() {
    }

    public Respuesta(BigDecimal idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public BigDecimal getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(BigDecimal idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public OpcionesPreguntas getIdOpcionfk() {
        return idOpcionfk;
    }

    public void setIdOpcionfk(OpcionesPreguntas idOpcionfk) {
        this.idOpcionfk = idOpcionfk;
    }

    public PregunConcurso getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(PregunConcurso idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
