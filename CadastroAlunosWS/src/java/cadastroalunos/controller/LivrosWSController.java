/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.controller;
import cadastroalunos.dao.LivroDAO;
import cadastroalunos.dao.LivroDAOImpl;
import cadastroalunos.model.Livro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Gustavo
 */
@RestController
public class LivrosWSController {

   
    @RequestMapping(value = "/livro/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Livro> getAluno(@PathVariable("id") long id) {
        LivroDAO aDAO = new LivroDAOImpl();
        System.out.println("Recuperando aluno com ID " + id);
        Livro livro = aDAO.detalhar(id);
        if (livro == null) {
            System.out.println("Aluno com ID " + id + " não encontrado");
            return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Livro>(livro, HttpStatus.OK);
    }

    @RequestMapping(value = "/livro/", method = RequestMethod.POST)
    public ResponseEntity<Void> postAluno(@RequestBody Livro livro, UriComponentsBuilder ucBuilder) {
        LivroDAO aDAO = new LivroDAOImpl();
        System.out.println("Criando Livro " + livro.getNome());
        try {
            aDAO.salvar(livro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
