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
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Empleado;
import logica.Usuario;

/**
 *
 * @author daniel
 */
@WebServlet(name = "SV_Modificar_Empleado", urlPatterns = {"/SV_Modificar_Empleado"})
public class SV_Modificar_Empleado extends HttpServlet {

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
        //traigo el id
        long id = Long.parseLong(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String usuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("contrasenia");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechanac = null;
        try {
            fechanac = formato.parse(request.getParameter("fechanac"));
        } catch (ParseException ex) {
            Logger.getLogger(SV_Modificar_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        ControladoraLogica controlEmp = new ControladoraLogica();

        Empleado emp = controlEmp.buscarEmpleado(id);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDireccion(direccion);
        emp.setDni(dni);
        emp.setNacionalidad(nacionalidad);
        emp.setFecha_nac(fechanac);
        emp.setCelular(celular);
        emp.setNombre(nombre);
        emp.setEmail(email);
        emp.setCargo(cargo);
        emp.setSueldo(sueldo);
        emp.getUnUsuario().getCodigo_usuario();
        ControladoraLogica controlUsu = new ControladoraLogica();
        Usuario usu = controlUsu.buscarUsuario(emp.getUnUsuario().getCodigo_usuario());
        usu.setNombre_usuario(usuario);
        usu.setContraseña(password);

        controlEmp.modificarEmpleado(emp, usu);

        HttpSession misession = request.getSession();
        misession.setAttribute("empleado", emp);
        request.getSession().setAttribute("listaEmpleados", controlEmp.traerEmpleados());
        //misession.setAttribute("usuario", usu);
        //request.getSession().setAttribute("listaUsuario", controlUsu.traerUsuarios());
        response.sendRedirect("consultaempleado.jsp");

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
        
        long id = Long.parseLong(request.getParameter("id"));
        ControladoraLogica controlEmp = new ControladoraLogica();

        Empleado emp = controlEmp.buscarEmpleado(id);
        HttpSession misession = request.getSession();
        misession.setAttribute("empleado", emp);
        request.getSession().setAttribute("listaEmpleado", controlEmp.traerEmpleados());
    
        response.sendRedirect("modificacionempleado.jsp");
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
