<%@page import="autobahnmaut.datenbank.FahrzeugManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="autobahnmaut.model.Fahrzeug"%>
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
        <title>Ausnahmegenehmigungen | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");

            ArrayList<Fahrzeug> fzL = FahrzeugManager.getFahrzeugPrivileg();
            //Abfrage der Rolle und Prüfung der Berechtigung
    if (n.getRolle().equals("Polizei") || n.getRolle().equals("Admin")) {%>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden des Menübands-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Ausnahmegenehmigungen</h1>
                <!--Input-Form für das setzen der Ausnahmegenehmigung-->
                <div id="back_white">
                    <!--Tabelle, um View in zwei Teile zu teilen-->
                    <table style="width:100%">
                        <tr>
                            <!--Input Form-->
                            <td>
                                <form action="${pageContext.request.contextPath}/jsp/ausnahmeDB.jsp" method="post">
                                    <br/><br/>
                                    <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                                    <input type="submit" name="action" value="Hinzufügen" id="submit">
                                    <input type="submit" name="action" value="Entfernen" id="submit">
                                </form>
                            </td>
                            <!--Liste der geflagten Fahrzeuge-->
                            <td>
                                <ul>
                                    <!--Script für die anzeige der schon vorhandenen Fahrzeuge einfügen-->
                                    <% for (Fahrzeug f : fzL) {

                                    %>   

                                    <li> <%=f.getKennzeichen()%></li>

                                    <%
                                        }
                                    %>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </section><%
                    //Wenn keine Berechtigung vorhanden -> Weiterleiten auf Zugriff verweigert
                } else {%>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>

    </body>
</html>
