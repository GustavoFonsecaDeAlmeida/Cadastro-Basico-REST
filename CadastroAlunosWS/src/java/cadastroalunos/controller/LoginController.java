package cadastroalunos.controller;

import cadastroalunos.dao.JdbcUsuarioDAOImpl;
import cadastroalunos.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"loginForm", "/"})
    public String loginForm() {
        return "formulario-login";
    }

    @RequestMapping("efetuarLogin")
    public String efetuarLogin(Usuario usuario, HttpSession session) {
        if (usuario.getLogin().equals("gustavo") && usuario.getSenha().equals("gustavo")) {
        //if (new JdbcUsuarioDAOImpl().autenticar(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "menu";
        }
        return "redirect:loginForm";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
}
