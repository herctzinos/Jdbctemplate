
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <spring:form modelAttribute="userEntity" action="/adduser.htm" method="GET">
        <table>
            <tr>
                <td><spring:label path="name">Name</spring:label></td>
            <td><spring:input path="name" /></td>
            </tr>
            <tr>
                <td><spring:label path="surname">Last Name</spring:label></td>
            <td><spring:input path="surname" /></td>
            </tr>
            <tr>
                <td><spring:label path="password">Password</spring:label></td>
            <td><spring:password path="password" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </spring:form>        
</body>
</html>
