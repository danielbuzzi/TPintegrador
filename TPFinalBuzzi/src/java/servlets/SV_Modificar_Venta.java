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
import logica.Venta;

/**
 *
 * @author daniel
 */
@WebServlet(name = "SV_Modificar_Venta", urlPatterns = {"/SV_Modificar_Venta"})
public class SV_Modificar_Venta extends HttpServlet {

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
        Long id = Long.parseLong(request.getParameter("id"));
        Long empleado = Long.parseLong(request.getParameter("empleadoid"));
        Long cliente = Long.parseLong(request.getParameter("cliente"));

        String servicio = request.getParameter("servicios");

        String mediopago = request.getParameter("mediopagos");

        String paquete = request.getParameter("paquetes");
        String fechaven = (String) request.getParameter("fechaventa");

        Date fechaventa = new Date();
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fechaventa = formato.parse(fechaven);
        } catch (ParseException ex) {
            Logger.getLogger(SV_Modificar_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ControladoraLogica controlven = new ControladoraLogica();

        controlven.modificarVenta(id, servicio, mediopago, paquete, fechaventa, cliente, empleado);
        request.getSession().setAttribute("listaVentas", controlven.traerVentas());
        response.sendRedirect("consultaventas.jsp");

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
        ControladoraLogica controlVen = new ControladoraLogica();
        ControladoraLogica controlCli = new ControladoraLogica();
        ControladoraLogica controlSErv = new ControladoraLogica();
        ControladoraLogica controlPaq = new ControladoraLogica();
        Venta ven = controlVen.buscarVenta(id);
   
        HttpSession misession = request.getSession();
        misession.setAttribute("venta", ven);
        request.getSession().setAttribute("listaCliente", controlCli.traerClientes());
        request.getSession().setAttribute("listaServicio", controlSErv.traerServicios());
        request.getSession().setAttribute("listaPaquete", controlPaq.traerPaquetes());
 
        response.sendRedirect("modificacionventas.jsp");

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
