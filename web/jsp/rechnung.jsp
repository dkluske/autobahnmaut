<%-- 
    Document   : rechnung
    Created on : 12.11.2019, 10:55:44
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
        <title>Rechnung anzeigen | Autobahnmaut</title>
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
                
                <h1 id="head_start">Rechnung anzeigen</h1>
            </div>
            
            <section id="a1">
            <div id="regin">
                <h1 id="head_log">Autobahnmaut</h1>
            </div>
            <div id="rechn_back">
                <div id="rechnform">
                    <form action="" method="post">
                        <br/>
                        <text id="head_rechn">Rechnung anzeigen</text>
                        <br/><br/><br/>
                        <div id="rechn_form"><input type="text" name="firma" placeholder="Firma"> <br/>
                            <input type="text" name="anschrift" placeholder="Anschrift"><br/>
                            <input type="text" name="rechnnr" placeholder="Rechnungsnummer"><br/>
                            <input type="text" name="datum" placeholder="Datum"><br/><br/><br/>
                            <input type="" name="bestätigen" placeholder="Bestätigen" id="loginbtn">
                        </div>
                    </form>
                </div>
            </div>
        </section>
        </section>
    </body>
</html>
