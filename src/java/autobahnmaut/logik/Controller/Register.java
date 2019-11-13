/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik.Controller;

import autobahnmaut.datenbank.UserManager;
import autobahnmaut.logik.Helper;
import autobahnmaut.model.Nutzer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//        Übergebene Parameter erfassen
        String anmeldeemail = request.getParameter("email");
        String anmeldepasswort = request.getParameter("password");
        String passwordwdh = request.getParameter("passwdh");
        String rolle = "Nutzer";
        String name = request.getParameter("firma");
        String strasse = request.getParameter("strasse");
        String plz = request.getParameter("plz");
        String ort = request.getParameter("ort");
        Double rabatt = 1.0;
        List<String> errors = new ArrayList<String>();
        
//        Validation
        if (anmeldeemail.isEmpty()|| !Helper.isValidEmail(anmeldeemail)){
            errors.add("Email");
        }
        if (anmeldepasswort.isEmpty() || !anmeldepasswort.matches(passwordwdh)) {
            errors.add("Password");
        }
        if (passwordwdh.isEmpty()) {
            errors.add("Password Wiederholen");
        }
        if (name.isEmpty()) {
            errors.add("Firma");
        }
        if (strasse.isEmpty()) {
            errors.add("Strasse");
        }
        if (plz.isEmpty()) {
            errors.add("PLZ");
        }
        if (ort.isEmpty()) {
            errors.add("Ort");
        }

        if(!errors.isEmpty()){
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        }else{
            Nutzer n = UserManager.registrieren(
                    anmeldeemail, 
                    anmeldepasswort, 
                    rolle,
                    name, 
                    strasse, 
                    plz, 
                    ort, 
                    rabatt);
    //      Nutzer in session speichern;
            HttpSession session = request.getSession();
            session.setAttribute("Nutzer", n);
        }

    }

}
