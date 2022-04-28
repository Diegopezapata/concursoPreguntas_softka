/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "categoria_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaPregunta.findAll", query = "SELECT c FROM CategoriaPregunta c")
    , @NamedQuery(name = "CategoriaPregunta.findByIdCategoria", query = "SELECT c FROM CategoriaPregunta c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaPregunta.findByNombreCategoria", query = "SELECT c FROM CategoriaPregunta c WHERE c.nombreCategoria = :nombreCategoria")
    , @NamedQuery(name = "CategoriaPregunta.findByDificultadCategoria", query = "SELECT c FROM CategoriaPregunta c WHERE c.dificultadCategoria = :dificultadCategoria")})
public class CategoriaPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private BigDecimal idCategoria;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Column(name = "dificultad_categoria")
    private BigInteger dificultadCategoria;
    @OneToMany(mappedBy = "idCategoria")
    private Collection<PregunConcurso> pregunConcursoCollection;

    public CategoriaPregunta() {
    }

    public Collection<PregunConcurso> getPregunConcursoCollection() {
        return pregunConcursoCollection;
    }

    public void setPregunConcursoCollection(Collection<PregunConcurso> pregunConcursoCollection) {
        this.pregunConcursoCollection = pregunConcursoCollection;
    }

    public CategoriaPregunta(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public BigInteger getDificultadCategoria() {
        return dificultadCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPregunta)) {
            return false;
        }
        CategoriaPregunta other = (CategoriaPregunta) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.CategoriaPregunta[ idCategoria=" + idCategoria + " ]";
    }
    
}
