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
        <title>CadastroLivro</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Cadastrar Livro</h2>
            <form action="salvar-livro" method="post">
                <div style="visibility:hidden">
                    <label for="id">ID</label> <input type="text"
                                                      name="id" value="<c:out value="${livro.id}" />"
                                                      readonly="readonly" placeholder="ID" />
                </div>
                <div>
                    <form:errors path="livro.nome" cssStyle="color:red"/>
                </div>
                <div>
                    <label for="nome">Nome:</label> <input class="form-control" type="text"
                                                           name="nome" value="<c:out value="${livro.nome}" />"
                                                           placeholder="Digite o Nome" />
                </div>
                <div>
                    <form:errors path="livro.autor" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for="autor">Autor:</label> <input class="form-control" type="text"
                                                                 name="autor" value="<c:out value="${livro.autor}" />"
                                                                 placeholder="Digite o nome do Autor" />
                </div>
                <div>
                    <form:errors path="livro.editora" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for="curso">Editora:</label> <input class="form-control" type="text" name="editora"
                                                             value="<c:out value="${livro.editora}" />" placeholder="Digite a Editora" />
                </div>
                <div>    
                    <label for="curso">Ano:</label> <input class="form-control" type="text" name="ano"
                                                             value="<c:out value="${livro.ano}" />" placeholder="Digite o ano" />
                </div>
                <div>
                    <form:errors path="livro.ano" cssStyle="color:red"/>
                </div>
                <div>
                    <input class="btn btn-success" type="submit" value="Salvar" />
                </div>
            </form>
        </div>
    </form>
</body>
</html>