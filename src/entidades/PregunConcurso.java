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
@Table(name = "pregun_concurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PregunConcurso.findAll", query = "SELECT p FROM PregunConcurso p")
    , @NamedQuery(name = "PregunConcurso.findByIdPregunta", query = "SELECT p FROM PregunConcurso p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "PregunConcurso.findByDescripPregunta", query = "SELECT p FROM PregunConcurso p WHERE p.descripPregunta = :descripPregunta")})
public class PregunConcurso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private BigDecimal idPregunta;
    @Column(name = "descrip_pregunta")
    private String descripPregunta;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private CategoriaPregunta idCategoria;
    @OneToMany(mappedBy = "idPregunta")
    private Collection<HistorialJuego> historialJuegoCollection;
    @OneToMany(mappedBy = "idPreguntaRaiz")
    private Collection<OpcionesPreguntas> opcionesPreguntasCollection;
    @OneToMany(mappedBy = "idPregunta")
    private Collection<Respuesta> respuestaCollection;

    public PregunConcurso() {
    }

    public PregunConcurso(BigDecimal idPregunta) {
        this.idPregunta = idPregunta;
    }

    public BigDecimal getIdPregunta() {
        return idPregunta;
    }
 

    public void setIdPregunta(BigDecimal idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripPregunta() {
        return descripPregunta;
    }

    public void setDescripPregunta(String descripPregunta) {
        this.descripPregunta = descripPregunta;
    }

    public CategoriaPregunta getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaPregunta idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<HistorialJuego> getHistorialJuegoCollection() {
        return historialJuegoCollection;
    }

    public void setHistorialJuegoCollection(Collection<HistorialJuego> historialJuegoCollection) {
        this.historialJuegoCollection = historialJuegoCollection;
    }

    @XmlTransient
    public Collection<OpcionesPreguntas> getOpcionesPreguntasCollection() {
        return opcionesPreguntasCollection;
    }

    public void setOpcionesPreguntasCollection(Collection<OpcionesPreguntas> opcionesPreguntasCollection) {
        this.opcionesPreguntasCollection = opcionesPreguntasCollection;
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
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregunConcurso)) {
            return false;
        }
        PregunConcurso other = (PregunConcurso) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.PregunConcurso[ idPregunta=" + idPregunta + " ]";
    }
    
}
