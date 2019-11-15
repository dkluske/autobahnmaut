<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.datenbank.UserManager"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="autobahnmaut.model.Nutzer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Formatierungen und des Favicons-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Nutzer anzeigen | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            ArrayList<Nutzer> nL = UserManager.getNutzerListe();
            //Rolle aus dem Objekt nehmen und Berechtigung prüfen
            if (n.getRolle().equals("Wacht") || n.getRolle().equals("Polizei") || n.getRolle().equals("Admin")) {%>
        <section id="b1">
            <div id="inb1">
                <!--Einbettung der Taskbar-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Nutzer anzeigen</h1>
                <div id="back_white">
                    <!--Hier Script für Anzeige der Liste der Nutzer im System einfügen-->
                    <table border ="1" width="500" align="center">
                        <tr>
                            <th>Nutzer ID</th>
                            <th>Name</th>
                            <th>PLZ</th>
                            <th>Ort</th>
                        </tr>

                        <% for (Nutzer nutzer : nL) {

                        %>   
                        <tr>
                            <td><%=nutzer.getNutzerId()%></td>
                            <td><%=nutzer.getName()%></td>
                            <td><%=nutzer.getOrt()%></td>
                            <td><%=nutzer.getPlz()%></td>
                        </tr>
                        

                        <%
                            }
                        %>


                    </table>
                    <!--Input-Form für die Erfassung der Fahrzeuge eines Nutzers-->
                    <form action="${pageContext.request.contextPath}/jsp/kfzAnzeigenPolizei.jsp" method="post">
                        <br/><br/>
                        <input type="text" name="nid" placeholder="Nutzer ID">
                        <input type="submit" value="Fahrzeuge anzeigen">
                        <br/><br/>
                    </form>
                </div>
            </div>
        </section><%
            //Wenn keine Berechtigung vorhanden -> Weiterleiten auf Permission Denied
        } else {%>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
    </body>
</html>
