/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id1212.adisu.homework4.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ema
 */
@Entity
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String cName;
    private Double rate;

    public Currencies() {
    }

    public Currencies(Integer id, String cName, Double rate) {
        this.id = id;
        this.cName = cName;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Currencies)) {
            return false;
        }
        Currencies other = (Currencies) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.cName);
        hash = 97 * hash + Objects.hashCode(this.rate);
        return hash;
    }

    @Override
    public String toString() {
        return "Currencies[ id=" + id + " ]";
    }

}
