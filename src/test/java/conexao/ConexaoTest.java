package conexao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Grupo João Pedro, Julio, Maria, Mariane, Victor Roma e Victor Cardoso
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }

    /**
     * Test of conecta method, of class Conexao.
     */
    @Test
    public void testConecta() {
        System.out.println("Testando conecta");
        Conexao instance = new Conexao();
        boolean expResult = true;
        boolean result = instance.conecta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executaSQL method, of class Conexao.
     */
    @Test
    public void testExecutaSQL() {
        System.out.println("Testando executaSQL");
        String sql = "SELECT * FROM usuarios";
        Conexao instance = new Conexao();
        instance.conecta();
        instance.executaSQL(sql);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executaUpdate method, of class Conexao.
     */
    @Test
    public void testExecutaUpdate() {
        System.out.println("Testando executaUpdate");
        String sql = "INSERT INTO `usuarios`(`nome`, `sexo`, `endereco`, `usuario`, `senha`) VALUES ('Victor',1,'Rua 10','victor12','123')";
        Conexao instance = new Conexao();
        int expResult = 1;
        instance.conecta();
        int result = instance.executaUpdate(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of desconecta method, of class Conexao.
     */
    @Test
    public void testDesconecta() {
        System.out.println("Testando desconecta");
        Conexao instance = new Conexao();
        instance.conecta();
        instance.desconecta();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
