<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
           
                //Rolle / Taskbar Normalnutzer              
        if(n.getRolle().equals("Nutzer")){
        %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}/kfzRegister">Fahrzeuge</a>
                        <a href="${pageContext.request.contextPath}/KfzOrten">Fahrzeuge orten</a>
                        <a href="${pageContext.request.contextPath}/rechnung">Rechnung</a>
                        <a href="${pageContext.request.contextPath}/profil">Profil</a>
                        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </div>
                <%
                  }else if (n.getRolle().equals("Ministerium")){  
                //Rolle / Taskbar Ministerium
                %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}/statistik">Statistik</a>
                        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </div>
                <%
                   }else if (n.getRolle().equals("Polizei")){ 
                //Rolle / Taskbar Polizei
                %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}/userAnzeigen">Nutzer</a>
                        <a href="${pageContext.request.contextPath}/ausnahme">Ausnahmen</a>
                        <a href="${pageContext.request.contextPath}/falschfahrer">Falschfahrer</a>
                        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </div>
                <%
                   }else if(n.getRolle().equals("Verkehrswacht")){ 
                //Rolle / Taskbar Verkehrswacht
               %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}/userAnzeigen">Nutzer</a>
                        <a href="${pageContext.request.contextPath}/KfzOrten">Fahrzeuge orten</a>
                        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </div>
                <%
                    }else if(n.getRolle().equals("Admin")){ 
                //Rolle / Taskbar Administrator
                %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="${pageContext.request.contextPath}/userAnzeigen">Nutzer</a>
                        <a href="${pageContext.request.contextPath}/kfzAnzeigen">Fahrzeuge</a>
                        <a href="${pageContext.request.contextPath}/ausnahmen">Ausnahmen</a>
                        <a href="${pageContext.request.contextPath}/profil">Profil</a>
                        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </div>
                <%
                   }else { 
                %>
                    <div class="navigation">
                        <!--Logo der Firma links in der Taskbar-->
                        <img src="${paeContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <!--Verfügbare Funktionen des Nutzers-->
                        <a href="">Function1</a>
                        <a href="">Function2</a>
                        <a href="">Function3</a>
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
