package proyecto.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.logics.RegistroLogic;


@WebServlet(urlPatterns = {"/RegistroServlet1"})
public class RegistroServlet1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String strConnString = "jdbc:mysql://localhost/letsstudyxd?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false"
                +"autoReconnect=true&useSSL=false&serverTimezone=UTC";
        String strFormId = request.getParameter("formid");
        RegistroLogic Logic = new RegistroLogic(strConnString);
        int rows;
        switch (strFormId) 
        {
            case "1":
                //codigo para insert en la base de datos
                String nombre = request.getParameter("name");
                String carrera = request.getParameter("Carrera"); 
                String agno = request.getParameter("agno");
                String carnet = request.getParameter("carnet");
                String correo = request.getParameter("correo");
                String contrasegna = request.getParameter("contrasegna");
                int carreraConverter = Integer.parseInt(carrera);
                
                
                //INGRESAR A LA BD
                rows = Logic.registerNewStudent(nombre, correo, contrasegna, carnet, agno, carreraConverter);
                
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
