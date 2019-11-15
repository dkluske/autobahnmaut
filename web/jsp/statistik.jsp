<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.model.Statistikdaten"%>
<%@page import="autobahnmaut.model.Statistik"%>
<%@page import="autobahnmaut.datenbank.StatistikManager"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Dateien und des Favicons-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Statistik | Autobahnmaut</title>
    </head>
    <body>
        <%
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            Statistik statistik = StatistikManager.getStatistikdaten();
            ArrayList<Statistikdaten> sdL = statistik.getStatistikListe();
            if (n.getRolle().equals("Ministerium") || n.getRolle().equals("Admin")) {%>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden des Menübands-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>

                <h1 id="head_start">Statistik</h1>


            </div>
            <!--Hier Statistikdaten / ggf. SVG aus Daten einfügen-->        
            <div id="back_white">

                <table border ="1" width="700" align="center"> 
                        <tr bgcolor="00FF7F"> 
                            <th><b>Postion</b></th> 
                            <th><b>Land</b></th> 
                            <th><b>Kilometer</b></th> 
                        </tr> 
                    <!--Script für die anzeige der schon vorhandenen Fahrzeuge einfügen-->
                    <% int count=0;
                        for (Statistikdaten sd : sdL) {
                        count++;
                    %>   

                    


                        <tr>
                            <td><%= count%></td>
                            <td><%= sd.getLand()%></td>
                            <td><%= sd.getKm()%></td>
                        </tr>

                    



                    <%
                        }
                    %>
                </table>
                
            </div>
        </section><%
        } else {%>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>

    </body>
</html>
