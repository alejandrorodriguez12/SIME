/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Productos;
import edu.sena.facade.ohana.ProductosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author 57301
 */
@Named(value = "productoView")
@ViewScoped
public class ProductoView implements Serializable{
@EJB
ProductosFacadeLocal productosFacadeLocal;
    /**
     * Creates a new instance of ProductoView
     */
    public ProductoView() {
    }
    
    public List<Productos> leerTodo(){
        return productosFacadeLocal.leerTodo();
    }
    
}
