package processors;

import entidades.ItensEt;
import java.math.BigDecimal;
import java.util.List;

public class ProcessEqTermic {
    
    public Integer precision;
    
    private String position(Double tmp, Double tF, Double tV) throws Exception {

        System.out.println("Classificando...");

        if (tmp <= tF) {

            if (tmp.equals(tF)) {

                System.out.println("onF");
                return "onF";

            } else {

                System.out.println("antF");
                return "antF";

            }

        } else {

            if (tmp <= tV) {

                if (tmp.equals(tV)) {

                    System.out.println("onV");
                    return "onV";

                } else {

                    System.out.println("antV");
                    return "antV";

                }

            } else {

                if (tmp > tV) {

                    System.out.println("postV");
                    return "postV";

                } else {

                    System.err.println("Erro!");
                    throw new Exception("Valores informados incorretamente!");

                }

            }

        }

    }
    
    private BigDecimal qtEnergToChangeFase(ItensEt ie) throws Exception{
        
        System.out.println("Analisando quantidade de energia necessaria para mudar para a fase mais proxima.\n");
        
        String p = position(ie.getTempIni(),ie.getElemento().gettF(),ie.getElemento().gettV());
        
        System.out.println("Posição: "+p);
        
        BigDecimal m = new BigDecimal(ie.getMassa()),
                   cs = new BigDecimal(ie.getElemento().getcSolido()),
                   cl = new BigDecimal(ie.getElemento().getcLiquido()),
                   cg = new BigDecimal(ie.getElemento().getcGasoso()),
                   clf = new BigDecimal(ie.getElemento().getlFusao()),
                   clv = new BigDecimal(ie.getElemento().getlVapor()),
                   clfn = new BigDecimal(ie.getElemento().getlFusao()*-1),
                   clvn = new BigDecimal(ie.getElemento().getlVapor()*-1);
        
        if(p.equals("antF")){
            
            BigDecimal dt = new BigDecimal(ie.getElemento().gettF()-ie.getTempIni());
            return (m.multiply(cs.multiply(dt)));//.add(clf.multiply(m));
            
        }else if(p.equals("onF")){
            
            return null;//clf.multiply(m);
            
        }else if(p.equals("antV")){
            
            System.out.println("Analise por média");
            
            Double med = (ie.getElemento().gettF()+ie.getElemento().gettV())/2;
            
            System.out.println("Média: "+med);
            System.out.println("Temperatura inicial relacionada a média:");
            
            if(ie.getTempIni() < med){
                System.out.println("Menor");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().gettF()-ie.getTempIni());
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clfn)); 
                
            }else if(ie.getTempIni().equals(med)){
                
                System.out.println("Igual");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().gettF()-ie.getTempIni()); 
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clvn));
                
            }else if(ie.getTempIni() > med){
                System.out.println("Maior");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().gettV()-ie.getTempIni());
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clv));
                
            }else{
                System.out.println("Erro");
                throw new Exception("Valores informados incorretamente!");
            }
            
        }else if(p.equals("onV")){
            
            return m.multiply(clv);
            
        }else if(p.equals("postV")){
            
            BigDecimal dt = new BigDecimal(ie.getElemento().gettV()-ie.getTempIni());
            
            return (m.multiply(cg.multiply(dt)));//.add(m.multiply(clvn));
            
        }else{
            throw new Exception("Valores informados incorretamente!");
        }
        
    }
    
    public void metodosemnome(List<ItensEt> corpo){
        
        for (ItensEt ie : corpo){
            
            System.out.println("Corpo Referente: "+ie.getElemento().getNome()+"/n");
            
            BigDecimal ced = new BigDecimal(0);
            
            for (ItensEt iec : corpo){
                
                if(ie!=iec){
    
                    
                
                }
                
            }
            
        }
        
    }
   
    public void teste(){
        
    }
    
}