/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "KUPAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupac.findAll", query = "SELECT k FROM Kupac k"),
    @NamedQuery(name = "Kupac.findByIdKupca", query = "SELECT k FROM Kupac k WHERE k.idKupca = :idKupca"),
    @NamedQuery(name = "Kupac.findByNaziv", query = "SELECT k FROM Kupac k WHERE k.naziv = :naziv"),
    @NamedQuery(name = "Kupac.findByTip", query = "SELECT k FROM Kupac k WHERE k.tip = :tip"),
    @NamedQuery(name = "Kupac.findByJmbg", query = "SELECT k FROM Kupac k WHERE k.jmbg = :jmbg"),
    @NamedQuery(name = "Kupac.findByPib", query = "SELECT k FROM Kupac k WHERE k.pib = :pib"),
    @NamedQuery(name = "Kupac.findByNaplatniBroj", query = "SELECT k FROM Kupac k WHERE k.naplatniBroj = :naplatniBroj"),
    @NamedQuery(name = "Kupac.findByMaticniBroj", query = "SELECT k FROM Kupac k WHERE k.maticniBroj = :maticniBroj"),
    @NamedQuery(name = "Kupac.findByProsireniNaziv", query = "SELECT k FROM Kupac k WHERE k.prosireniNaziv = :prosireniNaziv")})
public class Kupac implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_KUPCA")
    private BigDecimal idKupca;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "TIP")
    private String tip;
    @Column(name = "JMBG")
    private String jmbg;
    @Column(name = "PIB")
    private BigInteger pib;
    @Basic(optional = false)
    @Column(name = "NAPLATNI_BROJ")
    private String naplatniBroj;
    @Column(name = "MATICNI_BROJ")
    private String maticniBroj;
    @Column(name = "PROSIRENI_NAZIV")
    private String prosireniNaziv;
    @JoinColumn(name = "ID_ADRESE_SR", referencedColumnName = "ID_ADRESE")
    @ManyToOne
    @JsonManagedReference
    private Adresa idAdreseSr;
    @JoinColumn(name = "ID_POTROSACA", referencedColumnName = "ID_POTROSACA")
    @ManyToOne
    @JsonManagedReference
    private Potrosac idPotrosaca;
    @OneToMany(mappedBy = "idKupca")
    @JsonBackReference
    private Collection<Korisnik> korisnikCollection;

    public Kupac() {
    }

    public Kupac(BigDecimal idKupca) {
        this.idKupca = idKupca;
    }

    public Kupac(BigDecimal idKupca, String naziv, String tip, String naplatniBroj) {
        this.idKupca = idKupca;
        this.naziv = naziv;
        this.tip = tip;
        this.naplatniBroj = naplatniBroj;
    }

    public BigDecimal getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(BigDecimal idKupca) {
        this.idKupca = idKupca;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public BigInteger getPib() {
        return pib;
    }

    public void setPib(BigInteger pib) {
        this.pib = pib;
    }

    public String getNaplatniBroj() {
        return naplatniBroj;
    }

    public void setNaplatniBroj(String naplatniBroj) {
        this.naplatniBroj = naplatniBroj;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getProsireniNaziv() {
        return prosireniNaziv;
    }

    public void setProsireniNaziv(String prosireniNaziv) {
        this.prosireniNaziv = prosireniNaziv;
    }

    public Adresa getIdAdreseSr() {
        return idAdreseSr;
    }

    public void setIdAdreseSr(Adresa idAdreseSr) {
        this.idAdreseSr = idAdreseSr;
    }

    public Potrosac getIdPotrosaca() {
        return idPotrosaca;
    }

    public void setIdPotrosaca(Potrosac idPotrosaca) {
        this.idPotrosaca = idPotrosaca;
    }

    @XmlTransient
    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKupca != null ? idKupca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kupac)) {
            return false;
        }
        Kupac other = (Kupac) object;
        if ((this.idKupca == null && other.idKupca != null) || (this.idKupca != null && !this.idKupca.equals(other.idKupca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication15.Kupac[ idKupca=" + idKupca + " ]";
    }
    
}
