<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Datei für die Formatierung der Taskbar-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
    </head>
    <body>
        <!-- Default -->
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar-->
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers-->
            <a href="">Function 1</a>
            <a href="">Function 2</a>
            <a href="${pageContext.request.contextPath}/nutzer">Profil</a>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
        <!--Die weiteren Taskbars für die Unterscheidung-->
        <!--
        Polizei
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Ausnahmen</a>
            <a href="">Falschfahrer</a>
            <a href="">Logout</a>
        </div>
        Ministerium
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Statistik</a>
            <a href="">Logout</a>
        </div>
        Nutzer
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Fahrzeuge anzeigen</a>
            <a href="">Fahrzeuge orten</a>
            <a href="">Rechnung</a>
            <a href="">Logout</a>
        </div>
        Verkehrswacht
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Fahrzeuge orten</a>
            <a href="">Logout</a>
        </div>
        Admin
        <div class="navigation">
            <!--Logo der Firma links in der Taskbar
            <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
            <!--Verfügbare Funktionen des Nutzers
            <a href="">Nutzer</a>
            <a href="">Fahrzeuge</a>
            <a href="">Ausnahmen</a>
            <a href="">Logout</a>
        </div>
        -->
    </body>
</html>
