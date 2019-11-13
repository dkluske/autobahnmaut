<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Datei für die Formatierung der Taskbar-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
    </head>
    <body>
        <!-- Default
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Function 1</a>
            <a href="">Function 2</a>
            <a href="">Function 3</a>
            <a href="">Logout</a>
        </div>-->
        <%
            //Nutzer-Element aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            //Taskbar nach den Rollen unterscheiden
            switch(n.getRolle()){
                //Rolle / Taskbar Normalnutzer
                case "Nutzer": %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="kfzRegister.jsp">Fahrzeuge</a>
                        <a href="KfzOrten.jsp">Fahrzeuge orten</a>
                        <a href="">Rechnung</a>
                        <a href="">Logout</a>
                    </div>
                <%
                //Rolle / Taskbar Ministerium
                case "Ministerium":%>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}\\jsp\\statistik.jsp">Statistik</a>
                        <a href="">Logout</a>
                    </div>
                <%
                //Rolle / Taskbar Polizei
                case "Polizei":%>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}\\jsp\\userAnzeigen.jsp">Nutzer</a>
                        <a href="${pageContext.request.contextPath}\\jsp\\ausnahme.jsp">Ausnahmen</a>
                        <a href="${pageContext.request.contextPath}\\jsp\\falschfahrer.jsp">Falschfahrer</a>
                        <a href="">Logout</a>
                    </div>
                <%
                //Rolle / Taskbar Verkehrswacht
                case "Verkehrswacht":%>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="userAnzeigen.jsp">Nutzer</a>
                        <a href="KfzOrten.jsp">Fahrzeuge orten</a>
                        <a href="">Logout</a>
                    </div>
                <%
                //Rolle / Taskbar Administrator
                case "Admin":%>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="userAnzeigen.jsp">Nutzer</a>
                        <a href="kfzAnzeigen.jsp">Fahrzeuge</a>
                        <a href="ausnahmen.jsp">Ausnahmen</a>
                        <a href="">Logout</a>
                    </div>
                <%
        }
        
        %>
        <!--Die weiteren Taskbars für die Unterscheidung-->
        <!--
        Polizei
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Ausnahmen</a>
            <a href="">Falschfahrer</a>
            <a href="">Logout</a>
        </div>
        Ministerium
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Statistik</a>
            <a href="">Logout</a>
        </div>
        Nutzer
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Fahrzeuge</a>
            <a href="">Fahrzeuge orten</a>
            <a href="">Rechnung</a>
            <a href="">Logout</a>
        </div>
        Verkehrswacht
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Fahrzeuge orten</a>
            <a href="">Logout</a>
        </div>
        Admin
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Fahrzeuge</a>
            <a href="">Ausnahmen</a>
            <a href="">Logout</a>
        </div>
        -->
    </body>
</html>
