{% load static %}

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Yaguarete S.A.</title>
        <link rel="stylesheet" href="{% static 'estilos.css' %}">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script src="{% static '/js/scripts.js' %}"></script>
    </head>
    <body>
        <div class="container">
            <header>
                <div id="cabecera">
                    <img class="img-responsive" src="{% static '/media/yaguarete.jpg'%}" width="5%" heigth="5%">
                    <div align="right">  


                        <a class="btn btn-md btn-success" href="{% url 'login'%}?next={{request.path}}">Login</a>
                        <a class="btn btn-md btn-success" href="{%  url 'USUARIOS:registrarse'%}">Registro</a>


                        <h7>Bienvenido:</h7><h7 class="btn-danger">{{request.user}}</h7>



                        <!--<a class="btn btn-md btn-success" href="{% url 'logout'%}?next={{request.path}}">Logout</a>-->
                        <a class="btn btn-md btn-success" href="{% url 'logout'%}?next={{request.path}}">Logout</a>


                    </div>
            </header>       

            <nav class="navbar navbar-expand-sm navbar-light bg-light navbar-responsive" width="80%" id="mainNav">
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



                                    <a class="dropdown-item bg-light" href="index.jsp">Alta</a>
                                    <a class="dropdown-item bg-light" href="consultaempleado.jsp">Consulta de datos</a>  

                                </div>
                            </div>
                        </li>

                        <li class="nav-item">
                            <div class="dropdown">
                                <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                    Clientes
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="index.jsp">Alta</a>
                                    <a class="dropdown-item bg-light" href="consultaempleado.jsp">Consulta de datos</a>  


                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                    Servicios turísticos
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="index.jsp">Alta</a>
                                    <a class="dropdown-item bg-light" href="consultaempleado.jsp">Consulta de datos</a>  


                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                    Paquetes turísticos
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="index.jsp">Alta</a>
                                    <a class="dropdown-item bg-light" href="consultaempleado.jsp">Consulta de datos</a>  


                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                    Ventas
                                </a>
                                <div class="dropdown-menu">



                                    <a class="dropdown-item bg-light" href="index.jsp">Alta</a>
                                    <a class="dropdown-item bg-light" href="consultaempleado.jsp">Consulta de datos</a>  


                                </div>
                            </div>
                        </li>

                        </ul>
                </div>

            </nav> 
            <div="container" height="80%" padding="30px 20px 20px 10px">
                <div class="shadow-lg">
                    <p></p>
                    <p></p>
                    <div class="card-header text-align-center">
                        <h4>Alta de Empleados</h4>

                    </div>
                    <div class="card-body">


                        <form action="Sv_Alta_Empleado" method="POST" class="text-item-center">
                            <p>Nombre:<input type="text" name="nombre" required></p>
                            <p>Apellido:<input type="text" name="apellido" required></p>  
                            <p>Direccion:<input type="text" name="direccion" required></p>  
                            <p>DNI:<input type="text" name="dni" required></p>  

                            <p>Nacimiento:<input type="date" name="fechanac" required></p>  
                            <p>Nacionalidad:<input type="text" name="nacionalidad" required></p>  
                            <p>Celular:<input type="text" name="celular" required></p>  
                            <p>Email:<input type="text" name="email" required></p>  
                            <p>Cargo:<input type="text" name="cargo" required></p>  
                            <p>Sueldo:<input type="number" name="sueldo" required></p>  

                            <input class="btn btn-lg btn-success" type="submit" value="Agregar"> 



                        </form>
                    </div>
                </div>


                <footer class="fixed-bottom">

                    <h6 class="bg-light" align="center">Agencia Viaje S.A. -Derechos Reservados ® 2021  - by Daniel Buzzi</h6> 

                </footer>
            </div>
    </body>
</html>