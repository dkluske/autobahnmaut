<%-- 
    Document   : kfzRegisterDB
    Created on : 14.11.2019, 13:56:28
    Author     : 17wi1188
--%>

<%@page import="autobahnmaut.model.Nutzer"%>
<%@page import="autobahnmaut.datenbank.FahrzeugManager"%>
<%@page import="autobahnmaut.model.Fahrzeug"%>
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
        <%
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            String kennzeichen = (String) request.getParameter("kennz");
            System.out.println(kennzeichen);
            Fahrzeug f = new Fahrzeug();
            f.setKennzeichen(kennzeichen);
            f.setLand(FahrzeugManager.getLandById(1));
            f.setNutzer(n);
            f.setPrivileg(false);
            FahrzeugManager.createFahrzeug(f);

        %>
        <jsp:forward page="kfzRegister.jsp"/> 
    </body>
</html>