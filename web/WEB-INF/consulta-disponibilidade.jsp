
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Anfitriões Disponíveis</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <%@include file="jspf/navbar.jspf" %>
        <h1>Lista de Anfitriões Disponíveis para ${estrangeiro.nome} entre as datas ${estrangeiro.dataInicio} e ${estrangeiro.dataFim}</h1>
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
            <c:choose>
                <c:when test="${fn:length(disponiveis)!=0}">
                    <c:forEach var="anfit" items="${disponiveis}">
                        <tr>
                            <td>${anfit.id}</td>
                            <td>${anfit.nome}</td>
                            <td>${anfit.categoria}</td>
                            <td>${anfit.dataInicio}</td>
                            <td>${anfit.dataFim}</td>
                            <td>${anfit.telefone}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${fn:length(disponiveis)==0}">
                    <tr>
                        <td colspan="6">Não há Anfitriões Disponíveis. Aguarde mais um pouco</td> 
                    </tr>
                </c:when>
            </c:choose>
        </tbody>
    </table>
</body>
</html>
