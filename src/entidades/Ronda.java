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
@Table(name = "ronda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ronda.findAll", query = "SELECT r FROM Ronda r")
    , @NamedQuery(name = "Ronda.findByIdRonda", query = "SELECT r FROM Ronda r WHERE r.idRonda = :idRonda")})
public class Ronda implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_ronda")
    private BigDecimal idRonda;
    @OneToMany(mappedBy = "idRonda")
    private Collection<HistorialJuego> historialJuegoCollection;
    @OneToMany(mappedBy = "idRonda")
    private Collection<Premio> premioCollection;

    public Ronda() {
    }

    public Ronda(BigDecimal idRonda) {
        this.idRonda = idRonda;
    }

    public BigDecimal getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(BigDecimal idRonda) {
        this.idRonda = idRonda;
    }

    @XmlTransient
    public Collection<HistorialJuego> getHistorialJuegoCollection() {
        return historialJuegoCollection;
    }

    public void setHistorialJuegoCollection(Collection<HistorialJuego> historialJuegoCollection) {
        this.historialJuegoCollection = historialJuegoCollection;
    }

    @XmlTransient
    public Collection<Premio> getPremioCollection() {
        return premioCollection;
    }

    public void setPremioCollection(Collection<Premio> premioCollection) {
        this.premioCollection = premioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRonda != null ? idRonda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ronda)) {
            return false;
        }
        Ronda other = (Ronda) object;
        if ((this.idRonda == null && other.idRonda != null) || (this.idRonda != null && !this.idRonda.equals(other.idRonda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.Ronda[ idRonda=" + idRonda + " ]";
    }
    
}
