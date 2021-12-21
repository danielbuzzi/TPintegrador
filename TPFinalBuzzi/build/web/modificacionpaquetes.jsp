<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.PaqueteTuristico"%>
<%@page import="logica.ControladoraLogica"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Agencia Viaje S.A.</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script src="js/utilidadesAltaPaquete.js"></script>


    </head>
    <body onload="asignarTotal();">

        <% HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {

                response.sendRedirect("index.jsp");

            } else {
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <header>
                        <div id="cabecera">
                            <div align="right">  

                                <%
                                    usu = (String) misession.getAttribute("usuario");
                                    if (usu != null) {%>
                                <h7>Bienvenido:</h7>

                                <h7 class="bg-success"><%=request.getSession().getAttribute("nombreEmpleado")%></h7>



                                <form  action="Sv_Logout" method="post"> 
                                    <button class="btn btn-md btn-success" type="submit">Logout</button>
                                </form>

                                <%} else { %>
                                <h7 class="bg-warning">Debe ingresar datos para iniciar sesión</h7>
                                    <%}%>
                            </div>
                    </header>       

                    <nav class="navbar navbar-expand-sm navbar-light bg-light navbar-responsive"  id="mainNav">
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                                data-target="#navbarResponsive">
                            Menu <i class="fa fa-bars"></i>
                        </button>
                        <div id="navbarResponsive" class="navbar-collapse collapse">
                            <if class="navbar-nav ml-auto text-uppercase">


                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Empleados
                                        </a>
                                        <div class="dropdown-menu">


                                            <a class="dropdown-item bg-light" href="altaempleado.jsp">Alta de empleados</a>
                                            <form action="Sv_Consulta_Empleado" method="get"> 
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Empleado">Ver empleados</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>

                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Clientes
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altacliente.jsp">Alta de clientes</a>
                                            <form action="Sv_Consulta_Cliente" method="get">   

                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Cliente">Ver clientes</a> 

                                            </form>



                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Servicios turísticos
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altaservicioturistico.jsp">Alta de Servicios Turísticos</a>
                                            <form action="Sv_Consulta_Servicio" method="get">   
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Servicio">Ver servicios turísticos</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Paquetes turísticos
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altapaquete.jsp">Alta de Paquetes Turísticos</a>
                                            <form action="Sv_Consulta_Paquete" method="get">  
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Paquete">Ver paquetes</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Ventas
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altaventas.jsp">Alta de Ventas</a>
                                            <form action="Sv_Consulta_Ventas" method="get">   
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Ventas">Ver ventas</a> 

                                            </form>

                                        </div>
                                    </div>
                                </li>


                        </div>

                    </nav>  
                    <p></p>
                    <div class="card shadow-lg">
                        <div class="card-header">
                            <h7>Modificación de Paquetes turísticos</h7>

                        </div>
                        <div class="card-body">
                            <div class="row">

                                <div class="col-md-12">
                                    <form action="SV_Modificar_Paquete" onsubmit=" return grillaVacia()" method="get">
                                        <p>Servicios disponibles</p>
                                        <div class="table-wrapper-scroll-y my-custom-scrollbar">  

                                            <table id="tablaserviciod" class="table table-striped">
                                                <thead>
                                                <th>Cod.</th>
                                                <th>Nombre</th>
                                                <th>Destino</th>
                                                <th>Fecha</th>
                                                <th>Costo</th>
                                                <th>Descripción</th>

                                                <th></th>
                                                </thead>
                                                <tbody id="tbd1">

                                                    <% ControladoraLogica controlServ = new ControladoraLogica();
                                                        List<ServicioTuristico> listaServicios = controlServ.traerServicios();
                                                        PaqueteTuristico paque = (PaqueteTuristico) request.getSession().getAttribute("paquete");
                                                        int fila = -1;
                                                        for (ServicioTuristico serv : listaServicios) {
                                                        if (serv.isHabilitado()) {
                                                            String fechaServDisp = formato.format(serv.getFecha_servicio());
                                                    %>


                                                    <tr  class="row-100 body">
                                                        <td id="cod" type="hidden"><%=serv.getCodigo_servicio()%></td>
                                                        <td class="cell-100 columm1"><%= serv.getNombre()%></td>
                                                        <td  class="cell-100 columm2"><%= serv.getDestino_servicio()%></td>
                                                        <td  class="cell-100 columm3"><%= fechaServDisp%></td>
                                                        <td  class="cell-100 columm4"><%= (double) serv.getCosto_servicio()%></td>

                                                        <td  class="cell-100 columm5"><%=serv.getDescripcion_breve()%></td>

                                                        <%long id = serv.getCodigo_servicio();
                                                            fila++;%>


                                                        <td  class="cell-50 columm5">
                                                            <input type="button" name="agregarservicio" value="Agregar" class="btn-success" onclick="agregarServicio(<%=id%>,<%=fila%>, this);">


                                                        </td>

                                                    </tr>
                                                    <% }}%>
                                                </tbody>
                                            </table>
                                        </div>    
                                        <p></p>
                                        <p>Servicios seleccionados</p>
                                        <div class="table-wrapper-scroll-y my-custom-scrollbar">

                                            <table id="tablaservicioagregado" class="table table-striped">
                                                <thead>
                                                <th>Cod.</th>
                                                <th>Nombre</th>
                                                <th>Destino</th>
                                                <th>Fecha</th>
                                                <th>Costo</th>
                                                <th>Descripción</th>
                                                </thead>
                                                <tbody id="tbd2">
                                                    <%
                                                        List<ServicioTuristico> listaServiciosPaquete = paque.getListaServicio();

                                                        for (ServicioTuristico ser : listaServiciosPaquete) {
                                                             
                                                            String fechaServ = formato.format(ser.getFecha_servicio());
                                                    if (ser.isHabilitado()){%>

                                                    <tr>
                                                        <td><input type="text" class="input-no-borde" name="ids" maxlength="8"  value="<%=ser.getCodigo_servicio()%>" readonly></td>
                                                        <td><input type="text" class="input-no-borde" name="nombre" maxlength="25" sise="20" value="<%=ser.getNombre()%>" readonly></td>   
                                                        <td><input type="text" class="input-no-borde" name="destino" maxlength="25" sise="20" value="<%=ser.getDestino_servicio()%>" readonly></td>   
                                                        <td><input type="text" class="input-no-borde" name="fecha" maxlength="11" sise="11" value="<%= fechaServ%>" readonly></td>
                                                        <td><input type="text" class="input-no-borde" name="costo" maxlength="10" sise="10" value="<%= ser.getCosto_servicio()%>" readonly><%= ser.getCosto_servicio()%></td>

                                                        <td><input type="text" class="input-no-borde" name="descripcionBreve" maxlength="8" sise="8" value="<%=ser.getDescripcion_breve()%>" readonly></td>


                                                        <td><input type="button" name="quitarelemento" class="btn-warning" value="Quitar" onclick="quitarElemento(this);" ></td>

                                                    </tr>
                                                    <%}}%>
                                                </tbody>

                                            </table>
                                        </div>
                                        <p></p>
                                        Total $:<input type="text" name="total"  id="costopaquete" readonly>
                                        <input type="hidden" name="id" value="<%=paque.getCodigo_paquete()%>">
                                        <input class="btn btn-lg btn-success" type="submit"  value="Agregar"> 

                                    </form>
                                </div>



                            </div>

                        </div>
                    </div>       

                    <footer class="fixed-bottom">
                        <h6 class="bg-light" align="center">Agencia Viaje S.A. -Derechos Reservados ® 2021  - by Daniel Buzzi</h6> 

                    </footer>
                    <script src="js/jquery.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/scripts.js"></script>
                    <%}%>
                    </body>
                    </html>