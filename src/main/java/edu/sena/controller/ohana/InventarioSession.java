/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Inventario;
import edu.sena.facade.ohana.InventarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author 57301
 */
@Named(value = "inventarioSession")
@SessionScoped
public class InventarioSession implements Serializable {
@EJB
InventarioFacadeLocal inventarioFacadeLocal;
    /**
     * Creates a new instance of InventarioSession
     */
    public InventarioSession() {
    }
    
    public List<Inventario> leerTodo(){
        return inventarioFacadeLocal.findAll();
    }
    
}
