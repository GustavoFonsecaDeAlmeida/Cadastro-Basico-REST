/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.dao;

import cadastroalunos.model.Aluno;
import java.util.List;

public interface AlunoDAO {
    public Aluno salvar(Aluno aluno) throws Exception;
    
    public void excluir(Long id);
    
    public Aluno detalhar(Long id);
    
    public List<Aluno> listar();
}
