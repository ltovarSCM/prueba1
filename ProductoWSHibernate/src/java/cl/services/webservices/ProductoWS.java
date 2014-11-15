/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.services.webservices;

import cl.model.dao.ProductoDAO;
import cl.model.pojos.Producto;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bgambin
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarProducto")
    public String IngresarProducto(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "descripcion") String descripcion) {
        Producto p = new Producto (codigo,nombre, precio, stock, descripcion );
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.ingresarProducto(p);
        return "Producto ingresado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarProducto")
    public String BuscarProducto(@WebParam(name = "codigo") int codigo) {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.consularProducto(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarProductos")
    public List<Producto> ListarProductos() {
         ProductoDAO productoDAO = new ProductoDAO();
         List<Producto> listarProductos = productoDAO.listarProductos();
        return listarProductos;
    }
}
