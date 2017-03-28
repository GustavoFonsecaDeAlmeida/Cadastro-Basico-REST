/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.dao;

import cadastroalunos.model.Livro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class LivroDAOImpl implements LivroDAO {

    private EntityManager em;

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("CadastroAlunosSpringPU");
        return factory.createEntityManager();
    }

    public LivroDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }

    /*
        Salvar - Inserir ou Atualizar - um aluno
     */
    public Livro salvar(Livro livro) throws Exception {
        try {
            em.getTransaction().begin();
            if (livro.getId() == null) {
                //INSERT
                em.persist(livro);
            } else //UPDATE se o aluno existe
            //pois pode ter sido excluído concorrentemente à nossa chamada
             if (!em.contains(livro)) {
                    if (em.find(Livro.class, livro.getId()) == null) {
                        throw new Exception("Erro ao atualizar Livro.");
                    }
                    livro = em.merge(livro);
                }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return livro;
    }

    /*
        Excluir um Aluno por seu ID
     */
    public void excluir(Long id) {
        Livro livro = em.find(Livro.class, id);
        try {
            em.getTransaction().begin();
            em.remove(livro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /*
        Buscar um Aluno por seu ID
     */
    public Livro detalhar(Long id) {
        Livro livro = null;
        try {
            livro = em.find(Livro.class, id);
        } finally {
            em.close();
        }

        return livro;
    }

    /*
        Listar todos os Alunos
     */
    public List<Livro> listar() {
        List<Livro> livro = new ArrayList<Livro>();
        //Note que escrevemos Aluno e não aluno: o JPA usa entidades, não tabelas.
        //Além disso, selecionamos "a" de "Aluno a" e não "*" de "Aluno".
        Query query = em.createQuery("SELECT a FROM Livro a");
        try {
            //Executamos a query, convertendo-a em uma lista de resultados no formato de lista de alunos.
            livro = (List<Livro>) query.getResultList();
        } finally {
            em.close();
        }
        
        return livro;
    }
}
