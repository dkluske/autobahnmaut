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

                
                <h1 id="head_start">PROFIL</h1>
                <div id="back_white">
                    <div class="centered">
                        <form action="${pageContext.request.contextPath}\profil" method="post">
                            <!--<label for="name">Name</label>-->
                            <input name="name" placeholder="name" value="<c:out value="${nutzer.name}"/>">
                            <!--<label for="email">Email</label>-->
                            <input name="email" placeholder="email" value="<c:out value="${nutzer.email}"/>">
                            <!--<label for="strasse">Strasse</label>-->
                            <input name="strasse" placeholder="strasse" value="<c:out value="${nutzer.strasse}"/>">
                            <!--<label for="plz">PLZ</label>-->
                            <input name="plz" placeholder="plz" value="<c:out value="${nutzer.plz}"/>">
                            <!--<label for="ort">Ort</label>-->
                            <input name="ort" placeholder="ort" value="<c:out value="${nutzer.ort}"/>">
                            <input type="submit">
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
