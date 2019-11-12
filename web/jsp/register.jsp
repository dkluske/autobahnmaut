<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS und Favicon eingebunden -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\welcome.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Registrieren | Autobahnmaut</title>
    </head>
    <body>
        <section id="a1">
            <div id="regin">
                <h1 id="head_log">Autobahnmaut</h1>
            </div>
            <div id="reg_back">
                <div id="reg_form">
                    <form action="${pageContext.request.contextPath}/register" method="post">
                        <br/>
                        <text id="head_form">Registrieren</text>
                        <br/><br/><br/>
                        <input type="text" name="firma" placeholder="Firmenname"><br/>
                        <input type="text" name="strasse" placeholder="Straße"><br/>
                        <input type="text" name="plz" placeholder="PLZ"><br/>
                        <input type="text" name="ort" placeholder="Ort"><br/>
                        <input type="text" name="UST" placeholder="Ust-ID"><br/><br/><br/>
                        <input type="text" name="email" placeholder="E-Mail-Adresse"><br/>
                        <input type="password" name="password" placeholder="Passwort"><br/>
                        <input type="password" name="passwdh" placeholder="Passwort wdh."><br/><br/>
                        <input type="submit" name="register" value="Registrieren" id="loginbtn"><br/>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
