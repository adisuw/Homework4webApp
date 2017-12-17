/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id1212.adisu.homework4.view;

/**
 *
 * @author ema
 */
import id1212.adisu.homework4.controller.ConverterFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "converterManager")
@RequestScoped
public class CurrencyConverter implements Serializable {

    @EJB
    private ConverterFacade converterFacade;

    private String fromCurrency;
    private String toCurrency;
    private double amount = 0.0;
    private double convertedValue;
    private final List<String> nameOptions;
    private Exception failed;
    public CurrencyConverter(){
        //nameOptions = converterFacade.listNames();
        nameOptions = new ArrayList<>();
        nameOptions.add("SEK");
        nameOptions.add("USD");
        nameOptions.add("ETBirr");
        nameOptions.add("Euro");
    }
    public List<String> getNameOptions(){
        return nameOptions;
    }
    public void convert() {
        try{
        convertedValue = converterFacade.convert(amount, fromCurrency, toCurrency);
        }catch(Exception e){
            failed = e;
        }
    }
    public boolean getSuccess(){
        return failed == null;
    }
     public Exception getFailed(){
         return failed;
     }
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double val) {
        this.convertedValue = val;
    }

}
