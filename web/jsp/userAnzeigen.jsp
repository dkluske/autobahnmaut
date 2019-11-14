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
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            if(n.getRolle() == "Wacht" || n.getRolle() == "Polizei"){%>
                <section id="b1">
                    <div id="inb1">
                        <!--Einbettung der Taskbar-->
                        <div>
                            <jsp:include page="taskbar.jsp"/>
                        </div>
                        <h1 id="head_start">Nutzer anzeigen</h1>
                        <div id="back_white">
                            <!--Hier Script für Anzeige der Liste der Nutzer im System einfügen-->
                            <ul>
                                <% %><li></li><% %>
                            </ul>
                            <!--Input-Form für die Erfassung der Fahrzeuge eines Nutzers-->
                            <form action="" method="post">
                                <br/><br/>
                                <input type="text" name="email" placeholder="E-Mail Adresse">
                                <input type="submit" value="Fahrzeuge anzeigen">
                                <br/><br/>
                            </form>
                        </div>
                    </div>
                </section><%
            }else{%>
                <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
    </body>
</html>
