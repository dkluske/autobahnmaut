/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik.Controller.pages;

import autobahnmaut.datenbank.FahrzeugManager;
import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Nutzer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "kfzAnzeigen", urlPatterns = {"/kfzAnzeigen"})
public class KfzAnzeigen extends HttpServlet {

    private HttpSession session;
    private String rolle;
    private Nutzer nutzer;

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
        this.session = (HttpSession) request.getSession();
        this.nutzer = (Nutzer) this.session.getAttribute("nutzer");
        if (this.nutzer != null) {
            this.rolle = (String) this.nutzer.getRolle();
        }else{
            this.rolle = null;
        }
//       --- DEBUGGING
//        PrintWriter out = response.getWriter();
//        out.println(session.toString());
//        out.println(session.getAttribute("nutzer").toString());       
//       ----------------

    }

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
        
        if (this.nutzer == null) {
//        Wenn Nutzer hat KEIENN login, zurück zu
            response.sendRedirect(request.getContextPath());
        }else{
            if (this.rolle.equals("Polizei") || this.rolle.equals("Admin") || this.rolle.equals("Nutzer")) {
                
                ArrayList <Fahrzeug> FL;
                System.out.println("nutzer ID:" + this.nutzer.getNutzerId());
                FL = (ArrayList<Fahrzeug>) FahrzeugManager.fahrzeuglisteNutzer(this.nutzer.getNutzerId());
                System.out.println("Fahrzeugliste : " + FL);
                request.setAttribute("fahrzeuge", FL);
                request.getRequestDispatcher("/jsp/kfzAnzeigen.jsp").forward(request, response);
            }else{
//                Permission denied!
                request.getRequestDispatcher("/jsp/permission.jsp").forward(request, response);
            }            
        }
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
        
//        Parameter erfassen
        String Test = request.getParameter("Test");
        
        if (this.nutzer == null) {
//        Wenn Nutzer hat KEIENN login, zurück zu
            response.sendRedirect(request.getContextPath());
        }else{
            if (this.rolle.equals("Polizei") || this.rolle.equals("Admin") || this.rolle.equals("Nutzer")) {

            }else{
//                Permission denied!
                request.getRequestDispatcher("/jsp/permission.jsp").forward(request, response);
            }
//            Wenn Nutzer hat login, zugang gewährt.
        }
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
