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
        <h2>Lista de Alunos</h2>
        <p>
            <a href="novo-aluno">Novo Aluno</a>
        </p>
        <div id="content" class="col-lg-8">
            <table class="table table_list">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Curso</th>
                        <th colspan="2">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alunos}" var="aluno">
                        <tr>
                            <td><c:out value="${aluno.id}" /></td>
                            <td><c:out value="${aluno.nome}" /></td>
                            <td><c:out value="${aluno.email}" /></td>
                            <td><c:out value="${aluno.curso}" /></td>
                            <td><a href="editar-aluno?id=<c:out value="${aluno.id }"/>">Editar</a></td>
                            <td><a href="excluir-aluno?id=<c:out value="${aluno.id}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>