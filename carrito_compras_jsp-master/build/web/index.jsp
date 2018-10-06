<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="RN.ProductoRN"%>
<%@page contentType="text/html" language="java" %>  
<%@page import="model.Usuario" session="true"%>

<%
    Usuario usuario= (Usuario) session.getAttribute("usuario");
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
        <title>Pagina de Inicio - Carrito de Compras</title>
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
            
            <% if (request.getParameter("msjlog")!=null) { %>
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Atención!</strong> <% out.println(request.getParameter("msjlog")); %>
                </div>
            <% } %>


            <% if (request.getParameter("msjcarr")!=null) { %>
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>Atención!</strong> <% out.println(request.getParameter("msjcarr")); %>
                </div>

                	

            <% } %>
                <div class="row">
                
                <%    List<Producto> listaProductos = ProductoRN.listarProductos();

                for (Producto producto: listaProductos) { %>
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/320x150.png" alt="img-prod"> <!--320x15-->
                            <div class="caption">
                                <h4 class="pull-right">$<%= producto.getPrecio()%></h4>
                                <h4><%= producto.getNombre() %></h4>
                                <p>Descripción: <%= producto.getDescripcion() %></p>
                                <p>Talle: <%= producto.getTalle() %></p>
                                <p>Color: <%= producto.getColor() %></p>
                                <p><a href="mostrar_carrito.jsp?op=1&id=<%= producto.getId()%>"><span class="glyphicon glyphicon-shopping-cart"></span> Agregar a Carrito</a></p>
                            </div>
                        </div>
                    </div>

                <% } %>
            </div>
        </div>
        <jsp:include page="footer.html" />
    </body>
</html>