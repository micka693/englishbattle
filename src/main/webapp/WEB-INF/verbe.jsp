<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 06/08/2021
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Modification du verbe arise ${idVerbe}</h1>
<form action="verbe?ID1" method="post">
    <input type="text" name="baseVerbale" value="arise" placeholder="Base verbale" title="base verbale contenant uniquement des lettres" required>
    <br>
    <input type="text" name="preterite" value="arose" placeholder="Préterite" title="Préterite contenant unquiquement des lettres" required>
    <br>
    <input type="text" name="participePasse" value="arisen" placeholder="Participe passe" title="Participe contenant unquiquement des lettres" required>
    <br>
    <input type="text" name="traduction" value="s'élever,survenir" placeholder="Traduction" title="Traduction contenant unquiquement des lettres" required>
    <input type="submit" value="Enregistrer">
</form>
</body>
</html>
