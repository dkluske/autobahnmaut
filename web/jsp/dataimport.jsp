
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="autobahnmaut.logik.DatenInput"%>
<!DOCTYPE html>
<%
            DatenInput.simulatorInFahrten();    

        %>
        
        <jsp:forward page="start.jsp"/> 
