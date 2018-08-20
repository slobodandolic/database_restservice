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
 * @author Slobodan.Colic
 */
@Entity
@Table(name = "tabelakorisnici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabelakorisnici.findAll", query = "SELECT t FROM Tabelakorisnici t")
    , @NamedQuery(name = "Tabelakorisnici.findByIdkorisnika", query = "SELECT t FROM Tabelakorisnici t WHERE t.idkorisnika = :idkorisnika")
    , @NamedQuery(name = "Tabelakorisnici.findByIdnagrade", query = "SELECT t FROM Tabelakorisnici t WHERE t.idnagrade = :idnagrade")})
public class TabelaKorisnici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idkorisnika")
    private String idkorisnika;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnagrade")
    private Integer idnagrade;

    public TabelaKorisnici() {
    }

    public TabelaKorisnici(Integer idnagrade) {
        this.idnagrade = idnagrade;
    }

    public TabelaKorisnici(Integer idnagrade, String idkorisnika) {
        this.idnagrade = idnagrade;
        this.idkorisnika = idkorisnika;
    }

    public String getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(String idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public Integer getIdnagrade() {
        return idnagrade;
    }

    public void setIdnagrade(Integer idnagrade) {
        this.idnagrade = idnagrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnagrade != null ? idnagrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaKorisnici)) {
            return false;
        }
        TabelaKorisnici other = (TabelaKorisnici) object;
        if ((this.idnagrade == null && other.idnagrade != null) || (this.idnagrade != null && !this.idnagrade.equals(other.idnagrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Tabelakorisnici[ idnagrade=" + idnagrade + " ]";
    }
    
}

