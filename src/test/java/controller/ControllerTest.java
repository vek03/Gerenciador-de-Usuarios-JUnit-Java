package controller;

import conexao.Conexao;
import model.Usuario;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Grupo João Pedro, Julio, Maria, Mariane, Victor Roma e Victor Cardoso
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
  
    /**
     * Test of list method, of class Controller.
     */
    @Test
    public void testList() {
        System.out.println("Testando list");
        Conexao conn = new Conexao();
        Controller instance = new Controller(conn);
        instance.list();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Controller.
     */
    @Test
    public void testCreate() {
        System.out.println("Testando create");
        Usuario user = new Usuario(0, "Victor", "Rua 69", "Masculino", "@vek", "123");
        Conexao conn = new Conexao();
        Controller instance = new Controller(conn);
        instance.create(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Controller.
     */
    @Test
    public void testRead() {
        System.out.println("Testando read");
        int id = 1;
        Conexao conn = new Conexao();
        Controller instance = new Controller(conn);
        Usuario user = instance.read(id);
        System.out.println("---------\nExibindo Usuário: ");
        System.out.println("ID: " + user.getId());
        System.out.println("Nome: " + user.getNome());
        System.out.println("Endereço: " + user.getEndereco());
        System.out.println("Sexo: " + user.getSexo());
        System.out.println("Usuário: " + user.getUsuario());
        System.out.println("Senha: " + user.getSenha());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Controller.
     */
    @Test
    public void testUpdate() {
        System.out.println("Testando update");
        Usuario user = new Usuario(1, "Julio", "Rua 69", "Masculino", "@juliao", "123");
        Conexao conn = new Conexao();
        Controller instance = new Controller(conn);
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Controller.
     */
    @Test
    public void testDelete() {
        System.out.println("Testando delete");
        int id = 1;
        Conexao conn = new Conexao();
        Controller instance = new Controller(conn);
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
