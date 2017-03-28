package cadastroalunos.controller;

import cadastroalunos.dao.AlunoDAOImpl;
import cadastroalunos.model.Aluno;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunosController {

    @RequestMapping("novo-aluno")
    public String form() {
        return "aluno/formulario";
    }

    @RequestMapping("salvar-aluno")
    public String salvar(@Valid Aluno aluno, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "aluno/formulario";
        }
        
        AlunoDAOImpl dao = new AlunoDAOImpl();
        try{
            dao.salvar(aluno);
        } catch (Exception e){
            
        }
        
       
        
        return "forward:listar-aluno";
    }

   
   

    
    @RequestMapping("listar-aluno")
    public ModelAndView listar() {
        
        AlunoDAOImpl dao = new AlunoDAOImpl();
        
        List<Aluno> alunos = dao.listar();

        ModelAndView mv = new ModelAndView("aluno/lista");
        mv.addObject("alunos", alunos);
        return mv;
    }

  
    
    @RequestMapping("editar-aluno")
    public ModelAndView editar(long id) {
        AlunoDAOImpl dao = new AlunoDAOImpl();
        
        Aluno aluno = dao.detalhar(id);

        ModelAndView mv = new ModelAndView("aluno/formulario");
        mv.addObject("aluno", aluno);
        return mv;
    }
    
    @RequestMapping("excluir-aluno")
    public String excluir(long id) {
        AlunoDAOImpl dao = new AlunoDAOImpl();
       
        dao.excluir(id);
        return "forward:listar-aluno";
    }
}
