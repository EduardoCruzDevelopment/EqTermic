
package util;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public final class JtextFieldNumbers extends JTextField {
    
    private int maximoCaracteres=-1;// definição de -1, como valor normal de um textfield sem limite de caracters
    
    public JtextFieldNumbers() { 
      super();
      addKeyListener(new java.awt.event.KeyAdapter(){
          @Override
          public void keyTyped(java.awt.event.KeyEvent evt){
              
              jTextFieldKeyTyped(evt);
              
          }
      });    
            
    }
    
    private void jTextFieldKeyTyped(KeyEvent evt){
    
        String caracteres="0987654321.-";//Caracteres que serão aceitos
        if(!caracteres.contains(evt.getKeyChar()+"")){//se o caracter que gerou o evento estiver não acina essa propriedade
        
            evt.consume();
            
        }
        
        if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!= -1)){//Para saber se a quantidade maxima de caracteres foi exedida
            
            evt.consume(); 
            setText(getText().substring(0,getMaximoCaracteres()));
            
        }
        
        
        
    }
    
    public Integer getMaximoCaracteres(){
        return maximoCaracteres;
    }
    
    public void setMaximoCaracteres(int maximoCaracteres){
        this.maximoCaracteres = maximoCaracteres;
    }
}
