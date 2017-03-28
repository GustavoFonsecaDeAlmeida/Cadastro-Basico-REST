/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroalunos.dao;

import cadastroalunos.model.Usuario;
import cadastroalunos.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class JdbcUsuarioDAOImpl implements JdbcUsuarioDAO {

    private Connection conn;

    public JdbcUsuarioDAOImpl() {
        conn = DBUtil.getConnection();
    }

    @Override
    public boolean autenticar(Usuario usuario) {
        boolean retorno = false;
        try {
            String query = "select login, senha from usuario where login='"+usuario.getLogin()+"'";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                Usuario armazenado = new Usuario();
                armazenado.setLogin(rs.getString("login"));
                armazenado.setSenha(rs.getString("senha"));
                if(armazenado.getSenha().equals(usuario.getSenha())){
                    retorno = true; 
                }
            }
            preparedStatement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
