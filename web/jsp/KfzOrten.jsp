<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbetten der Formatierung durch CSS und das favicon.ico-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextpath}\\css\\taskbar.css">
        <link rel="icon" type="image/vdn.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Orten | Autobahnmaut</title>
    </head>
    <body>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der Taskbar-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeug orten</h1>
                <div id="back_white">
                    <h3 id="head_form" style="color:rgb(68,72,69)">Zuletzt gemeldete Position</h3>
                    <!--Input-Form für die Erfassung des gesuchten Fahrzeugs-->
                    <form action="" method="post">
                        <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                        <input type="submit" value="Fahrzeug orten">
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
