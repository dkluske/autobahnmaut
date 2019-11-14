<%@page import="autobahnmaut.model.Rechnungsfahrten"%>
<%@page import="autobahnmaut.model.Rechnungsposition"%>
<%@page import="autobahnmaut.model.Rechnung"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="autobahnmaut.datenbank.UserManager"%>
<%@page import="autobahnmaut.model.Fahrzeug"%>
<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.datenbank.FahrzeugManager"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Datei und der favicon.ico -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Kfz Registrieren | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            Date monat = Calendar.getInstance().getTime();
            Rechnung rechnung = UserManager.rechnungsdaten(n.getNutzerId(), monat);
            ArrayList<Rechnungsposition> rpL = rechnung.getRechnungspostionsListe();

            //Abfrage der Rolle aus dem Objekt und Prüfung der Berechtigung
            if (n.getRolle().equals("Nutzer")) { %>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der taskbar als jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeuge registrieren</h1>
                <div id="back_white">
                    

                                <table border ="1" width="500" align="center">
                                    <tr>
                                        <th>Kennzeichen</th>
                                        <th>Startort</th>
                                        <th>Endort</th>
                                        <th>Kilometer</th>
                                    </tr>

                                    <% for (Rechnungsposition rp : rpL) {
                                            ArrayList<Rechnungsfahrten> rfL = rp.getRechnungsfahrtenListe();
                                    %>   
                                    <tr>
                                        <th><%= rp.getKennzeichen()%></th>

                                    </tr>
                                    <% for (Rechnungsfahrten rf : rfL) {

                                    %>
                                    <td></td>
                                    <td><%= rf.getStartOrt()%></td>
                                    <td><%= rf.getEndOrt()%></td>
                                    <td><%= rf.getKilometer()%></td>
                                    <%
                                            }
                                        }
                                    %>


                      
                </div>
            </div>
        </section><%
            //Wenn keine Berechtigung -> Weiterleiten auf Zugriff verweigert
        } else { %>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
    </body>
</html>
