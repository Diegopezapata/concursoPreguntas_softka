/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Analista de sistemas
 */
@Entity
@Table(name = "opciones_preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionesPreguntas.findAll", query = "SELECT o FROM OpcionesPreguntas o")
    , @NamedQuery(name = "OpcionesPreguntas.findByIdOpcion", query = "SELECT o FROM OpcionesPreguntas o WHERE o.idOpcion = :idOpcion")
    , @NamedQuery(name = "OpcionesPreguntas.findByDescripcionOpcion", query = "SELECT o FROM OpcionesPreguntas o WHERE o.descripcionOpcion = :descripcionOpcion")})
public class OpcionesPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private BigDecimal idOpcion;
    @Column(name = "descripcion_opcion")
    private String descripcionOpcion;
    @OneToMany(mappedBy = "idOpcionseleccionada")
    private Collection<HistorialJuego> historialJuegoCollection;
    @JoinColumn(name = "id_pregunta_raiz", referencedColumnName = "id_pregunta")
    @ManyToOne
    private PregunConcurso idPreguntaRaiz;
    @OneToMany(mappedBy = "idOpcionfk")
    private Collection<Respuesta> respuestaCollection;

    public OpcionesPreguntas() {
    }

    public OpcionesPreguntas(BigDecimal idOpcion) {
        this.idOpcion = idOpcion;
    }

    public BigDecimal getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(BigDecimal idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }

    @XmlTransient
    public Collection<HistorialJuego> getHistorialJuegoCollection() {
        return historialJuegoCollection;
    }

    public void setHistorialJuegoCollection(Collection<HistorialJuego> historialJuegoCollection) {
        this.historialJuegoCollection = historialJuegoCollection;
    }

    public PregunConcurso getIdPreguntaRaiz() {
        return idPreguntaRaiz;
    }

    public void setIdPreguntaRaiz(PregunConcurso idPreguntaRaiz) {
        this.idPreguntaRaiz = idPreguntaRaiz;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionesPreguntas)) {
            return false;
        }
        OpcionesPreguntas other = (OpcionesPreguntas) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.OpcionesPreguntas[ idOpcion=" + idOpcion + " ]";
    }
    
}
