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
        <script src="js/utilidades.js"></script>


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

                                <%
                                    usu = (String) misession.getAttribute("usuario");
                                    if (usu != null) {%>
                                    <h7>Bienvenido:</h7>
                                        
                                        <h7 class="bg-success"><%=request.getSession().getAttribute("nombreEmpleado")%></h7>
                                  


                                <form  action="Sv_Logout" method="post"> 
                                    <button class="btn btn-md btn-success" type="submit">Logout</button>
                                </form>

                                <%} else{ %>
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
                                    <h7>Alta de Empleados</h7>

                                </div>   

                                <div class="card-body">


                                    <form action="Sv_Alta_Empleado" method="POST">

                                        <label for="nombre">Nombre</label><input type="text" name="nombre" maxlength="30" class="form-control" required>
                                        <label for="apellido">Apellido</label><input type="text" name="apellido" maxlength="30" class="form-control" required> 
                                        <label for="direccion">Direccion</label><input type="text" name="direccion" class="form-control" maxlength="30" required> 
                                        <label for="dni">DNI</label><input type="text" name="dni" class="form-control" pattern="[0-9]{8}" maxlength="8" required> 
                                        <label for="fechanac">Fecha de Nacimiento</label><input type="date" name="fechanac" class="form-control" required>  
                                        <label for="nacionalidad">Nacionalidad</label><input type="text" name="nacionalidad" maxlength="15" class="form-control" required> 
                                        <label for="celular">Teléfono Celular</label><input type="tel" name="celular" class="form-control" maxlength="18" required> 
                                        <label for="email">Dirección de Email</label><input type="email" name="email" maxlength="35" class="form-control" required> 
                                        <label for="cargo">Cargo</label><input type="text" name="cargo" maxlength="15" class="form-control" required>  
                                        <label for="sueldo">Sueldo</label><input type="number" name="sueldo" placeholder="0.00" min="0" max="99999999999999" step="0.05" maxlength="15" class="form-control" required> 
                                        <label for="nombreUsuario">Nombre de Usuario</label><input type="tel" name="nombreUsuario" class="form-control"  required> 
                                        <label for="contrasenia">Contraseña</label><input type="password" name="contrasenia" maxlength="25" class="form-control" required> 

                                        <p></p>
                                        <input class="btn btn-md btn-success " type="submit" class="form-control" value="Agregar"> 



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
