
package database;

import entidades.Elemento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ElementsDao {
    
    private Connection con;

    public ElementsDao() {
      this.con = Banco.abrirConexao();
    }
    
    public void salvar(Elemento e) throws SQLException{

      Statement stm = con.createStatement();
      
      stm.executeUpdate("insert into APP.elements (nome,cSolido,cLiquido,cGasoso,lFusao,lVapor,tF,tV) values("+"'"+e.getNome()+"',"+e.getcSolido()+","
                        +e.getcLiquido()+","+e.getcGasoso()+","+e.getlFusao()+","+e.getlVapor()+","+e.getTempF()+","+e.getTempV()+")");
      
    }
    
    public List<Elemento> listar() throws SQLException{
   
      List<Elemento> lista =  new ArrayList();
      
      String sql = "SELECT * FROM APP.elements";
       
      PreparedStatement pst = con.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
       
      while(rs.next()){
          Elemento e = new Elemento();
          e.setId(rs.getInt("id"));
          e.setNome(rs.getString("nome"));
          e.setcSolido(rs.getDouble("cSolido"));
          e.setcLiquido(rs.getDouble("cLiquido"));
          e.setcGasoso(rs.getDouble("cGasoso"));
          e.setlFusao(rs.getDouble("lFusao"));
          e.setlVapor(rs.getDouble("lVapor"));
          e.setTempF(rs.getDouble("tF"));
          e.setTempV(rs.getDouble("tV"));
          lista.add(e);
      }
      
      return lista;
    
    }
    
    public List<Elemento> pesquisar(String termo) throws SQLException{
      
      List<Elemento> lista = new ArrayList();
      String sql = "select * from APP.elements "+"where nome like('%"+termo+"%')";
      PreparedStatement pst = con.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      
      while(rs.next()){
          Elemento e = new Elemento();
          e.setId(rs.getInt("id"));
          e.setNome(rs.getString("nome"));
          e.setcSolido(rs.getDouble("cSolido"));
          e.setcLiquido(rs.getDouble("cLiquido"));
          e.setcGasoso(rs.getDouble("cGasoso"));
          e.setlFusao(rs.getDouble("lFusao"));
          e.setlVapor(rs.getDouble("lVapor"));
          e.setTempF(rs.getDouble("tF"));
          e.setTempV(rs.getDouble("tV"));
          lista.add(e);
      }
      
      return lista;
    
    }
    
    public void deletar(int id) throws SQLException{
        
        Statement stm = con.createStatement();
        stm.executeUpdate("delete from APP.elements where id = "+id);
    
   }

}
