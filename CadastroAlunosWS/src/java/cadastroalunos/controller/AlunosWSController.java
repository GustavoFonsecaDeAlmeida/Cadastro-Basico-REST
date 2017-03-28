/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.controller;

import cadastroalunos.dao.AlunoDAO;
import cadastroalunos.dao.AlunoDAOImpl;
import cadastroalunos.model.Aluno;
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
public class AlunosWSController {

  
    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> getAluno(@PathVariable("id") long id) {
        AlunoDAO aDAO = new AlunoDAOImpl();
        System.out.println("Recuperando aluno com ID " + id);
        Aluno aluno = aDAO.detalhar(id);
        if (aluno == null) {
            System.out.println("Aluno com ID " + id + " não encontrado");
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
    }

    @RequestMapping(value = "/aluno/", method = RequestMethod.POST)
    public ResponseEntity<Void> postAluno(@RequestBody Aluno aluno, UriComponentsBuilder ucBuilder) {
        AlunoDAO aDAO = new AlunoDAOImpl();
        System.out.println("Criando Aluno " + aluno.getNome());
        try {
            aDAO.salvar(aluno);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
