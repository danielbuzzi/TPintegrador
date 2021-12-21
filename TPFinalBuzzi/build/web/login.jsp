

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Agencia Viaje S.A.</title>
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
      
    </head>
    <body>
        <% HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {

                response.sendRedirect("index.jsp");

            } else {
        %>
        <div class="container">
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
                        <h7 class="bg-warning">Debe ingresar datos para iniciar sesi�n</h7>
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
                                    Servicios tur�sticos
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="altaservicioturistico.jsp">Alta de Servicios Tur�sticos</a>
                                    <form action="Sv_Consulta_Servicio" method="get">   
                                        <a class="submit dropdown-item bg-light" href="Sv_Consulta_Servicio">Ver servicios tur�sticos</a> 

                                    </form>


                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                    Paquetes tur�sticos
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="altapaquete.jsp">Alta de Paquetes Tur�sticos</a>
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
            <div height="80%" padding="30px 20px 20px 10px">
                <div class="shadow-lg">
                    <p></p>
                    <p></p>
                    <div class="card-header text-align-center">
                        <h7>P�gina de Inicio</h7>

                    </div>
                    <div class="card-body">

                         <img class="align-center" src="img/agencia.jfif" alt="Bienvenido a la aplicaci�n de Agencia Viaje S.A.">
                    </div>
                </div>


                <footer class="fixed-bottom">

                    <h6 class="bg-light" align="center">Agencia Viaje S.A. -Derechos Reservados � 2021  - by Daniel Buzzi</h6> 

                </footer>
            </div>
            <%}%>
    </body>
</html>