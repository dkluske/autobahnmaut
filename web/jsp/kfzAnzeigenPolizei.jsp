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
        <title>Nutzerfahrzeuge | Autobahnmaut</title>
    </head>
    <body>
        <%

            String nutzerId = (String) request.getParameter("nid");

            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");

            ArrayList<Fahrzeug> fzL = FahrzeugManager.fahrzeuglisteNutzer(Integer.parseInt(nutzerId));
            
            Nutzer nu = UserManager.getNutzerById(Integer.parseInt(nutzerId));

            //Abfrage der Rolle aus dem Objekt und Prüfung der Berechtigung
            if (n.getRolle().equals("Polizei")) {%>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der taskbar als jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeuge zum Nutzer: <%= nu.getName()  %></h1>
                <div id="back_white">
                    <table border ="1" width="500" align="center">
                        <tr>
                            <th>Nutzer ID</th>
                            <th>Name</th>
                            <th>PLZ</th>
                            <th>Ort</th>
                        </tr>

                        <!--Script für die anzeige der schon vorhandenen Fahrzeuge einfügen-->
                        <% for (Fahrzeug f : fzL) {

                        %>   

                        <tr>
                            <td><%=f.getFahrzeugId()%></td>
                            <td><%=f.getKennzeichen()%></td>
                            <td><%= f.isPrivileg() %></td>
                            <td><%= f.getLand().getBezeichnung() %></td>
                        </tr>
                        



                        <%
                            }
                        %>

                    </table>
                </div>
            </div>
        </section><%
            //Wenn keine Berechtigung -> Weiterleiten auf Zugriff verweigert
        } else {%>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
    </body>
</html>
