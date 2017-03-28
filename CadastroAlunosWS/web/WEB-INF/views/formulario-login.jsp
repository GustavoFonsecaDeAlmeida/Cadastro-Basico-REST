<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              rel="stylesheet" type="text/css" />
        <title>Login</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Login</h2>
            <form action="efetuarLogin" method="post">
                <div>
                    <label for="login">Login:</label> 
                    <input class="form-control" type="text" name="login"/>
                </div>
                <div>
                    <label for="senha">Senha:</label> 
                    <input class="form-control" type="password" name="senha"/>
                </div>
                <div>
                    <input class="btn btn-success" type="submit" value="Enviar" />
                </div>
            </form>
    </body>
</html>