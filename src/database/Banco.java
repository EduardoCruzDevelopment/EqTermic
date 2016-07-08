
package database;
   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Banco {
    
    private static String URL = "jdbc:derby:data;user=root;password=admin";
    private Connection con;
    private static Banco banco;
    
    public Banco(){
        
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.con = DriverManager.getConnection(URL);
            System.out.println("Conexão com o banco de dados foi bem sucedida!");
        } catch (SQLException ex) {        
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se ao banco de dados!\nVerifique se o EqTermic já está aberto em outra janela.", "InternalSystem", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
        } catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se ao banco de dados!\n"+cnfe.getMessage(), "InternalSystem", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public static synchronized Connection abrirConexao(){
        
       if(banco==null){
           banco = new Banco();
       }
       return banco.con;
             
    }
        
}
