/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MedioPago;
import model.Producto;
import model.Usuario;
import model.Venta;

/**
 *
 * @author fabri
 */

public class VentaDAO extends ConexionDAO{

    public void guardarMedioPago(MedioPago m) throws Exception{
            
        
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        int idMedioPago;
        
        try {
            conn = this.getDs().getConnection();
            String key[]={"id_mediopago"};
            String vsql="insert into medio_pago(nrotarjeta,nombretitular,mesvenc,aniovenc,codseguridad,id_usuario)values('"+m.getNroTarjeta()+"','"+m.getNombreTitular()+"','"+m.getMesVenc()+"','"+m.getAnioVenc()+"','"+m.getCodSeguridad()+"','"+m.getIdUsuario()+"')";
            ps = conn.prepareStatement(vsql,key);
            
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                
                idMedioPago=rs.getInt(1);
                m.setIdMedioPago(idMedioPago);
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
     
     }
    
     public void guardarVenta(MedioPago m,Venta v) throws Exception{
        
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        int idVenta;
        
        try {

                conn = this.getDs().getConnection();
                String key[]={"id_venta"};
                String vsql="insert into venta(id_mediopago,fecha,hora,id_usuario,montototal)values('"+m.getIdMedioPago()+"','"+v.getFecha()+"','"+v.getHora()+"','"+v.getIdUsuario()+"','"+v.getMontoTotal()+"')";
                ps = conn.prepareStatement(vsql,key);

                ps.executeUpdate();

                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                
                    idVenta=rs.getInt(1);
                    v.setIdVenta(idVenta);
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
     }
     
     public void guardarProductoVenta(Venta v) throws Exception{
        
        Connection conn = null;
        PreparedStatement ps=null;

        
        try {

                conn = this.getDs().getConnection();
          
                for(Producto p:v.getProductos()){
                    String vsql="insert into producto_venta(id_producto,id_venta)values('"+p.getId()+"','"+v.getIdVenta()+"')";
                    ps = conn.prepareStatement(vsql);
                    ps.executeUpdate();
                }

          
            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        } finally {
            cierra_todo(conn, ps);
        }
     }
}
