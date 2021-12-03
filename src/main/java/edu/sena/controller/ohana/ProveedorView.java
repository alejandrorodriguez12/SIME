
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Proveedores;
import edu.sena.facade.ohana.ProveedoresFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author 57301
 */
@Named(value = "proveedorView")
@ViewScoped
public class ProveedorView implements Serializable{
@EJB
ProveedoresFacadeLocal proveedoresFacadeLocal;

private Proveedores provagr = new Proveedores();
    
    public ProveedorView() {
    }
    
    public List<Proveedores> leerTodo(){
        return proveedoresFacadeLocal.leerTodo();
    }
    
    public void agregarProveedor(){
        if (proveedoresFacadeLocal.agregarProveedor(provagr)) {
            System.out.println("Proveedor agregado");
        }else{
            System.out.println("Error agregando proveedor");
        }
        
    }

    public Proveedores getProvagr() {
        return provagr;
    }

    public void setProvagr(Proveedores provagr) {
        this.provagr = provagr;
    }
}
