/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.servlet;

import balcorpfw.logic.Logic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.logics.FormularioDocLogic;


/**
 *
 * @author diana
 */
@WebServlet(name = "FormularioDocServlet", urlPatterns = {"/FormularioDocServlet"})
public class FormularioDocServlet extends HttpServlet {

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
      String strConnString = "jdbc:mysql://localhost/letsstudyxd?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false"
                +"autoReconnect=true&useSSL=false&serverTimezone=UTC";
        String strFormId = request.getParameter("formid");
        int rows;
        switch (strFormId) 
        {
            case "1":
                //codigo para insert en la base de datos
                FormularioDocLogic logic = new FormularioDocLogic(strConnString);
                String tipo = request.getParameter("tipo");
                String asignatura_id = request.getParameter("asignatura_id"); 
                int asignaturaP = Integer.parseInt(asignatura_id);
                String usuario_id = request.getParameter("usuario_id");
                int usuarioP = Integer.parseInt(usuario_id);
                String agno = request.getParameter("agno");
                int agnoP = Integer.parseInt(agno);
                
                
                
                //INGRESAR A LA BD
                rows = logic.insertFormulario(tipo, agnoP, asignaturaP, usuarioP);
                
                //REDIRECCIONAR
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("Inicio.jsp");
                
            break;
            default:
            break;
	}
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
        processRequest(request, response);
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
