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
            //Rolle aus Nutzer-Objekt ziehen und Berechtigung prüfen
            if(n.getRolle() == "Polizei"){%>
                <section id="b1">
                    <div id="inb1">
                        <!--Einbinden der Taskbar als JSP-->
                        <div>
                            <jsp:include page="taskbar.jsp"/>
                        </div>
                        <h1 id="head_start">Falschfahrerliste</h1>
                        <div id="back_white">
                            <ul>
                                <!--Script für Liste der Falschfahrer einfügen-->
                                <% %><li></li><% %>
                            </ul>
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
