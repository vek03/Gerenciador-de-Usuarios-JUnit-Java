package view;

import model.Usuario;
import controller.Controller;
import conexao.Conexao;

/**
 *
 * @author Grupo João Pedro, Julio, Maria, Mariane, Victor Roma e Victor Cardoso
 */
public class View {
    
    public static void main(String[] args) 
    {
        ///*
        Conexao conexao = new Conexao();        
        
        Controller control = new Controller(conexao);

        //C
        control.create(new Usuario(0, "Victor", "Rua 69", "Masculino", "@vek", "123"));
        
        //R
        Usuario user = control.read(1);
        System.out.println("---------\nExibindo Usuário: ");
        System.out.println("ID: " + user.getId());
        System.out.println("Nome: " + user.getNome());
        System.out.println("Endereço: " + user.getEndereco());
        System.out.println("Sexo: " + user.getSexo());
        System.out.println("Usuário: " + user.getUsuario());
        System.out.println("Senha: " + user.getSenha());
        
        //R
        control.list();
        
        //U
        control.update(new Usuario(1, "Julio", "Rua 69", "Masculino", "@juliao", "123"));
        
        //D
        //control.delete(1);
        
        conexao.desconecta();
        //*/
    }
    
}
