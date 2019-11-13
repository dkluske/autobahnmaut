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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Andi
 */
@WebServlet(
        name = "Index und Loginpage", 
        urlPatterns = {
//          http://localhost:8084/Autobahnmaut
//          http://localhost:8084/Autobahnmaut/
            "/index", 
            "/login"
        }
)
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
//        Debugging stuff
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getRequestURI().substring(request.getContextPath().length());
        out.println(path);
        out.println("<hr> getRequestURI: " + request.getRequestURI());
        out.println("<hr> getContextPath: " + request.getContextPath());
        
        if (session.getAttribute("nutzer") == null) {
//            Wenn Client NICHT eingeloggt ist zeige index.jsp
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
//            Wenn Client eingeloggt leite zu /start
            response.sendRedirect(request.getContextPath() + "/start");
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> errors = new ArrayList<String>();
        
        String anmeldeemail = request.getParameter("email");
        String anmeldepasswort = request.getParameter("password");

//        Validierung Anmeldedaten
        if (anmeldeemail.isEmpty()|| !Helper.isValidEmail(anmeldeemail)){
            errors.add("Email");
        }
        if (anmeldepasswort.isEmpty()) {
            errors.add("Password");
        }
        
//        Logge benutzer ein
        Nutzer n = UserManager.login(anmeldeemail, anmeldepasswort);
        if (!(n  instanceof Nutzer)) {
            errors.add("Login Fehlgeschlagen");
        }
        
//        Wenn Fehler, übergebe fehler an index.jsp -> KEIN LOGIN
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            
//            Wenn kein fehler, leite zu /start weiter -> LOGIN
            session.setAttribute("nutzer", n);
            response.sendRedirect(request.getContextPath() + "/start");
        }
    }    

}
