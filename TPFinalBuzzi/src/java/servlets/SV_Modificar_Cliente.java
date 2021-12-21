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
import logica.Cliente;
import logica.ControladoraLogica;


/**
 *
 * @author daniel
 */
@WebServlet(name = "SV_Modificar_Cliente", urlPatterns = {"/SV_Modificar_Cliente"})
public class SV_Modificar_Cliente extends HttpServlet {

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
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechanac = null;
        try {
            fechanac = formato.parse(request.getParameter("fechanac"));
        } catch (ParseException ex) {
            Logger.getLogger(SV_Modificar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        ControladoraLogica controlCli = new ControladoraLogica();

        Cliente cli = controlCli.buscarCliente(id);

        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDireccion(direccion);
        cli.setDni(dni);
        cli.setNacionalidad(nacionalidad);
        cli.setFecha_nac(fechanac);
        cli.setCelular(celular);
        cli.setNombre(nombre);
        cli.setEmail(email);

        controlCli.modificarCliente(cli);
        request.getSession().setAttribute("listaCliente", controlCli.traerClientes());
        response.sendRedirect("consultacliente.jsp");

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
        ControladoraLogica controlCli = new ControladoraLogica();
        Cliente cli = controlCli.buscarCliente(id);
        //HttpSession misession = request.getSession();
        request.getSession().setAttribute("cliente", cli);
        request.getSession().setAttribute("listaCliente", controlCli.traerClientes());
        response.sendRedirect("modificacioncliente.jsp");
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
