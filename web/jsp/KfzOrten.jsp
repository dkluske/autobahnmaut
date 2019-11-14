<%@page import="autobahnmaut.model.Nutzer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbetten der Formatierung durch CSS und das favicon.ico-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vdn.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Orten | Autobahnmaut</title>
    </head>
    <body>
        <%
            //Nutzer-Objekt aus der Session bekommen
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            //Rollenabfrage für die Berechtigung
            if(n.getRolle().equals("Nutzer") || n.getRolle().equals("Wacht") || n.getRolle().equals("Admin")){%>
                <section id="b1">
                    <div id="inb1">
                        <!--Einbinden der Taskbar-->
                        <div>
                            <jsp:include page="taskbar.jsp"/>
                        </div>
                        <h1 id="head_start">Fahrzeug orten</h1>
                        <div id="back_white">
                            <h1 id="head_form" style="color:rgb(68,72,69)">Zuletzt gemeldete Position</h1>
                            <!--Input-Form für die Erfassung des gesuchten Fahrzeugs-->
                            <form action="" method="post">
                                <br/><br/>
                                <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                                <input type="submit" value="Fahrzeug orten">
                                <br/><br/>
                            </form>
                        </div>
                    </div>
                </section><%
            //Wenn Rolle nicht erfüllt -> Weiterleitung auf Zugriff verweigert
            }else{%>
                <jsp:forward page="permissionDenied.jsp"/><%
            }
        %>
        
    </body>
</html>
