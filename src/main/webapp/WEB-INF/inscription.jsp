<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 04/08/2021
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Inscription</h1>
<form action="inscription" method="post">
<br>
<br>
<input type="nom" name="nom" placeholder="Nom">
<br>
<input type="prenom" name="prenom" placeholder="Prenom">
<br>
<input type="email" name="email" placeholder="Email">
<br>
<input type="password" name="password" placeholder="Mot de passe">
<br>
<div>
    <label>Votre niveau </label>
    <select name="Niveau">
        <c:forEach var="niveau" items="${niveaux}">
            <option value="${niveau.id}">${niveau.nom} </option>
        </c:forEach>
    </select>
</div>
    <div>
        <label>Votre Ville </label>
        <select name="Ville">
            <c:forEach var="ville" items="${villes}">
                <option value="${ville.id}">${ville.nom} </option>
            </c:forEach>
        </select>
    </div>
<br>
<input type="submit" value="Inscription">
</form>
</body>
</html>
