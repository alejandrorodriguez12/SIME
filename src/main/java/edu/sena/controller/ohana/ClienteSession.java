/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Clientes;
import edu.sena.facade.ohana.ClientesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "clienteSession")
@SessionScoped
public class ClienteSession implements Serializable {

    @EJB
    ClientesFacadeLocal clientesFacadeLocal;

    private Clientes crecli = new Clientes();
    private Clientes logcli = new Clientes();

    /**
     * Creates a new instance of ClienteSession
     */
    public ClienteSession() {
    }

    public List<Clientes> leerTodo() {
        return clientesFacadeLocal.leerTodo();
    }

    public void crearCliente() {
        if (clientesFacadeLocal.crearCliente(crecli)) {
            System.out.println("Cliente creado");
        } else {
            System.out.println("Error, creando usuario");
        }

    }
    

    
    

    public Clientes getCrecli() {
        return crecli;
    }

    public void setCrecli(Clientes crecli) {
        this.crecli = crecli;
    }

    public Clientes getLogcli() {
        return logcli;
    }

    public void setLogcli(Clientes logcli) {
        this.logcli = logcli;
    }

}
