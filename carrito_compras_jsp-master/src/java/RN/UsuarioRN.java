/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import dao.UsuarioDAO;
import model.Usuario;


public class UsuarioRN {
    public static Usuario obtenerUsuario(String email,String password) throws Exception {
        UsuarioDAO usuDao = new UsuarioDAO();
        /*String s= BlowFish.encriptar(password);
        System.out.println("clave encriptada: "+ s);*/
        return usuDao.getUsuario(email, password);
    }
}
