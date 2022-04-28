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
@Table(name = "premio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Premio.findAll", query = "SELECT p FROM Premio p")
    , @NamedQuery(name = "Premio.findByIdPremio", query = "SELECT p FROM Premio p WHERE p.idPremio = :idPremio")
    , @NamedQuery(name = "Premio.findByValorPremio", query = "SELECT p FROM Premio p WHERE p.valorPremio = :valorPremio")})
public class Premio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_premio")
    private BigDecimal idPremio;
    @Column(name = "valor_premio")
    private BigInteger valorPremio;
    @OneToMany(mappedBy = "idPremio")
    private Collection<HistorialJuego> historialJuegoCollection;
    @JoinColumn(name = "id_ronda", referencedColumnName = "id_ronda")
    @ManyToOne
    private Ronda idRonda;

    public Premio() {
    }

    public Premio(BigDecimal idPremio) {
        this.idPremio = idPremio;
    }

    public BigDecimal getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(BigDecimal idPremio) {
        this.idPremio = idPremio;
    }

    public BigInteger getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(BigInteger valorPremio) {
        this.valorPremio = valorPremio;
    }

    @XmlTransient
    public Collection<HistorialJuego> getHistorialJuegoCollection() {
        return historialJuegoCollection;
    }

    public void setHistorialJuegoCollection(Collection<HistorialJuego> historialJuegoCollection) {
        this.historialJuegoCollection = historialJuegoCollection;
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
        hash += (idPremio != null ? idPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Premio)) {
            return false;
        }
        Premio other = (Premio) object;
        if ((this.idPremio == null && other.idPremio != null) || (this.idPremio != null && !this.idPremio.equals(other.idPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.Premio[ idPremio=" + idPremio + " ]";
    }
    
}
