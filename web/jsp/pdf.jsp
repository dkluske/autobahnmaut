<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\\css\\pdf.css">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${pageContext.request.contextPath}\\favicon.ico">
        <title>Monatliche Rechnung</title>
    </head>
    <body>
        <!--<iframe src="${pageContext.request.contextPath}\\css\\beispiel.pdf" height="900"></iframe>-->
        <!--<embed width="600" height="800" src="${pageContext.request.contextPath}\\css\\beispiel.pdf">-->
        <object data="${pageContext.request.contextPath}\\src\\pdf\\test.pdf" style="width:100%;height:1000px">
        </object>
    </body>
</html>
