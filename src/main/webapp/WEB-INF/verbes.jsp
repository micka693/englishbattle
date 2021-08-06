<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 06/08/2021
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Liste des verbes</h1>
<table>
    <tbody>
    <tr>
        <td>Base VErbale</td>
        <td>Preterit</td>
        <td>Participe Passe</td>
        <td>Traduction</td>
        <td>Action</td>
    </tr>
    <!-- on parcours la liste des verbes envoyer par la servlet-->
    <c:forEach items="${verbes}" var="verbe">
        <tr>
            <td>${verbe.getBaseVerbale()}</td>
            <td>${verbe.getPreterit()}</td>
            <td>${verbe.getParticipePasse()}</td>
            <td>${verbe.getTraduction()}</td>
            <td><a href="verbe?ID=${verbe.getId()}">Modifier</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="index">Retour</a>
</body>
</html>
