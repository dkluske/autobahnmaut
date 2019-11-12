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
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der Taskbar.jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeuge anzeigen</h1>
                <div id="back_white">
                    <ul>
                        <!--Script für Auflistung aller Fahrzeuge-->
                        <% %><li></li><% %>
                    </ul>
                </div>
            </div>
        </section>
        
    </body>
</html>
