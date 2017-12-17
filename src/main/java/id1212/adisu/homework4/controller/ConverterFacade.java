/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id1212.adisu.homework4.controller;

import id1212.adisu.homework4.integration.CurrencyDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author ema
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ConverterFacade {

    @EJB
    private CurrencyDAO currenDB;

    public double convert(double amount, String cFrom, String cTo) {
        return currenDB.convert(amount, cFrom, cTo);
    }

    public List<String> listNames() {
        return currenDB.getNames();
    }
}
