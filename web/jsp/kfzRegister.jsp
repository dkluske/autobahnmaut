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

            ArrayList<Fahrzeug> fzL = FahrzeugManager.fahrzeuglisteNutzer(n.getNutzerId());

            //Abfrage der Rolle aus dem Objekt und Prüfung der Berechtigung
            if (n.getRolle().equals("Nutzer")) {%>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der taskbar als jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeuge registrieren</h1>
                <div id="back_white">
                    <table style="width:100%">
                        <tr>
                            <!--Input Form für die Fahrzeugregistrierung-->
                            <td>
                                <form action="${pageContext.request.contextPath}/jsp/kfzRegisterDB.jsp" method="post">
                                    <br/><br/>
                                    <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                                    <input type="submit" value="Registrieren" id="submit">
                                    <br/><br/>
                                </form>
                            </td>
                            <!--Liste der schon vorhandenen Fahrzeuge-->
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
                    //Wenn keine Berechtigung -> Weiterleiten auf Zugriff verweigert
                } else {%>
        <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>

    </body>
</html>
