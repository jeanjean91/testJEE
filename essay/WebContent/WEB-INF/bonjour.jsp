<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<%@ include file="menu.jsp" %>

<%-- formulaires --%>

  <c:if test="${ !empty nom }"><p><c:out value="Bonjour, vous vous appelez ${ nom }" /></p></c:if>
        <c:out value="${ nom }" />

<form method="post" action="bonjour">
<label for="password">Nom</label>
<input type="text" id="nom" name="nom"/>

<input type="submit"/>

</form>

 <c:if test="${ !empty form.resultat }"><p><c:out value=" mauvaise" /></p></c:if>
        

<form method="post" action="bonjour">
<label for="password">login</label>
<input type="text" id="login" name="login"/>
<br/>
<label for="password">Password</label>
<input type="password" id="pass" name="pass"/>
<br/>

<input type="submit"/>

</form>

<%-- envoi de fichier --%>

  <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
    <form method="post" action="bonjour" enctype="multipart/form-data">
        <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" />
        </p>
        
        <input type="submit" />
    </form>
    
     <c:out value="${ prenom }" />
    
     <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </c:if>
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        
        <input type="submit" />
    </form>
<%--
<p> WA GUAN!
</p>
<p>
<%
for(int i = 0 ; i < 20 ;i++){
	 out.println ("kel by?? <br>");
	 }

%>
</p> --%>
<%-- les conditions en jstl --%>
<%--
<c:choose>
    <c:when test="${ variable }">Du texte</c:when>
    <c:when test="${ autreVariable }">Du texte</c:when>
    <c:when test="${ encoreUneAutreVariable }">Du texte</c:when>
    <c:otherwise></c:otherwise>
</c:choose>
<p>
<c:if test="${ 50 > 10 }" var="variable">
    C'est vrai !
</c:if>
<c:out value="Bonjour !" /> ${ user.nom
 } ${ user.prenom
 }

<p><c:out value="${ user.nom }">Valeur par défaut</c:out></p>
<c:set var="pseudo" value="Mateo21" scope="page" />
<c:remove var="pseudo" scope="page" />

<p>
${ user.actif ? 'vous ete actif':'vous ete innactif!'}
</p>
<c:set target="${ user }" property="prenom" value="Mathieu" />
<p><c:out value="${ user.prenom }" /></p>
--%>
<%-- les boucles en jstl --%>
<%--
<c:forEach  begin="0" end="10" step="1">
    <p>Un message  !</p>
</c:forEach>


<c:forEach var="i" begin="0" end="10" step="2">
    <p>Un message n°<c:out value="${ i }" /> !</p>
</c:forEach>

<p><c:forEach items="${ titres }" var="titre" varStatus="status">
    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
</c:forEach>
</p>
<p>
<c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/ ">
    <p>${ morceau }</p>
</c:forTokens>
</p>
--%>


</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>