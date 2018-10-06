# carrito_compras_jsp
Proyecto Java Web (JSP y Servlet) para completar dentro del Trabajo Practico N° 4

Se tiene un proyecto de aplicación web “Carrito de Compras”, donde se muestra en la página principal (index.jsp) una lista de productos junto con sus características (descripción, precio, color, etc.).

Un usuario puede loguearse en el sistema ingresando su email y contraseña en los campos que se encuentran en la parte derecha de la barra de navegación de la pagina principal. 
 
Una vez que el usuario se haya identificado en la webapp, puede agregar un producto al Carrito, haciendo un clic en el enlace ubicado en la parte inferior del panel de cada producto. En ese caso, se muestra una página con la lista de los productos agregados al carrito, con la opción de eliminar cada uno, tal como se muestra en la figura 2. Cabe destacar que los productos agregados al carrito sólo se guardan dentro de la sesión del usuario y no en la B.D. 

El proyecto fue desarrollado mediante el IDE Netbeans 8.2, JSP, Servlet y Servidor Web Apache Tomcat. Base de Datos PostgreSQL llamada "carrito_compras". Se adjunta el archivo "BDcarrito_compras.backup" para realizar la restauración de tablas y datos de la B.D. Modificar los datos de usuario y contraseña de B.D. en el archivo META-INF/context.xml
