
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Anfitrioes</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <%@include file="jspf/navbar.jspf" %>
        <h1>Lista de Anfitriões</h1>
        <table class="table bg-dark text-white">
            <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>Data Início</th>
            <th>Data Fim</th>
            <th>Telefone</th>
        </thead>
        <tbody>
            <c:forEach var="anfit" items="${anfitrioes}">
                <tr>
                    <td>${anfit.id}</td>
                    <td>${anfit.nome}</td>
                    <td>${anfit.categoria}</td>
                    <td>${anfit.dataInicio}</td>
                    <td>${anfit.dataFim}</td>
                    <td>${anfit.telefone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <div>
            <a href="cadastrar-anfitriao.html" class="btn btn-success">Cadastrar Anfitrião</a>
        </div>
</body>
</html>
