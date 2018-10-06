/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cecy
 */
public class Carrito {
    private List<Producto> productos = new ArrayList();

    public List<Producto> getProductos() {
        return productos;
    }
    
    
    public void agregarProducto(Producto producto) {
//        boolean existe=false;
//        for(Producto p : this.productos) {
//            if(p.getId() == producto.getId()) {
//                existe=true;
//            }
//        }
//        
//        if (!existe) {
//            this.productos.add(producto);
//        }
        if (!this.productos.contains(producto)) {
            this.productos.add(producto);
        }
        
    }
  
    public int contarProductos(){
        return this.productos.size();
    }
  
    public BigDecimal sumarMontoProductos(){
      BigDecimal suma= new BigDecimal(0);
      for (Producto p : this.productos) {
         suma=suma.add(p.getPrecio()); 
      }
      return suma.setScale(2, BigDecimal.ROUND_DOWN);
    }
  
    public void eliminarProducto(Producto producto) {
	this.productos.remove(producto);	
    }
}
