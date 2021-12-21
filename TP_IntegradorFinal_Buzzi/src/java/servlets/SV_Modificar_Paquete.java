/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import logica.PaqueteTuristico;
import logica.Venta;

/**
 *
 * @author daniel
 */
@WebServlet(name = "SV_Modificar_Paquete", urlPatterns = {"/SV_Modificar_Paquete"})
public class SV_Modificar_Paquete extends HttpServlet {

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
        Long id=Long.parseLong(request.getParameter("id"));
        Double total = Double.parseDouble(request.getParameter("total"));
        String[] costo = request.getParameterValues("costo");
        String[] idsa = request.getParameterValues("ids");
        String[] nombre = request.getParameterValues("nombre");
        String[] destino = request.getParameterValues("destino");
        String[] fecha = request.getParameterValues("fecha");
        String[] descripcionbreve = request.getParameterValues("descripcionBreve");
  

  

        ControladoraLogica controlPaq= new ControladoraLogica();
        
       controlPaq.modificarPaquete(id, total, costo, idsa, nombre, destino, fecha, descripcionbreve);
       // controlven.modificarVenta(id, servicio, mediopago, paquete, fechaventa, cliente, empleado);
        request.getSession().setAttribute("listaPaquetes", controlPaq.traerPaquetes() );
        response.sendRedirect("consultapaquete.jsp");
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
        ControladoraLogica controlPaq = new ControladoraLogica();
        
        ControladoraLogica controlSErv = new ControladoraLogica();
       
        PaqueteTuristico paq = controlPaq.buscarPaquete(id);
   
        HttpSession misession = request.getSession();
        misession.setAttribute("paquete", paq);
        request.getSession().setAttribute("listaServicio", controlSErv.traerServicios());
        request.getSession().setAttribute("listaPaquete", controlPaq.traerPaquetes());
 
        response.sendRedirect("modificacionpaquetes.jsp");
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
