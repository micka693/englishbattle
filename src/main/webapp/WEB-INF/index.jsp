<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 05/08/2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>connexion</title>
</head>
<body>
<h1>ENGLISH TEST </h1>
<br>
<form action="connexion" method="post" >
    <input type="email" name="email" >
    <input type="password" name="password" placeholder="password">
    <h1>HALL OF FAME</h1>
    <br>
    <input type="submit" value="connexion">
</form>
    <br>
    <c:forEach var="joueur" items="${joueurs}"><!-- 1/pour chaque joueur(var) dans la liste joueurs(items) -->
        <p value="${joueur.id}">${joueur.prenom}<!-- 2/recupere l'id et affiche le prenom correspondant à l'id récupérer-->
        </p>
    </c:forEach>



<form action="inscription" method="get">
    <input type="submit"value="inscription">
</form>
<a href="inscriptionAvecTeleversement">Inscription avec televersement</a>
<p> Nombre total de joueurs : ${joueurs.size()} </p>
<p><a href="joueurs">Liste des joueurs</a></p>
<p> nombre total de verbe:${nbVerbes} </p>
<p><a href="verbes">Liste des verbes</a></p>
</body>
</html>
