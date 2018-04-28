
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Intercambistas</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <%@include file="jspf/navbar.jspf" %>
        <h1>Lista de Intercambistas</h1>
        <table class="table bg-dark text-white">
            <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>País</th>
            <th>Cidade</th>
            <th>Data Inicial da Estadia</th>
            <th>Data Final da Estadia</th>
            <th>Opções</th>
        </thead>
        <tbody>
            <c:forEach var="estrangeiro" items="${estrangeiros}">
                <tr>
                    <td>${estrangeiro.id}</td>
                    <td>${estrangeiro.nome}</td>
                    <td>${estrangeiro.pais}</td>
                    <td>${estrangeiro.cidade}</td>
                    <td>${estrangeiro.dataInicio}</td>
                    <td>${estrangeiro.dataFim}</td>
                    <td><a href="consulta-disponibilidade.html?est=${estrangeiro.id}" class="text-white">Consultar Disponibilidade</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="cadastrar-estrangeiro.html" class="btn btn-success">Cadastrar Estrangeiro</a>
    </div>
</body>
</html>
