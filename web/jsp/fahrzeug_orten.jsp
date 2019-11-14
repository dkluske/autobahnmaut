<%-- 
    Document   : fahrzeuge_registrieren
    Created on : 11.11.2019, 13:04:25
    Author     : 17wi1199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\welcome.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Fahrzeug orten | Autobahnmaut</title>
    </head>
    
    <body>
        <section id="b1">
            <div id="inb1">
                <div class="navigation">
                    <text>Autobahnmaut</text>
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Function 4</a>
                </div>
                
                <h1 id="head_start">Fahrzuge orten</h1>
            </div>
            
            <section id="a1">
            <div id="regin">
                <h1 id="head_log">Autobahnmaut</h1>
            </div>
            <div id="reg_back">
                <div id="fz_ortform">
                    <form action="" method="post">
                        <br/>
                        <text id="head_form">Fahrzeuge orten</text>
                        <br/><br/><br/>
                        <div id="fz_ort"><input type="text" name="hersteller" placeholder="Hersteller"> <br/>
                            <input type="text" name="modell" placeholder="Modell"><br/>
                            <input type="text" name="farbe" placeholder="Farbe"><br/>
                            <input type="text" name="kennzeichen" placeholder="Kennzeichen"><br/><br/><br/>
                            <input type="confirm" name="bestätigen" placeholder="Bestätigen" id="loginbtn">
                        </div>
                    </form>
                </div>
            </div>
        </section>
        </section>
    </body>
</html>
