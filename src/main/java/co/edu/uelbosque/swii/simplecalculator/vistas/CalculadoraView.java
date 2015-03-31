/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.swii.simplecalculator.vistas;

import analizadorsintactico.AnalizadorSintactico;
import java.util.Observable;
import java.util.Observer;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelo.Opera;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Alejandro
 */
@ManagedBean(name = "calculadora")
@SessionScoped
public class CalculadoraView implements Observer{
    
    private String infijo;
    AnalizadorSintactico as;

    public CalculadoraView() {
        as=new AnalizadorSintactico();
        as.addObserver(this);
        r="Resolviendo";
    }
    
    

    public void setInfijo(String infijo) {
        System.out.println("rrrrr "+infijo);
        this.infijo = infijo;
        char posfijo[]=new char[infijo.length()];
        as.infijoAPosfijo(infijo.toCharArray(), posfijo);
    }

    public String getInfijo() {
        return infijo;
    }

    private String r;
    @Override
    public void update(Observable o, Object arg) {
        if(!(arg instanceof Opera)) 
            throw new IllegalArgumentException("Argumento invalido");
        Opera op=(Opera)arg;
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        setR(op.toString());
        System.out.println(getR());
        eventBus.publish("/operacion", op.toString());
    }

    /**
     * @return the r
     */
    public String getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(String r) {
        this.r = r;
    }
    
    
}
