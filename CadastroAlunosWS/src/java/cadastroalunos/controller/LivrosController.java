package cadastroalunos.controller;

import cadastroalunos.dao.LivroDAOImpl;

import cadastroalunos.model.Livro;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivrosController {

    @RequestMapping("novo-livro")
    public String form() {
        return "livro/formulario";
    }

    @RequestMapping("salvar-livro")
    public String salvar(@Valid Livro livro, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "livro/formulario";
        }

        LivroDAOImpl dao = new LivroDAOImpl();
        try {
            dao.salvar(livro);
        } catch (Exception e) {

        }

        return "forward:listar-livro";
    }

    @RequestMapping("listar-livro")
    public ModelAndView listar() {

        LivroDAOImpl dao = new LivroDAOImpl();

        List<Livro> livro = dao.listar();

        ModelAndView mv = new ModelAndView("livro/lista");
        mv.addObject("livros", livro);
        return mv;
    }

    @RequestMapping("editar-livro")
    public ModelAndView editar(long id) {
        LivroDAOImpl dao = new LivroDAOImpl();

        Livro livro = dao.detalhar(id);

        ModelAndView mv = new ModelAndView("livro/formulario");
        mv.addObject("livro", livro);
        return mv;
    }

    @RequestMapping("excluir-livro")

    public String excluir(long id) {
        LivroDAOImpl dao = new LivroDAOImpl();
        dao.excluir(id);
        return "forward:listar-livro";
    }
}
