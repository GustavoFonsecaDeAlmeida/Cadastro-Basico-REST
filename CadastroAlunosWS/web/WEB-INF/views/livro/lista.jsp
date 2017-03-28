<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              rel="stylesheet" type="text/css" />
        <title>Lista de Alunos</title>
        <style type="text/css">
            /*Definido cor das linhas pares*/
            .table_list tr:nth-child(even) {background: #FFFFFF}

            /*Definindo cor das Linhas ímpares*/
            .table_list tr:nth-child(odd) {background: #F5F5F5}       

        </style>
    </head>
    <body>
        <h2>Lista de Livros</h2>
        <p>
            <a href="novo-livro">Novo Livro</a>
        </p>
        <div id="content" class="col-lg-8">
            <table class="table table_list">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th colspan="2">Ano</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${livros}" var="livro">
                        <tr>
                            <td><c:out value="${livro.id}" /></td>
                            <td><c:out value="${livro.nome}" /></td>
                            <td><c:out value="${livro.autor}" /></td>
                            <td><c:out value="${livro.editora}" /></td>
                            <td><c:out value="${livro.ano}" /></td>
                            <td><a href="editar-livro?id=<c:out value="${livro.id }"/>">Editar</a></td>
                            <td><a href="excluir-livro?id=<c:out value="${livro.id}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>