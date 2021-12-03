/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    @Override
    public List<Productos> leerTodo() {

        em.getEntityManagerFactory().getCache().evictAll();
        Query prod = em.createQuery("SELECT u FROM Productos u");
        return prod.getResultList();
    }

    @Override
    public boolean agregarProducto(Productos prodagr) {
        try {
            Query prod = em.createNativeQuery("INSERT INTO productos (idProducto,idTipoProducto,talla,tamanio,color) VALUES (?,?,?,?,?);");
            prod.setParameter(1, prodagr.getIdProducto());
            prod.setParameter(2, prodagr.getIdTipoProducto().getIdTipoProducto());
            prod.setParameter(3, prodagr.getTalla());
            prod.setParameter(4, prodagr.getTamanio());
            prod.setParameter(5, prodagr.getColor());
            prod.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
