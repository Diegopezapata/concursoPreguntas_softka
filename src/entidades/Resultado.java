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
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r")
    , @NamedQuery(name = "Resultado.findByIdResultado", query = "SELECT r FROM Resultado r WHERE r.idResultado = :idResultado")
    , @NamedQuery(name = "Resultado.findByValorResultado", query = "SELECT r FROM Resultado r WHERE r.valorResultado = :valorResultado")})
public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_resultado")
    private BigDecimal idResultado;
    @Column(name = "valor_resultado")
    private String valorResultado;
    @OneToMany(mappedBy = "idResultado")
    private Collection<HistorialJuego> historialJuegoCollection;

    public Resultado() {
    }

    public Resultado(BigDecimal idResultado) {
        this.idResultado = idResultado;
    }

    public BigDecimal getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(BigDecimal idResultado) {
        this.idResultado = idResultado;
    }

    public String getValorResultado() {
        return valorResultado;
    }

    public void setValorResultado(String valorResultado) {
        this.valorResultado = valorResultado;
    }

    @XmlTransient
    public Collection<HistorialJuego> getHistorialJuegoCollection() {
        return historialJuegoCollection;
    }

    public void setHistorialJuegoCollection(Collection<HistorialJuego> historialJuegoCollection) {
        this.historialJuegoCollection = historialJuegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultado != null ? idResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.idResultado == null && other.idResultado != null) || (this.idResultado != null && !this.idResultado.equals(other.idResultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases_jpa.Resultado[ idResultado=" + idResultado + " ]";
    }
    
}
