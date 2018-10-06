<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>  

<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="model.Carrito"%>
<%@page import="RN.ProductoRN"%>
<%@page contentType="text/html" language="java" %>  
<%@page import="model.Usuario" session="true"%>

<%
  Usuario usuario= (Usuario) session.getAttribute("usuario");   
  if (usuario==null) { %>
  
    <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe loguearse para Ver o Agregar un Producto al Carrito..."/>
    </jsp:forward>
    
    <%} 
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) {  
        carrito=new Carrito();
        session.setAttribute("carrito", carrito);
    } else {
        carrito= (Carrito) session.getAttribute("carrito");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Formulario de Compra</title>
    </head>
    <body>
        <jsp:include page="encabezado.html" />

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Productos</a></li>
                        <li><a href="mostrar_carrito.jsp">Carrito</a></li>
                        <li><a href="#">Ofertas</a></li>
                        <li><a href="#">Tiendas</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>
                    
                    <% if(usuario==null) { %>
                        <form action="login.jsp" method="post" class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" name="email" placeholder="Email Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="Contraseña">
                            </div>
                            <button type="submit" name="ingresar" class="btn btn-default">Ingresar</button>
                        </form>

                        <% } else { %>
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= usuario.getNombre()%></a></li> 
                            <li><a href="salir.jsp"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesión</a></li>
                            <li><a href="mostrar_carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                        </ul>
                    <% } %> 
                    
                </div>
            </div>
        </nav>
        
        <div class="container"> 
            <h1>Formulario</h1>
            
            
            <div class="table-responsive"> 
                
              <table class="table table-hover table-striped ">
                <caption><h4>Usuario</h4></caption>
                <tr>    
                    <th><p>Nombre</p></th> 
                    <th><span class="glyphicon glyphicon-user"></span> <%= usuario.getNombre()%></th> 
                </tr>
            <!--    <tr>
                    <th><p>Dni</p></th> <th></th> 
                </tr>  -->
              </table>
                
              <table class="table table-hover table-striped ">
            <!--    <tr>              
                    <th><h4>Productos</h4></th> 
                </tr> -->
                <caption><h4>Productos</h4></caption>
            <!--    <div class="table-responsive"> 
            <table class="table table-hover table-striped ">
                <caption>Productos agregados al Carrito</caption>  -->
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Producto</th>
                        <th>Talle</th>
                        <th>Color</th>
                        <th>Precio</th>
                    <!--    <th>Acción</th  --->
                    </tr>
                </thead>
            <!--    <tfoot>
                    <tr>
                        <th colspan="6">Total productos del Carrito: <%= carrito.contarProductos()%></th>
                    </tr>
                    <tr>
                        <th colspan="6">Monto Total del Carrito: <%= carrito.sumarMontoProductos()%> </th>
                    </tr>
                    <tr>
                        <th colspan="6"><a href="comprar.jsp" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> Finalizar Compra</a></th>
                    </tr>
                  </tfoot>  -->
                <tbody>
         
               <% 
                for (Producto producto: carrito.getProductos()) { %>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getTalle() %></td>
                    <td><%= producto.getColor() %></td>
                    <td><%= producto.getPrecio() %></td>
                    
                <!--    <td><a href="mostrar_carrito.jsp?op=2&id=<%= producto.getId()%>" onClick="return confirm('¿Está seguro que desea eliminar el Producto del Carrito?');" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Eliminar</a></td> -->
                </tr>
                <% } %>
                </tbody>
              </table> 
                
              <form action="procesarCompra.jsp" name="formulario" id="formulario" method="post">
              <table class="table table-hover table-striped ">  
                <caption><h4>Medio de Pago</h4></caption>
                
                 <tr>    
                    <th><label for="nombreTitular">Nombre del Titular</label></th>
                    <th><input type="text" name="nombreTitular" id="nombreTitular" placeholder="Introduzca Nombre" maxlenght="30" required></th>
                </tr> 
                
                <tr>
                    <th><label for="nroTarjeta">Numero de Tarjeta</label></th>
                    <th><input type="text" name="nroTarjeta" id="nroTarjeta" placeholder="Introduzca Numero" maxlenght="16" required></th>
                </tr>
                                 
                <tr>    
                    <th><label for="mesVenc">Mes de Vencimiento</label></th>
                    <th><input type="text" name="mesVenc" id="mesVenc" placeholder="mm" maxlenght="2" required></th>
                </tr>
                
                <tr>    
                    <th><label for="anioVenc">Año de Vencimiento</label></th>
                    <th><input type="text" name="anioVenc" id="anioVenc" placeholder="aaaa" maxlenght="4" required></th>
                </tr>
                    
                <tr>    
                    <th><label for="codSeg">Codigo de Seguridad</label></th>
                    <th><input type="text" name="codSeg" id="codSeg" placeholder="Introduzca Codigo" maxlenght="4" required></th>
                </tr>  
              </table>    
                
                <input type="submit" id="boton" name="boton" value="Aceptar">
         
            </form>
        
            </div>          
            <br><br>
        </div>

        <jsp:include page="footer.html" />
    </body>
</html>