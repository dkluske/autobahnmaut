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
            //Abfrage der Rolle und Prüfung der Berechtigung
            if (n.getRolle().equals("Polizei")){%>
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
                                        <form action="" method="post">
                                            <br/><br/>
                                            <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                                            <input type="submit" name="hinzu" value="Hinzufügen" id="submit">
                                            <input type="submit" name="delete" value="Entfernen" id="submit">
                                        </form>
                                    </td>
                                    <!--Liste der geflagten Fahrzeuge-->
                                    <td>
                                        <ul>
                                            <!--Script zum anzeigen der geflagten Autos-->
                                            <% %><li>
                                                <%= %>
                                            </li><% %>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </section><%
            //Wenn keine Berechtigung vorhanden -> Weiterleiten auf Zugriff verweigert
            }else{%>
            <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
        
    </body>
</html>
