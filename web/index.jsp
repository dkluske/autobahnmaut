<%-- 
    Document   : index
    Created on : 07.11.2019, 09:28:13
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS für die Formatierung und das Favicon-->
        <link rel="stylesheet" type="text/css" href="css\\welcome.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="favicon.ico">
        <title>Login | Autobahnmaut</title>
    </head>
    <body>
        <section id="a1">
            <div id="ina1">
                <div>
                    <h1 id="head_log">Autobahnmaut</h1>
                </div>
                <div id="log_back">
                    <div id="log_form">
                        <!--Eingabeform für den Login-->
                        <form action="" method="post">
                            <br/>
                            <text id="head_form">Login</text>
                            <br/><br/><br/>
                            <!--E-Mail Feld-->
                            <input type="text" name="email" placeholder="E-Mail-Adresse"><br/><br/>
                            <!--Passwort Feld -->
                            <input type="password" name="password" placeholder="Passwort" id="password"><br/><br/>
                            <!--Link zur Registrieren Seite-->
                            <a href="${pageContext.request.contextPath}/register">Registrieren</a><br/><br/>
                            <!--Login Button-->
                            <input type="submit" value="Login" id="loginbtn">
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
