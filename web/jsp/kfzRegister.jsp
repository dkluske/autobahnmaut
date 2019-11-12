<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Einbinden der CSS Datei und der favicon.ico -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\mainCSS.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\taskbar.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Kfz Registrieren | Autobahnmaut</title>
    </head>
    <body>
        <section id="b1">
            <div id="inb1">
                <!--Einbinden der taskbar als jsp-->
                <div>
                    <jsp:include page="taskbar.jsp"/>
                </div>
                <h1 id="head_start">Fahrzeuge registrieren</h1>
                <div id="back_white">
                    <table style="width:100%">
                        <tr>
                            <!--Input Form für die Fahrzeugregistrierung-->
                            <td>
                                <form action="" method="post">
                                    <br/><br/>
                                    <input type="text" name="kennz" placeholder="Kfz-Kennzeichen"><br/><br/>
                                    <input type="submit" value="Registrieren" id="submit">
                                    <br/><br/>
                                </form>
                            </td>
                            <!--Liste der schon vorhandenen Fahrzeuge-->
                            <td>
                                <ul>
                                    <!--Script für die anzeige der schon vorhandenen Fahrzeuge einfügen-->
                                    <% %><li></li><% %>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </section>
    </body>
</html>
