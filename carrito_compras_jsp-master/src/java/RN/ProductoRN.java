/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import dao.ProductoDAO;
import java.util.List;
import model.Producto;
/**
 *
 * @author cgallardo
 */
public class ProductoRN {
    public static List<Producto> listarProductos() throws Exception {
        ProductoDAO prodDao = new ProductoDAO();
        return prodDao.getProductos();
    }
    public static Producto obtenerProductoById(int idProducto) throws Exception {
        ProductoDAO prodDao = new ProductoDAO();
        return prodDao.getProductoById(idProducto);
    }
}
