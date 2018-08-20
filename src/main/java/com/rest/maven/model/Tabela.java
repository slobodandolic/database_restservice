package com.rest.maven.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Slobodan.Dolic
 */
@Entity
@Table(name = "tabela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabela.findAll", query = "SELECT t FROM Tabela t")
    , @NamedQuery(name = "Tabela.findById", query = "SELECT t FROM Tabela t WHERE t.id = :id")
    , @NamedQuery(name = "Tabela.findByKod", query = "SELECT t FROM Tabela t WHERE t.kod = :kod")
    , @NamedQuery(name = "Tabela.findByNagrada", query = "SELECT t FROM Tabela t WHERE t.nagrada = :nagrada")
    , @NamedQuery(name = "Tabela.findByProveren", query = "SELECT t FROM Tabela t WHERE t.proveren = :proveren")})
public class Tabela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "kod")
    private String kod;
    @Size(max = 45)
    @Column(name = "nagrada")
    private String nagrada;
    @Column(name = "proveren")
    private Integer proveren;
    

    public Tabela() {
    }

    public Tabela(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getNagrada() {
        return nagrada;
    }

    public void setNagrada(String nagrada) {
        this.nagrada = nagrada;
    }

    public Integer getProveren() {
        return proveren;
    }

    public void setProveren(Integer proveren) {
        this.proveren = proveren;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tabela)) {
            return false;
        }
        Tabela other = (Tabela) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rest.maven.model.Tabela[ id=" + id + " ]";
    }
    
}