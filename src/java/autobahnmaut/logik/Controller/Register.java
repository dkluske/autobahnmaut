/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik.Controller;

import autobahnmaut.datenbank.Datenbank;
import autobahnmaut.datenbank.UserManager;
import autobahnmaut.model.Nutzer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andi
 */
@WebServlet(
        name = "Register", 
        urlPatterns = {"/Register", "/register"}
)
public class Register extends HttpServlet {

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
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/jsp/register.jsp");
        rd.forward(request, response);

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
        
        
        String firma = request.getParameter("firma");
        String anschr = request.getParameter("anschr");
        String UST = request.getParameter("UST");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordwdh = request.getParameter("passwordwdh");
        
        System.out.println("" + firma+ anschr + UST);
        
        UserManager UM = new UserManager();
//        Nutzer n = UM.register();
    }

}
