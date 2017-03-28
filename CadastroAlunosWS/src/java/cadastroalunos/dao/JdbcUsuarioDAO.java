package cadastroalunos.dao;

import cadastroalunos.model.Usuario;

public interface JdbcUsuarioDAO {

    public boolean autenticar(Usuario usuario);
}
