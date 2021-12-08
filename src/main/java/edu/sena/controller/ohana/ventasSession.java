/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Ventas;
import edu.sena.facade.ohana.VentasFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author 57301
 */
@Named(value = "ventasSession")
@SessionScoped
public class ventasSession implements Serializable {
@EJB
VentasFacadeLocal ventasFacadeLocal;
    /**
     * Creates a new instance of ventasSession
     */
    public ventasSession() {
    }
    
    public List<Ventas> leerTodo(){
        return ventasFacadeLocal.leerTodo();
    }
    
}
