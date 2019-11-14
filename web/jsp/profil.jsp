<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Dateien für die Formatierung und das Favicon-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Profil | Autobahnmaut</title>
    </head>
    <body>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der Taskbar-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <div id="back_white">
                    <h1 id="head_start"> PROFIL</h1><br/>
                    <c:out value="${nutzer.name}"/><br/>
                    <c:out value="${nutzer.rolle}"/><br/>
                    <c:out value="${nutzer.email}"/><br/>
                    

                </div>
            </div>
        </section>
    </body>
</html>
