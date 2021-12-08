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
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

@Named(value = "productoView")
@ViewScoped
public class ProductoView implements Serializable {

    @EJB
    ProductosFacadeLocal productosFacadeLocal;

    private Productos prodagr = new Productos();

    public ProductoView() {
    }

    public List<Productos> leerTodo() {
        return productosFacadeLocal.leerTodo();
    }

    public void agregarProducto() {
        if (productosFacadeLocal.agregarProducto(prodagr)) {
            System.out.println("Producto agregado");
        } else {
            System.out.println("Error agregando el producto");
        }

    }

    public void actualizarProducto() {
        try {
            productosFacadeLocal.edit(prodagr);
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Actualizado con exito', "
                    + " 'success'"
                    + ")");

        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo actualizar', "
                    + " 'error'"
                    + ")");
        }
    }

    public Productos getProdagr() {
        return prodagr;
    }

    public void setProdagr(Productos prodagr) {
        this.prodagr = prodagr;
    }

}
