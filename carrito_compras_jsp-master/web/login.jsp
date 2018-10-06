<%@page import="model.Usuario" session="true"%>
<%@page import="RN.UsuarioRN"%>

<%
    if (request.getParameter("ingresar")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
        // Obtener usuario
        Usuario usuario = UsuarioRN.obtenerUsuario(request.getParameter("email"),request.getParameter("password"));
	
	if(usuario!=null) {
            session.setAttribute("usuario", usuario); 
            //unset($_SESSION['msjlog']);
			
	} else { %>
            <jsp:forward page="index.jsp">
        	<jsp:param name="msjlog" value="Usuario o Password No registrado"/>
            </jsp:forward>
	<%}
    }
    
%>
<jsp:forward page="index.jsp" />
