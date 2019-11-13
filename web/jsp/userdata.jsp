<%-- 
    Document   : changedata
    Created on : 13.11.2019, 09:23:34
    Author     : 17wi1199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Datei und der favicon.ico -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Nutzerdaten | Autobahnmaut</title>
    </head>
    <body>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der taskbar als jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Nutzerdaten</h1>
                <div id="back_white">
                    <div id="regform1">
                        <form action="${pageContext.request.contextPath}/register" method="post">
                            <br/>
                            <input style="width:85%" type="text" name="firma" placeholder="Firmenname" readonly><br/>
                            <input style="width:85%" type="text" name="strasse" placeholder="Straße"readonly><br/>
                            <input style="width:85%" type="text" name="plz" placeholder="PLZ"readonly><br/>
                            <input style="width:85%" type="text" name="ort" placeholder="Ort"readonly><br/><br/>
                            <input style="width:60%" type="button" name="change" value="Bearbeiten"><br/><br/>
                        </form>
                    </div>
                    <div id="regform2">
                        <form action="${pageContext.request.contextPath}/register" method="post">
                            <br/>
                            <input style="width:48%" type="text" name="UST" placeholder="Ust-ID"readonly><br/>
                            <input style="width:48%" type="text" name="email" placeholder="E-Mail-Adresse"readonly><br/>
                            <input style="width:48%" type="password" name="password" placeholder="Passwort"readonly><br/>
                            <input style="width:48%" type="password" name="passwdh" placeholder="Passwort wdh."readonly><br/><br/>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
