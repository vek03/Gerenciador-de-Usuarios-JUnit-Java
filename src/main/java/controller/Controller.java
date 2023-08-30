package controller;

import conexao.Conexao;
import model.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo João Pedro, Julio, Maria, Mariane, Victor Roma e Victor Cardoso 
 */
public class Controller {
    
    Conexao conexao;

    public Controller(Conexao conexao) {
        this.conexao = conexao;
        this.conexao.conecta();
    }
    
    public void list(){
        try{
            String query = "SELECT * FROM usuarios";
            
            conexao.executaSQL(query);
            if(conexao.resultset.next()){
                conexao.resultset.beforeFirst();
                System.out.println("---------\nListando Usuários: ");
                while(conexao.resultset.next()){
                    Usuario user = new Usuario(conexao.resultset.getInt("id"),
                                               conexao.resultset.getString("nome"),
                                               conexao.resultset.getString("endereco"),
                                               conexao.resultset.getString("sexo"),
                                               conexao.resultset.getString("usuario"),
                                               conexao.resultset.getString("senha"));
                    
                    System.out.println("ID: " + user.getId() + " - Nome: " + user.getNome());
                }            
            }else{
                JOptionPane.showMessageDialog(null, "\n Sem registros de usuários!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.resultset.close();
            conexao.statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public void create(Usuario user){
        try{
            String query = "INSERT INTO usuarios (nome, sexo, endereco, usuario, senha) VALUES ("
                            + "'"+ user.getNome() + "',"
                            + "'"+ user.getSexo() + "',"
                            + "'"+ user.getEndereco() + "',"
                            + "'"+ user.getUsuario() + "',"
                            + "'"+ user.getSenha() + "');";
            
            int result = conexao.executaUpdate(query);
            
            if(result >= 1){
                JOptionPane.showMessageDialog(null, "\n Usuário inserido!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "\n Falha ao inserir usuário! :\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public Usuario read(int id){
        try{
            String query = "SELECT * FROM usuarios WHERE id = " + id + ";";
            
            conexao.executaSQL(query);
            if(conexao.resultset.first()){
                Usuario user = new Usuario(conexao.resultset.getInt("id"),
                                           conexao.resultset.getString("nome"),
                                           conexao.resultset.getString("endereco"),
                                           conexao.resultset.getString("sexo"),
                                           conexao.resultset.getString("usuario"),
                                           conexao.resultset.getString("senha"));
                conexao.resultset.close();
                conexao.statement.close();
                return user;
            }else{
                JOptionPane.showMessageDialog(null, "\n Nenhum registro com esse ID!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                conexao.resultset.close();
                conexao.statement.close();
                return new Usuario(0, "", "", "", "", "");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
            return new Usuario(0, "", "", "", "", "");
        }
    }
    
    public void update(Usuario user){
        try{
            String query = "UPDATE usuarios SET "
                            + "nome = '" + user.getNome() + "'," 
                            + "sexo = '" + user.getSexo() + "'," 
                            + "endereco = '" + user.getEndereco() + "'," 
                            + "usuario = '" + user.getUsuario() + "'," 
                            + "senha = '" + user.getSenha() + "'"
                            + " WHERE id = " + user.getId() ;
            
            int result = conexao.executaUpdate(query);      
            if(result >= 1){
                JOptionPane.showMessageDialog(null, "\n Usuário atualizado!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "\n Falha ao atualizar usuário!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void delete(int id){
        try{
            String query = "DELETE FROM usuarios WHERE id = " + id + ";" ;
            
            int result = conexao.executaUpdate(query);        
            if(result >= 1){
                JOptionPane.showMessageDialog(null, "\n Usuário deletado!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "\n Falha ao deletar usuário!\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            conexao.statement.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }    
}
