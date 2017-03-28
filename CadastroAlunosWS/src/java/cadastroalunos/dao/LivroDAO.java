/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.dao;

import cadastroalunos.model.Livro;
import java.util.List;

public interface LivroDAO {
    public Livro salvar(Livro livro) throws Exception;
    
    public void excluir(Long id);
    
    public Livro detalhar(Long id);
    
    public List<Livro> listar();
}
