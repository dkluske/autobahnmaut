<%@page import="autobahnmaut.datenbank.FahrtenManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.model.FahrtenAbgeschlossen"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbetten der CSS und der favicon.ico-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Falschfahrer | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            ArrayList<FahrtenAbgeschlossen> fL = FahrtenManager.getFalschfahrten();
            //Rolle aus Nutzer-Objekt ziehen und Berechtigung prüfen
            if(n.getRolle().equals("Polizei")){%>
                <section id="b1">
                    <div id="inb1">
                        <!--Einbinden der Taskbar als JSP-->
                        <div>
                            <jsp:include page="taskbar.jsp"/>
                        </div>
                        <h1 id="head_start">Falschfahrerliste</h1>
                        <div id="back_white">
                            <table border ="1" width="500" align="center">
                        <tr>
                            <th>Fahrtennummer</th>
                            <th>Kennzeichen</th>
                            <th>Auffahrtsort</th>
                            <th>Auffahrtszeit</th>
                            <th>Abfahrtsort</th>
                            <th>Abffahrtszeit</th>
                        </tr>

                        <!--Script für die anzeige der schon vorhandenen Fahrzeuge einfügen-->
                        <% for (FahrtenAbgeschlossen fahrt : fL) {

                        %>   

                        <tr>
                            <td><%= fahrt.getFahrtenAbgeschlossenId() %></td>
                            <td><%=fahrt.getFahrzeug().getKennzeichen()%></td>
                            <td><%= fahrt.getMautbrueckeStart().getStandort().getBezeichnung() %></td>
                            <td><%= fahrt.getStartZeit() %></td>
                            <td><%= fahrt.getMautbrueckeRecent().getStandort().getBezeichnung() %></td>
                            <td><%= fahrt.getEndZeit() %></td>
                            
                        </tr>
                        



                        <%
                            }
                        %>

                    </table>
                        </div>
                    </div>
                </section><%
            //Wenn keine Berechtigung vorhanden -> Weiterleitung auf Permission Denied
            }else{%>
                <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
        
    </body>
</html>
