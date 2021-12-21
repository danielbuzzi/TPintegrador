/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

/**
 *
 * @author daniel
 */
@WebServlet(name = "Sv_Alta_Empleado", urlPatterns = {"/Sv_Alta_Empleado"})
public class Sv_Alta_Empleado extends HttpServlet {
    //Conexion con la logica

    ControladoraLogica controlemp = new ControladoraLogica();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        //traemos los datos del JSP
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechanac = new Date();

        try {
            fechanac = formato.parse(request.getParameter("fechanac"));

        } catch (ParseException ex) {
            Logger.getLogger(Sv_Alta_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Date fechanac=null;
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");

        //Traemos la sesion y asignamos loa atrbutos para abrilos en cualquier jsp
        /*request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fechanac", fechanac);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("celular", celular);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("cargo", cargo);
        request.getSession().setAttribute("sueldo", sueldo);
        request.getSession().setAttribute("usuario", usuario);
        request.getSession().setAttribute("contrasenia", contrasenia);*/
        controlemp.crearEmppleado(nombre, apellido, direccion, dni, fechanac, nacionalidad, celular, email, cargo, sueldo, nombreUsuario, contrasenia);

        request.getSession().setAttribute("listaEmpleados", controlemp.traerEmpleados());
  
        response.sendRedirect("altaempleado.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
