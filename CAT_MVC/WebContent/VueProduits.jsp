<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"> 
<script type="text/javascript">
function confirmer(url){
	var rep=confirm("etes vous sûre de vouloire supprimer ce produit");
	if(rep==true){
		document.location=url;
	}
}
</script>
</head>
<body>
<div>
<form action="controleur.php"  method="post">
<table>
<tr>
<td>Mot clé: </td>
<td><input type="text" name="motcle" value="${modele.mc}"/></td>
<td><input type="submit" value="chercher" name="action"></td>
</tr>
</table>
</form>
</div>
<div>
<table class="table1">
<tr>
<th>Référence </th>
<th>Désignation </th>
<th>Prix </th>
<th>Quantité </th>
</tr>
<c:forEach items="${modele.prods}" var="p">
<tr>
<td>${p.reference}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td> <a href="javascript:confirmer('controleur.php?action=delete&ref=${p.reference}')">Supprimer</a></td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>