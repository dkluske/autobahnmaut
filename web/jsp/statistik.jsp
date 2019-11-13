<%-- 
    Document   : statistik
    Created on : 11.11.2019, 12:31:22
    Author     : Dome
--%>

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
                
            </div>
        </section>
    </body>
</html>
