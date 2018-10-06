/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

public class UsuarioDAO extends ConexionDAO{

    public Usuario getUsuario(String email,String clave) throws Exception{
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Usuario usuario = null;
        
        try {
            conn = this.getDs().getConnection();
            String vsql="SELECT u.email,u.nombre,u.id FROM usuarios as u where email=? and password=?";
            ps = conn.prepareStatement(vsql);
            ps.setString(1, email);
            ps.setString(2, clave);

            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setId(rs.getInt("id"));
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
        return usuario;
     }
}
