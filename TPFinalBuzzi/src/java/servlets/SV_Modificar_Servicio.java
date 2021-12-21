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
import logica.ServicioTuristico;

/**
 *
 * @author daniel
 */
@WebServlet(name = "SV_Modificar_Servicio", urlPatterns = {"/SV_Modificar_Servicio"})
public class SV_Modificar_Servicio extends HttpServlet {

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
        String nombreservicio = request.getParameter("nombreservicio");
        String descripcionbreve = request.getParameter("descripcion_breve");
        String destino = request.getParameter("destino");
        Double costo = Double.parseDouble(request.getParameter("costoservicio"));
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaserv = new Date();
        try {
            fechaserv = formato.parse(request.getParameter("fechaservicio"));
        } catch (ParseException ex) {
            Logger.getLogger(SV_Modificar_Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        ControladoraLogica controlServ = new ControladoraLogica();

        ServicioTuristico serv = controlServ.buscarServicio(id);
 
        serv.setNombre(nombreservicio);
        serv.setDescripcion_breve(descripcionbreve);
        serv.setDestino_servicio(destino);
        serv.setCosto_servicio(costo);
        serv.setFecha_servicio(fechaserv); 
    
        controlServ.modificarServicio(serv);
        request.getSession().setAttribute("listaServicio", controlServ.traerServicios());
        response.sendRedirect("consultaservicioturistico.jsp");

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
        ControladoraLogica controlServ = new ControladoraLogica();
        ServicioTuristico serv = controlServ.buscarServicio(id);
        HttpSession misession = request.getSession();
        misession.setAttribute("servicio", serv);
        request.getSession().setAttribute("listaServicio", controlServ.traerServicios());
        response.sendRedirect("modificacionservicioturistico.jsp");
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
