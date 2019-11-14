<%-- 
    Document   : ausnahmeDB
    Created on : 14.11.2019, 14:51:54
    Author     : 17wi1188
--%>

<%@page import="autobahnmaut.datenbank.FahrzeugManager"%>
<%@page import="autobahnmaut.model.Fahrzeug"%>
<%@page import="autobahnmaut.model.Nutzer"%>
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
        <%
            Nutzer n = (Nutzer) request.getSession().getAttribute("nutzer");
            String kennzeichen = (String) request.getParameter("kennz");
            String hinzu = (String) request.getParameter("action");
            System.out.println(hinzu);
            
            
            
            Fahrzeug f = new Fahrzeug();
            if (FahrzeugManager.getFahrzeugByKennzeichen(kennzeichen) !=null){
                f= FahrzeugManager.getFahrzeugByKennzeichen(kennzeichen);
                if (hinzu.equals("Entfernen")){
                    f.setPrivileg(false); 
                }else{
                   f.setPrivileg(true); 
                }
                
                
                boolean test= FahrzeugManager.updateFahrzeug(f);
                System.out.println(test);
            }
            
            
            
            

        %>
        <jsp:forward page="ausnahme.jsp"/> 
    </body>
</html>
