/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id1212.adisu.homework4.integration;

import id1212.adisu.homework4.model.Currencies;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ema
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {

    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;

    public CurrencyDAO() {
    }

    public List<Currencies> getCurrencies() {
        Query query = em.createQuery("SELECT c FROM Currencies c", Currencies.class);
        List<Currencies> rs = query.getResultList();
        return rs;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        getCurrencies().forEach((curn) -> {
            names.add(curn.getCName());
        });
        return names;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = 0.0, toRate = 0.0;
        for (Currencies crn : getCurrencies()) {
            if (crn.getCName().equals(fromCurrency)) {
                fromRate = crn.getRate();
            }
            if (crn.getCName().equals(toCurrency)) {
                toRate = crn.getRate();
            }
        }
        return amount * (toRate / fromRate);
    }
}
