package processors;

import entidades.Elemento;
import entidades.ItensEquilibrioTermico;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProcessEquilibrioTermico {
    
    private Integer precision;

    public ProcessEquilibrioTermico(Integer precision) {
        this.precision = precision;
    }

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
    
    private BigDecimal defCapTermic(String pIni,Elemento e, Double cap) throws Exception {

        if(pIni.equals("antF")){
            
            return new BigDecimal(cap/e.getcSolido());
            
        }else if(pIni.equals("onF")){
            
            throw new Exception("Impossível calcular a capacidade termica");
                    
        }else if(pIni.equals("antV")){
            
            return new BigDecimal(cap/e.getcLiquido());
            
        }else if(pIni.equals("onV")){
            
            throw new Exception("Impossível calcular a capacidade termica");
            
        }else if(pIni.equals("postV")){
            
            return new BigDecimal (cap/e.getcGasoso());
            
        }else{
            
            throw new Exception("Impossível calcular a capacidade termica");
            
        }
        
    }
    
    private BigDecimal qtEnergToChangeFase(ItensEquilibrioTermico ie) throws Exception{
        
        System.out.println("Analisando quantidade de energia necessaria para mudar para a fase mais proxima.\n");
        
        String p = position(ie.getTempIni(),ie.getElemento().getTempF(),ie.getElemento().getTempV());
        
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
            
            BigDecimal dt = new BigDecimal(ie.getElemento().getTempF()-ie.getTempIni());
            return (m.multiply(cs.multiply(dt)));//.add(clf.multiply(m));
            
        }else if(p.equals("onF")){
            
            return null;//clf.multiply(m);
            
        }else if(p.equals("antV")){
            
            System.out.println("Analise por média");
            
            Double med = (ie.getElemento().getTempF()+ie.getElemento().getTempV())/2;
            
            System.out.println("Média: "+med);
            System.out.println("Temperatura inicial relacionada a média:");
            
            if(ie.getTempIni() < med){
                System.out.println("Menor");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().getTempF()-ie.getTempIni());
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clfn)); 
                
            }else if(ie.getTempIni().equals(med)){
                
                System.out.println("Igual");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().getTempF()-ie.getTempIni()); 
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clvn));
                
            }else if(ie.getTempIni() > med){
                System.out.println("Maior");
                
                BigDecimal dt = new BigDecimal(ie.getElemento().getTempV()-ie.getTempIni());
                return (m.multiply(cl.multiply(dt)));//.add(m.multiply(clv));
                
            }else{
                System.out.println("Erro");
                throw new Exception("Valores informados incorretamente!");
            }
            
        }else if(p.equals("onV")){
            
            return m.multiply(clv);
            
        }else if(p.equals("postV")){
            
            BigDecimal dt = new BigDecimal(ie.getElemento().getTempV()-ie.getTempIni());
            
            return (m.multiply(cg.multiply(dt)));//.add(m.multiply(clvn));
            
        }else{
            throw new Exception("Valores informados incorretamente!");
        }
        
    }
    
    public BigDecimal calc(List<ItensEquilibrioTermico> corpo) throws Exception{
               
        List<eqNoFaseChange> listNoFaseChange = new ArrayList();
        List<eqComFaseChange> listComFaseChange = new ArrayList();
        
        for (ItensEquilibrioTermico iet : corpo) {

            //pegando valores
            
            Elemento e = iet.getElemento();
            BigDecimal cs = new BigDecimal(e.getcSolido());
            BigDecimal cl = new BigDecimal(e.getcLiquido());
            BigDecimal cg = new BigDecimal(e.getcGasoso());
            BigDecimal clf = new BigDecimal(e.getlFusao());
            BigDecimal clv = new BigDecimal(e.getlVapor());
            BigDecimal clfn = new BigDecimal(e.getlFusao()*-1);
            BigDecimal clvn = new BigDecimal(e.getlVapor()*-1);
            BigDecimal tempIni = new BigDecimal(iet.getTempIni());
            BigDecimal m = new BigDecimal(0);
            String pIni = position(tempIni.doubleValue(),e.getTempF(),e.getTempV());

            if (iet.getCapTermic() != 0 && iet.getMassa() == 0.d) {

                System.out.println("Capacidade termica informada!");
                
                try{
   
                    m = defCapTermic(pIni,e,iet.getCapTermic());
                    
                }catch(Exception ex){
                    
                    JOptionPane.showMessageDialog(null, "InternalSystem","Não é possivel calcular a capacidade termica de elementos em mudança de fase!"
                                                  ,JOptionPane.ERROR_MESSAGE);
                    
                    m = new BigDecimal(0);
                    cs = new BigDecimal(0);
                    cl = new BigDecimal(0);
                    cg = new BigDecimal(0);
                    clf = new BigDecimal(0);
                    clv = new BigDecimal(0);
                    clfn = new BigDecimal(0);
                    clvn = new BigDecimal(0);
                    tempIni = new BigDecimal(0);
                    
                }

            } else {

                m = new BigDecimal(iet.getMassa());
     
            }

            //pegando valores --- end
            
            if(e.getcLiquido().equals(1.d)){
                //é agua
                eqComFaseChange eq = new eqComFaseChange();
                eq.m = m;
                eq.tempIni = tempIni;
                eq.e = e;
                listComFaseChange.add(eq);
                
            }else{
                //nao é agua
                
                eqNoFaseChange eq = new eqNoFaseChange();
                
                if(pIni.equals("antF")){
                    
                    eq.c = new BigDecimal(e.getcSolido());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    
                }else if(pIni.equals("onF")){
                    
                    throw new Exception("material diferente de agua com mudanca de fase");
                    
                }else if(pIni.equals("antV")){
                    
                    eq.c = new BigDecimal(e.getcLiquido());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    
                }else if(pIni.equals("onV")){
                    
                    throw new Exception("material diferente de agua com mudanca de fase");
                
                }else if(pIni.equals("postV")){
                    
                    eq.c = new BigDecimal(e.getcGasoso());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    
                }else{
                    
                    throw new Exception("erro geral formacao de equacao diferente de agua");
                    
                }
                        
            }
        
        }
        
        BigDecimal co1 = new BigDecimal(0);
        BigDecimal co2 = new BigDecimal(0);
        
        if(listComFaseChange.isEmpty()){
            
            for (eqNoFaseChange eq : listNoFaseChange) {
                
                co1 = co1.add(eq.m.multiply(eq.c.multiply(eq.tempIni)));
                co2 = co2.add(eq.m.multiply(eq.c));

            }
            
            return co1.divide(co2, precision, RoundingMode.UP);
            
        }else{
           
            if(listComFaseChange.size()>1){
                //selecionar agua com menor temperatura, e definir minimos para definir a qt de energina total cedida
               throw new Exception("Exemplo nao tratado ainda");

            }else{
                
                eqComFaseChange eq = listComFaseChange.get(0);
                
                Elemento e = eq.e;
                BigDecimal tempIni = eq.tempIni;
                BigDecimal m = eq.m;
                BigDecimal tempF = new BigDecimal (e.getTempF());
                BigDecimal tempV = new BigDecimal (e.getTempV());
                BigDecimal cs = new BigDecimal(e.getcSolido());
                BigDecimal cl = new BigDecimal(e.getcLiquido());
                BigDecimal cg = new BigDecimal(e.getcGasoso());
                BigDecimal clf = new BigDecimal(e.getlFusao());
                BigDecimal clv = new BigDecimal(e.getlVapor());
                BigDecimal clfn = new BigDecimal(e.getlFusao()*-1);
                BigDecimal clvn = new BigDecimal(e.getlVapor()*-1);
                
                //analisando energia necessaria para mudar de fase
                BigDecimal energToChange_s_f = new BigDecimal(0);
                BigDecimal energToChange_f = new BigDecimal(0);
                BigDecimal energToChange_f_l = new BigDecimal(0);
                BigDecimal energToChange_v = new BigDecimal(0);
                
                energToChange_s_f = m.multiply(cs.multiply(tempF.subtract(tempIni)));
                    
                if(tempIni.doubleValue() >= tempF.doubleValue()){
                    energToChange_f = m.multiply(clfn);
                }else{
                    energToChange_f = m.multiply(clf);
                }
                        
                energToChange_s_f = m.multiply(cl.multiply(tempV.subtract(tempF)));
                    
                if(tempIni.doubleValue() >= tempV.doubleValue()){
                    energToChange_v = m.multiply(clvn);
                }else{
                    energToChange_v = m.multiply(clv);
                }
                //fim da analisa de energia necessaria para a mudanca de fase

                //identificar a energia cedida ao corpo
                
                String p = position(tempIni.doubleValue(),tempF.doubleValue(),tempV.doubleValue());
                
                BigDecimal energForChange = new BigDecimal(0);

                if(p.equals("antF")){
                    
                    for (eqNoFaseChange eqNoChange : listNoFaseChange) {
                       
                        energForChange = energForChange.add(
                                eqNoChange.m.multiply(
                                        eqNoChange.c.multiply(
                                                tempF.subtract(
                                                        eqNoChange.tempIni))));
                        
                    }
                    
                    if(energForChange.compareTo(energToChange_s_f)==1){
                        
                        energToChange_f.add(energToChange_s_f);
                        
                        if(energForChange.compareTo(energToChange_f) == 1){
                            //caso a energia seja suficiente para mudar a faze
                        }else{
                            //energia insuficiente para mudar a fase
                        }
                        
                    }else{
                        //nao tem mudança de fase
                    }
                    
                }else if(p.equals("onF")){
                    
                    
                    
                }else if(p.equals("antV")){
                    
                }else if(p.equals("onV")){
                    
                }else if(p.equals("postV")){
                    
                }else{
                    
                }
                
                return null;
                
            }
        }
    }
    
    private class eqNoFaseChange{
        private Elemento e;
        private BigDecimal m;
        private BigDecimal c;
        private BigDecimal tempIni;
    }
    
    private class eqComFaseChange{
        private Elemento e;
        private BigDecimal m;
        private BigDecimal tempIni;
    }
    
}