<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Intercambista</title>
        <%@include file="jspf/head.jspf" %>
    </head>
    <body>
        <%@include file="jspf/navbar.jspf" %>
        <h1>Adicionar Intercambista</h1>
        <form method="post">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" class="form-control col-md-4" />
            </div>
            <div class="form-group">
                <label for="pais">País</label>
                <input type="text" name="pais" id="pais" class="form-control col-md-4" />
            </div>
            <div class="form-group">
                <label for="cidade">Cidade</label>
                <input type="text" name="cidade" id="cidade" class="form-control col-md-4" />
            </div>
            <div class="form-group">
                <label for="dataInicio">Data Inicial de Disponibilidade</label>
                <input type="date" name="dataInicio" id="dataInicio" class="form-control col-md-4" />
            </div>
            <div class="form-group">
                <label for="dataFinal">Data Final de Disponibilidade</label>
                <input type="date" name="dataFim" id="dataFinal" class="form-control col-md-4" />
            </div>
            <input type="hidden" name="operacao" value="incluir">
            <button type="submit" class="btn btn-success">Salvar</button>
            <a href="" class="btn btn-danger">Voltar</a>
            
        </form>
    </body>
</html>
