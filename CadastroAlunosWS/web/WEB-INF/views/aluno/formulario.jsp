<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              rel="stylesheet" type="text/css" />
        <title>Cadastrar Aluno</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Cadastrar Aluno</h2>
            <form action="salvar-aluno" method="post">
                <div style="visibility:hidden">
                    <label for="id">ID</label> <input type="text"
                                                      name="id" value="<c:out value="${aluno.id}" />"
                                                      readonly="readonly" placeholder="ID" />
                </div>
                <div>
                    <form:errors path="aluno.nome" cssStyle="color:red"/>
                </div>
                <div>
                    <label for="nome">Nome:</label> <input class="form-control" type="text"
                                                           name="nome" value="<c:out value="${aluno.nome}" />"
                                                           placeholder="Nome" />
                </div>
                <div>
                    <form:errors path="aluno.email" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for="email">E-mail:</label> <input class="form-control" type="text"
                                                                 name="email" value="<c:out value="${aluno.email}" />"
                                                                 placeholder="E-mail" />
                </div>
                <div>
                    <form:errors path="aluno.curso" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for="curso">Curso:</label> <input class="form-control" type="text" name="curso"
                                                             value="<c:out value="${aluno.curso}" />" placeholder="Curso" />
                </div>
                <div>
                    <input class="btn btn-success" type="submit" value="Salvar" />
                </div>
            </form>
        </div>
    </form>
</body>
</html>