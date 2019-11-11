<%-- 
    Document   : taskbar
    Created on : 11.11.2019, 12:50:20
    Author     : Dome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String test = "polizei"
            switch(test):
                case 'polizei':%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Polizei</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
                case 'admin':%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
                case 'nutzer':%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
                case 'wacht':%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
                case 'ministerium':%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
                default:%>
                    <div class="navigation">
                        <p></p>
                        <img src="${pageContext.request.contextPath}\\css\\Logo_dMb_klein_neu.png">
                        <a href="">Function 1</a>
                        <a href="">Function 2</a>
                        <a href="">Function 3</a>
                        <a href="">Logout</a>
                    </div><%
        %>
        
    </body>
</html>
