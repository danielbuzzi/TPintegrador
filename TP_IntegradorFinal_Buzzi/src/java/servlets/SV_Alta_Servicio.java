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
@WebServlet(name = "SV_Alta_Servicio", urlPatterns = {"/SV_Alta_Servicio"})
public class SV_Alta_Servicio extends HttpServlet {

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
        String descripcion = request.getParameter("descripcion_breve");
        String destino = request.getParameter("destino");

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaservicio=new Date();
    
        try {
           fechaservicio = formato.parse(request.getParameter("fechaservicio"));
  
        } catch (ParseException ex) {
            Logger.getLogger(Sv_Alta_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
       // Date fechanac=null;
    
  
        double costo = Double.parseDouble(request.getParameter("costoservicio"));

        //Traemos la sesion y asignamos loa atrbutos para abrilos en cualquier jsp
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("descripcion", descripcion);
        request.getSession().setAttribute("destino", destino);
        request.getSession().setAttribute("costo", costo);
        request.getSession().setAttribute("fechaservicio", fechaservicio);
        //Conexion con la logica
        ControladoraLogica controlserv = new ControladoraLogica();
    
        controlserv.crearServicio(nombre, descripcion, destino, costo, fechaservicio);
      
        //Armamos la respuesta
    
        response.sendRedirect("altaservicioturistico.jsp");
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
