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
        <title>Fahrzeuge registrieren | Autobahnmaut</title>
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
                
                <h1 id="head_start">Fahrzeuge registrieren</h1>
            </div>
            
            <section id="a1">
            <div id="regin">
                <h1 id="head_log">Autobahnmaut</h1>
            </div>
            <div id="reg_back">
                <div id="fz_regform">
                    <form action="" method="post">
                        <br/>
                        <text id="head_form">Fahrzeuge registrieren</text>
                        <br/><br/><br/>
                        <div id="l"><input type="text" name="hersteller" placeholder="Hersteller"> <br/>
                            <input type="text" name="modell" placeholder="Modell"><br/>
                            <input type="text" name="farbe" placeholder="Farbe"><br/>
                            <input type="text" name="kennzeichen" placeholder="Kennzeichen"><br/>
                        </div>
                        <div id="r"><input type="text" name="firmenname" placeholder="Firmenname"> <br/>
                            <input type="text" name="anschrift" placeholder="Anschrift"><br/>
                            <input type="text" name="email" placeholder="E-Mail-Adresse"><br/><br/><br/>
                            <input type="submit" name="register" value="Registrieren" id="loginbtn"><br/>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        </section>
    </body>
</html>
