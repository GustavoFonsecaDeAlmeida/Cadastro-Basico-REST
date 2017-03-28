/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.dao;

import cadastroalunos.model.Aluno;
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
public class AlunoDAOImpl implements AlunoDAO {

    private EntityManager em;

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("CadastroAlunosSpringPU");
        return factory.createEntityManager();
    }

    public AlunoDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }

    /*
        Salvar - Inserir ou Atualizar - um aluno
     */
    public Aluno salvar(Aluno aluno) throws Exception {
        try {
            em.getTransaction().begin();
            if (aluno.getId() == null) {
                //INSERT
                em.persist(aluno);
            } else //UPDATE se o aluno existe
            //pois pode ter sido excluído concorrentemente à nossa chamada
             if (!em.contains(aluno)) {
                    if (em.find(Aluno.class, aluno.getId()) == null) {
                        throw new Exception("Erro ao atualizar aluno.");
                    }
                    aluno = em.merge(aluno);
                }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return aluno;
    }

    /*
        Excluir um Aluno por seu ID
     */
    public void excluir(Long id) {
        Aluno aluno = em.find(Aluno.class, id);
        try {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /*
        Buscar um Aluno por seu ID
     */
    public Aluno detalhar(Long id) {
        Aluno aluno = null;
        try {
            aluno = em.find(Aluno.class, id);
        } finally {
            em.close();
        }

        return aluno;
    }

    /*
        Listar todos os Alunos
     */
    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        //Note que escrevemos Aluno e não aluno: o JPA usa entidades, não tabelas.
        //Além disso, selecionamos "a" de "Aluno a" e não "*" de "Aluno".
        Query query = em.createQuery("SELECT a FROM Aluno a");
        try {
            //Executamos a query, convertendo-a em uma lista de resultados no formato de lista de alunos.
            alunos = (List<Aluno>) query.getResultList();
        } finally {
            em.close();
        }
        
        return alunos;
    }
}
