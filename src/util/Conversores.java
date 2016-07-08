
package util;

import javax.swing.JOptionPane;

public class Conversores {
    
    public Double temperatura(String de,String para, Double entrada) throws Exception{
      if(de.equals(para)){
          throw new Exception("Unidades iguais!");
      }else{
        if(de.equals("°C")){
        
            if(para.equals("°F")){
                return 9*(entrada/5)+32;
            }else if(para.equals("K")){
                return entrada + 273;
            }else{
                throw new Exception("Valor informado incorretamente!");
            }
            
        }else if(de.equals("°F")){
        
            if(para.equals("°C")){
                return ((entrada-32)/9)*5;
            }else if(para.equals("K")){
                return ((entrada-32)/9)*5+273;
            }else{
                throw new Exception("Valor informado incorretamente!");
            }
        
        }else if(de.equals("K")){
        
            if(para.equals("°C")){
                return entrada-273;
            }else if(para.equals("°F")){
                return ((entrada-273)/5)*9+32;
            }else{
                throw new Exception("Valor informado incorretamente!");
            }
        
        }else{
        
            throw new Exception("Valor informado incorretamente!");
        
        } 
    
      }
    }
    
    public Double massa(String de,String para, Double entrada) throws Exception{
        if(de.equals(para)){
            throw new Exception("Unidades iguais!");
        }else{
            if(de.equals("g")){
                
                if(para.equals("Kg")){
                    
                    return entrada/1000;
                
                }else if(para.equals("cm³")){
                    
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada/dens;
  
                }else if(para.equals("L")){
                    
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada/(dens*1000);
                    
                }else if(para.equals("mL")){
                    
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada/dens;
                    
                }else{
                    throw new Exception("Valor informado incorretamente!");
                }
            
            }else if(de.equals("Kg")){
                
                if(para.equals("g")){
                    
                    return entrada*1000;
                    
                }else if(para.equals("cm³")){
                    
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return (entrada*1000)/dens;
                    
                }else if(para.equals("L")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return (entrada*1000)/(dens*1000);
                
                }else if(para.equals("mL")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return (entrada*1000)/dens;
                
                }else{
                
                    throw new Exception("Valor informado incorretamente!");
                
                }
                
            }else if(de.equals("cm³")){
                
                if(para.equals("g")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada*dens;
                    
                }else if(para.equals("Kg")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return (entrada*dens)/1000;
                
                }else if(para.equals("L")){
                
                    return entrada/1000;
                
                }else if(para.equals("mL")){
                
                    return entrada;
                
                }else{
                
                    throw new Exception("Valor informado incorretamente!");
                
                }
                
            }else if(de.equals("L")){
                
                if(para.equals("g")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada*1000*dens;
                    
                }else if(para.equals("Kg")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada*dens;
                
                }else if(para.equals("mL")){
                
                    return entrada*1000;
                
                }else if(para.equals("cm³")){
                
                    return entrada*1000;
                
                }else{
                
                    throw new Exception("Valor informado incorretamente!");
                
                }
                
            }else if(de.equals("mL")){
                
                if(para.equals("g")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return entrada*dens;
                
                }else if(para.equals("Kg")){
                
                    boolean con = true;
                    Double dens = null;
                    
                    while(con){
                        
                        String p = JOptionPane.showInputDialog(null,"Insira a densidade do material (em g/cm³).","Conversor de Massa",JOptionPane.QUESTION_MESSAGE);
                        
                        try{ 
                            dens = Double.parseDouble(p);
                            con = false;
                        }catch(Exception e){
                            int r  =  JOptionPane.showConfirmDialog(null, "Dado invalido.\nDeseja tentar novamente?","Conversor de Massa", JOptionPane.YES_NO_OPTION);    
                            if (r == JOptionPane.YES_OPTION) {
                                con = true;
                            }else{
                                con = false;
                                throw new Exception("Valor informado incorretamente!");
                            }
                        }
                    }
                    
                    return (entrada/1000)*dens;
                
                }else if(para.equals("L")){
                
                    return entrada/1000;
                
                }else if(para.equals("cm³")){
                
                    return entrada;
                
                }else{
                
                    throw new Exception("Valor informado incorretamente!");
                
                }
                
            }else{
                throw new Exception("Valor informado incorretamente!");
            }
        }
       
    }

    public Double energia(String de, String para, Double entrada) throws Exception{
       
        if(de.equals(para)){
           throw new Exception("Unidades iguais!");
       }else{
            
            if(de.equals("J")){
           
                if(para.equals("cal")){
                    return entrada*4.186;
                }else{
                    throw new Exception("Valor informado incorretamente!");
                }
       
            }else if(de.equals("cal")){
                
                if(para.equals("J")){
                    return entrada/4.186;
                }else{
                    throw new Exception("Valor informado incorretamente!");
                }
            
            }else{
       
                throw new Exception("Valor informado incorretamente!");
       
            } 
       }
    
    }
    
}
