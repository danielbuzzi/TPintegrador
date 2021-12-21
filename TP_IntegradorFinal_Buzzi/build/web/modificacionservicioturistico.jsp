<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <script src="js/utilidadesModificacionServicio.js"></script>




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
                                                <a class="submit dropdown-item bg-light"href="Sv_Consulta_Paquete">Ver paquetes</a> 

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
                                    <h7>Actualización datos de servicios turísticos</h7>

                                </div>
                                <div class="card-body">


                                    <form action="SV_Modificar_Servicio" method="Get">

                                                                                     <%
                                                                                         ServicioTuristico serv = (ServicioTuristico) misession.getAttribute("servicio");
                                                                                         String tipo = serv.getNombre();
                                                                                     %>

                                                                                     <label for="nombre"> Tipo de Servicio</label><select name="nombreservicio" class="form-control"required >
                                                                                         <!-- <option value="</option>-->
                                                                                         <option value="Alquiler de auto">Alquiler de Auto</option>
                                                                                         <option value="Entradas a eventos">Entradas a eventos</option>
                                                                                         <option value="Excursiones">Excursiones</option>
                                                                                         <option value="Hotel por noche/s" >Hotel por noche/s</option>
                                                                                         <option value="Pasajes de avión">Pasajes de avión</option>
                                                                                         <option value="Pasajes de colectivo">Pasajes de colectivo</option>
                                                                                         <option value="Pasajes de tren"  onload="seleccionTipo()" >Pasajes de tren</option>


                                                                                     </select>

                                                                                     <label for="nombre">Descripción del servicio</label><textarea class="form-control" id="descripcion_breve" maxlength="255" 
                                                                                                                                                   name="descripcion_breve" rows="3" cols="50" ><%=serv.getDescripcion_breve().toString()%>

                                                                                     </textarea>
                                                                                     <label for="destino">Destino</label><input type="text" name="destino" class="form-control" value="<%=serv.getDestino_servicio()%>" required>
                                                                                     <label for="costoservicio">Costo $</label><input type="number" name="costoservicio" value="<%=serv.getCosto_servicio()%>" min="0" max="99999999999999" step="0.05" maxlength="15" class="form-control" required>  

                                                                                     <%         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                                                                         // Date fechanac = emp.getFecha_nac();
                                                                                         String fechita = (String) formato.format(serv.getFecha_servicio());

                                                                                         // Date fecha2 = formato.parse(fechita);
                                                                                         //String fech=fecha2.toString();

                                                                                     %>
                                                                                     <label for="fechaservicio">Fecha</label><input type="date" name="fechaservicio" class="form-control" value="<%=fechita%>"required> 
                                                                                     <input type="hidden" name="id" value="<%=serv.getCodigo_servicio()%>" required>
                                                                                     <p></p>

                                                                                     <p></p>
                                                                                     <input class="btn btn-lg btn-success" type="submit" value="Actualizar"> 


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