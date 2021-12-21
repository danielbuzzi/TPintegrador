<%@page import="logica.ControladoraLogica"%>
<%@page import="logica.Empleado"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.PaqueteTuristico"%>

<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.Cliente"%>
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
        <script src="js/utilidadesAltaVentas2.js"></script>


    </head>
    <body>
        <% HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {

                response.sendRedirect("index.jsp");

            } else {
        %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <header>
                        <div id="cabecera">
                            <div align="right">  

                                <% usu = (String) misession.getAttribute("usuario");
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
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-6">
                            <div class="card shadow-lg">
                                <div class="card-header">
                                    <h7>Alta de ventas</h7>

                                </div>
                                <div class="card-body">


                                    <form action="Sv_Alta_Venta" method="POST" name="fomrularioventa" onsubmit=" return existenCamposVacios()">

                                        <%Date fechaActual = new Date(Calendar.getInstance().getTimeInMillis());

                                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                                            String fechaventa = formato.format(fechaActual);

                                            Long idEmple = (Long) (request.getSession().getAttribute("idEmpleado"));
                                            //ControladoraLogicaEmpleado controlEmp = new ControladoraLogicaEmpleado();

                                            //Empleado emp=controlEmp.buscarEmpleado(idEmple);
                                            String nombreEmp = (String) request.getSession().getAttribute("nombreEmpleado");

                                        %>


                                        <label for="fechaventa">Fecha venta</label><input type="text" value="<%=fechaventa%>" name="fechaventa" class="form-control" disabled required></input>

                                        <label for="mediopagos">Medio de pago</label><select name="mediopagos" id="mediopago" class="form-control" required>
                                            <option value="0">----</option>
                                            <option value="Efectivo">Efectivo</option>
                                            <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                                            <option value="Tarjeda de Débito">Tarjeta de Débito</option>
                                            <option value="Monedero virtual" >Monedero virtual</option>
                                            <option value="Transferencia">Transferencia</option>



                                        </select>

                                        <label for="Empleado"> Empleado</label><input type="text" name="empleado" value="<%= nombreEmp%>"  class="form-control" disabled required></input>
                                        <input type="hidden" name="empleadoid" value="<%= idEmple%>">
                                        <label for="cliente"> Cliente</label><select id="cliente" name="cliente" class="form-control" required>
                                            <option value="0">----</option>
                                            <% ControladoraLogica controlCli = new ControladoraLogica();
                                                List<Cliente> listaClientes = controlCli.traerClientes();
                                                for (Cliente cli : listaClientes) {
                                                    if (cli.isHabilitado()) {%>
                                            <%long idcliente = cli.getCodigo_cliente();%>
                                            <option  value="<%=idcliente%>"><%=cli.getApellido() + " - " + cli.getNombre()%></option>

                                            <%}}%>
                                        </select>
                                        <p></p>
                                        <p><input type="radio"  name="compra" value="servicio" checked onclick="seleccionProducto()">Elegir servicio turístico</input>
                                        <p></p>
                                        <label for="servicios"></label><select id="servicio" name="servicios" class="form-control" required>
                                            <option value="0">----</option>
                                            <% ControladoraLogica controlserv = new ControladoraLogica();
                                                List<ServicioTuristico> listaServicios = controlserv.traerServicios();

                                                for (ServicioTuristico ser : listaServicios){
                                                        if (ser.isHabilitado()) { %>
                                            <%long idservicio = ser.getCodigo_servicio();%>
                                            <option  value="<%=idservicio%>"> <%= ser.getNombre() + " - " + ser.getDestino_servicio() + " ," + ser.getCosto_servicio()%></option>
                                      



                                            <%}
                                                    }%>

                                        </select>


                                        <p></p>
                                        <p><input type="radio" name="compra" value="paquete" onclick="seleccionProducto()">Elegir paquete turístico</input></p>
                                        <label for="paquetes"></label><select id="paquete" name="paquetes" class="form-control" disabled required>
                                            <option value="0">----</option>
                                            <% ControladoraLogica controlpaq = new ControladoraLogica();
                                                List<PaqueteTuristico> listaPaquetes = controlpaq.traerPaquetes();
                                                for (PaqueteTuristico paq : listaPaquetes) {
                                                    if (paq.isHabilitado()) {  %>
                                            <%long idpaquete = paq.getCodigo_paquete();%>
                                            <option value="<%=idpaquete%>"><%=  paq.getCodigo_paquete() + " - " + paq.getCosto_paquete()%></option>

                                            <%}
                                                }%>
                                        </select>




                                        <p></p>

                                        <input class="btn btn-lg btn-success" type="submit" class="form-control" value="Venta"> 



                                    </form>
                                </div>
                                <div class="col-md-3">
                                </div>
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

