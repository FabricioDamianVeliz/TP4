/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

/**
 *
 * @author cgallardo
 */
public class ProductoDAO extends ConexionDAO {
    public List<Producto> getProductos() throws Exception{
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Producto p = null;
        List<Producto> lista=new ArrayList<Producto>();
        
        try {
            conn = this.getDs().getConnection();
            String vsql="SELECT * FROM productos ORDER BY nombre";
            ps = conn.prepareStatement(vsql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getBigDecimal("precio"));
                p.setTalle(rs.getString("talle"));
                p.setColor(rs.getString("color"));
                
                lista.add(p);
            }
            rs.close();
            rs=null;
            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        } finally {
            cierra_todo(rs, conn, ps);
        }
        return lista;
     }
    
    public Producto getProductoById(int idProducto) throws Exception{
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Producto p = null;
        
        try {
            conn = this.getDs().getConnection();
            String vsql="SELECT * FROM productos where id=? ";
            ps = conn.prepareStatement(vsql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getBigDecimal("precio"));
                p.setTalle(rs.getString("talle"));
                p.setColor(rs.getString("color"));
            }
            rs.close();
            rs=null;
            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        } finally {
            cierra_todo(rs, conn, ps);
        }
        return p;
     }
}
