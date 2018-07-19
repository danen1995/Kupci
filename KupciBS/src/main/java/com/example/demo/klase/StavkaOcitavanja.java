/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "STAVKA_OCITAVANJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StavkaOcitavanja.findAll", query = "SELECT s FROM StavkaOcitavanja s"),
    @NamedQuery(name = "StavkaOcitavanja.findByUtroseno", query = "SELECT s FROM StavkaOcitavanja s WHERE s.utroseno = :utroseno"),
    @NamedQuery(name = "StavkaOcitavanja.findByIdStavkeOc", query = "SELECT s FROM StavkaOcitavanja s WHERE s.stavkaOcitavanjaPK.idStavkeOc = :idStavkeOc"),
    @NamedQuery(name = "StavkaOcitavanja.findByIdOcitavanja", query = "SELECT s FROM StavkaOcitavanja s WHERE s.stavkaOcitavanjaPK.idOcitavanja = :idOcitavanja")})
public class StavkaOcitavanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaOcitavanjaPK stavkaOcitavanjaPK;
    @Column(name = "UTROSENO")
    private BigInteger utroseno;
    @JoinColumn(name = "ID_OCITAVANJA", referencedColumnName = "ID_OCITAVANJA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ocitavanje ocitavanje;
    @JoinColumn(name = "ID_TARIFE", referencedColumnName = "ID_TARIFE")
    @ManyToOne
    @JsonManagedReference
    private Tarifa idTarife;

    public StavkaOcitavanja() {
    }

    public StavkaOcitavanja(StavkaOcitavanjaPK stavkaOcitavanjaPK) {
        this.stavkaOcitavanjaPK = stavkaOcitavanjaPK;
    }

    public StavkaOcitavanja(BigInteger idStavkeOc, BigInteger idOcitavanja) {
        this.stavkaOcitavanjaPK = new StavkaOcitavanjaPK(idStavkeOc, idOcitavanja);
    }

    public StavkaOcitavanjaPK getStavkaOcitavanjaPK() {
        return stavkaOcitavanjaPK;
    }

    public void setStavkaOcitavanjaPK(StavkaOcitavanjaPK stavkaOcitavanjaPK) {
        this.stavkaOcitavanjaPK = stavkaOcitavanjaPK;
    }

    public BigInteger getUtroseno() {
        return utroseno;
    }

    public void setUtroseno(BigInteger utroseno) {
        this.utroseno = utroseno;
    }

    public Ocitavanje getOcitavanje() {
        return ocitavanje;
    }

    public void setOcitavanje(Ocitavanje ocitavanje) {
        this.ocitavanje = ocitavanje;
    }

    public Tarifa getIdTarife() {
        return idTarife;
    }

    public void setIdTarife(Tarifa idTarife) {
        this.idTarife = idTarife;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaOcitavanjaPK != null ? stavkaOcitavanjaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaOcitavanja)) {
            return false;
        }
        StavkaOcitavanja other = (StavkaOcitavanja) object;
        if ((this.stavkaOcitavanjaPK == null && other.stavkaOcitavanjaPK != null) || (this.stavkaOcitavanjaPK != null && !this.stavkaOcitavanjaPK.equals(other.stavkaOcitavanjaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.StavkaOcitavanja[ stavkaOcitavanjaPK=" + stavkaOcitavanjaPK + " ]";
    }
    
}
