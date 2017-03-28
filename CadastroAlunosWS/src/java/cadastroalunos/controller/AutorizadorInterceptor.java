package cadastroalunos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object controller) throws Exception {

        String uri = request.getRequestURI();
        
        /* 
            Se o usuário tentar acessar o loginForm (abre o formulário de login)
            ou o efetuarLogin (envir o formulário), deixar passar mesmo não logado.
        */
        if (uri.endsWith("loginForm") || uri.endsWith("efetuarLogin") || uri.contains("/aluno/")) {
            return true;
        }

        /* 
            Caso contrário, só deixar passar se houver um usuarioLogado na sessão.
        */
        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }

        /*
            E então encaminhe para o formulário de login, se não puder passar.
        */
        response.sendRedirect("loginForm");
        return false;
    }
}
