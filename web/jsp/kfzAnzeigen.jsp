
<%@page import="autobahnmaut.datenbank.FahrzeugManager"%>
<%@page import="autobahnmaut.model.Fahrzeug"%>
<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS und der Favicon.ico-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Kfz Anzeigen | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");

            //Rollen-Abfrage für die Berechtigung auf den Zugriff
    if(n.getRolle().equals("Polizei")  || n.getRolle().equals("Wacht") || n.getRolle().equals("Admin")){%>
                <section id="b1">
                    <div id="inb1">
                        <!--Einbinden der Taskbar.jsp-->
                        <div>
                            <jsp:include page="taskbar.jsp"/>
                        </div>
                        <h1 id="head_start">Fahrzeuge anzeigen</h1>
                        <div id="back_white">
                            <table border ="1" width="500" align="center"> 
                              <tr bgcolor="00FF7F"> 
                              <th><b>Fahrzeug ID</b></th> 
                              <th><b>Fahrzeug Kennzeichen</b></th> 
                              <th><b>Course Undertaken</b></th> 
                              </tr> 
                
                
                              <c:forEach items="${fahrzeuge}" var="item">
                              <tr>
                              <td><c:out value="${item.fahrzeugId}"/></td>
                              <td><c:out value="${item.kennzeichen}"/></td>
                              <td></td>
                              </tr>
                              </c:forEach>
                            </table>
                        </div>
                    </div>
                </section><%
            //Wenn Berechtigung nicht vorhanden -> Weiterleitung auf Permission Denied 
            }else{%>
                <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
    </body>
</html>
