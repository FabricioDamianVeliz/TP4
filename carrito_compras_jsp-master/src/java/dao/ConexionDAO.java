package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConexionDAO {

    
    
	private DataSource jeeDs;
	protected DataSource getDs() throws Exception{

		if (jeeDs == null) {
			Context ctx = new InitialContext();
			jeeDs = (DataSource) ctx.lookup("java:comp/env/jdbc/carrito_compras");
		}
		return jeeDs;
	}

        public void cierra_todo(ResultSet rs,Connection conn,PreparedStatement ps) throws Exception{
              if(rs != null) {
                rs.close();
                }

              if(conn != null) {
                conn.close();
                
              }

              if(ps != null) {
                ps.close();
                
              }
        }
        
        public void cierra_todo(Connection conn,PreparedStatement ps) throws Exception{
              

              if(conn != null) {
                conn.close();
                
              }

              if(ps != null) {
                ps.close();
                
              }
        }
        
}
