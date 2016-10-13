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
        System.out.println("Iniciando ProecessEquilibrioTermico --- precisao:"+this.precision);
    }

    private String position(Double tmp, Double tF, Double tV) throws Exception {
        System.out.println("Iniciando position");
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

        System.out.println("Iniciando defCapTermic --- Descobrindo massa a partir da capacidade termica");
        
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
        
        System.out.println("Iniciando calculo geral...");
        
        List<eqNoFaseChange> listNoFaseChange = new ArrayList();
        List<eqComFaseChange> listComFaseChange = new ArrayList();
        
        System.out.println("Iniciando classificacao e separacao...");
        for (ItensEquilibrioTermico iet : corpo) {
            
            //pegando valores
            System.out.println("Pegando valores");
            
            Elemento e = iet.getElemento();
            System.out.println("Elemento:"+e.getNome());
            
            BigDecimal cs = new BigDecimal(e.getcSolido());
            BigDecimal cl = new BigDecimal(e.getcLiquido());
            BigDecimal cg = new BigDecimal(e.getcGasoso());
            BigDecimal clf = new BigDecimal(e.getlFusao());
            BigDecimal clv = new BigDecimal(e.getlVapor());
            BigDecimal clfn = new BigDecimal(e.getlFusao()*-1);
            BigDecimal clvn = new BigDecimal(e.getlVapor()*-1);
            
            
            BigDecimal tempIni = new BigDecimal(iet.getTempIni());
            System.out.println("Temperatura inicial: "+tempIni.toString());
            
            BigDecimal m = new BigDecimal(0);
            String pIni = position(tempIni.doubleValue(),e.getTempF(),e.getTempV());
            System.out.println("Position inicial:"+pIni);
            System.out.println("Desvendando a massa...");
            
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

            System.out.println("Massa: "+m.toString());
            System.out.println("Fim da captura de valores\n");
            //pegando valores --- end
            
            System.out.println("Iniciando classifica para lista...");
            if(e.getcLiquido().equals(1.d)){
                //é agua
                System.out.println("Agua foi detectada");
                eqComFaseChange eq = new eqComFaseChange();
                eq.m = m;
                eq.tempIni = tempIni;
                eq.e = e;
                listComFaseChange.add(eq);
                
            }else{
                //nao é agua
                System.out.println("Elemento diferente de agua detectado");
                eqNoFaseChange eq = new eqNoFaseChange();
                
                if(pIni.equals("antF")){
                    System.out.println("Fase solida");
                    eq.c = new BigDecimal(e.getcSolido());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    System.out.println("Elemento adicionado a lista\n\n");
                    
                }else if(pIni.equals("onF")){
                    System.out.println("Erro --- Elemento em mufança de fase");
                    throw new Exception("material diferente de agua com mudanca de fase");
                    
                }else if(pIni.equals("antV")){
                    System.out.println("fase liquida");
                    eq.c = new BigDecimal(e.getcLiquido());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    System.out.println("Elemento adicionado a lista\n\n");
                }else if(pIni.equals("onV")){
                    System.out.println("Erro --- Elemento em mudança de fase");
                    throw new Exception("material diferente de agua com mudanca de fase");
                
                }else if(pIni.equals("postV")){
                    System.out.println("fase gasosa");
                    eq.c = new BigDecimal(e.getcGasoso());
                    eq.tempIni = tempIni;
                    eq.m = m;
                    eq.e = e;
                    listNoFaseChange.add(eq);
                    System.out.println("Elemento adicionado a lista\n\n");
                }else{
                    
                    System.out.println("Erro de classifcacao");
                    throw new Exception("erro geral formacao de equacao diferente de agua");
                    
                }
                        
            }
        
        }
        
        System.out.println("Fim da separa de listas...");
        //fim da classificacao das listas
        
        System.out.println("Iniciando calculo");
        
        //equacao principal
        BigDecimal co1 = new BigDecimal(0);
        BigDecimal co2 = new BigDecimal(0);
        BigDecimal f = new BigDecimal(0);
        //equacao principal
        
        if(listComFaseChange.isEmpty()){ 
            System.out.println("Nao detectado a existencia de agua no sistema...");
            
            System.out.println("Executando calculo de apenas duas equacoes");
            for (eqNoFaseChange eq : listNoFaseChange) {
                
                co1 = co1.add(eq.m.multiply(eq.c.multiply(eq.tempIni)));
                co2 = co2.add(eq.m.multiply(eq.c));

            }
            
            System.out.println("Retornando resultado...\n\n");
            return co1.divide(co2, precision, RoundingMode.UP);
            
        }else{
           
            System.out.println("Detectada a existencia de agua no sistema");
            
            if(listComFaseChange.size()>1){
                //selecionar agua com menor temperatura, e definir minimos para definir a qt de energina total cedida
                System.out.println("Mais de uma agua identficada");
                throw new Exception("Exemplo nao tratado ainda");

            }else{
                
                eqComFaseChange eq = listComFaseChange.get(1);
                Elemento e = eq.e;
                BigDecimal tempIni = eq.tempIni;
                BigDecimal m = eq.m;
                BigDecimal cs = new BigDecimal(e.getcSolido());
                BigDecimal cl = new BigDecimal(e.getcLiquido());
                BigDecimal cv = new BigDecimal(e.getcSolido());
                BigDecimal clf = new BigDecimal(e.getlFusao());
                BigDecimal clfn = new BigDecimal(e.getlFusao()*-1);
                BigDecimal clv = new BigDecimal(e.getlVapor());
                BigDecimal clvn = new BigDecimal(e.getlVapor()*-1);
                BigDecimal tempF = new BigDecimal(e.getTempF());
                BigDecimal tempV = new BigDecimal(e.getTempV());
                
                String p = position(tempIni.doubleValue(),e.getTempF(),e.getTempV());
                
                //estudo de fases...
                

                if(p.equals("antF")){
                    
                    BigDecimal energForFusion = new BigDecimal(0);
                    BigDecimal energForVaporate = new BigDecimal(0);
                    BigDecimal energCedida_f = new BigDecimal(0);
                    BigDecimal energCedida_v = new BigDecimal(0);
                    BigDecimal mid = new BigDecimal(0);
                    
                    energForFusion = m.multiply(cs.multiply(tempF.subtract(tempIni))).add(m.multiply(clf)); //valor positivo
                    energForVaporate = m.multiply(cl.multiply(tempV.subtract(tempF))).add(m.multiply(clv)); //valor positivo
                    
                    energCedida_f = qtEnergiaCedida(listNoFaseChange,tempF); //verificar se esse valor é + ou - 
                    energCedida_v = qtEnergiaCedida(listNoFaseChange,tempV);
                    mid = energForFusion.add(energCedida_f);//se maior que 0 muda de fase, se menor, nao muda
                    
                    if(mid.doubleValue()==0){
                        //tem energia para passar da mudanca de fase
                        
                        co1 = co1.add(m.multiply(cs.multiply(tempIni)));
                        co2 = co2.add(m.multiply(cs));
                        f = f.add(m.multiply(clf));//adicionando mudanca de fase a equacao geral
                         
                    }else if(mid.doubleValue()<=0){
                    
                        co1 = co1.add(m.multiply(cs.multiply(tempIni)));//adicionando fase solida
                        co2 = co2.add(m.multiply(cs));//adicionando fase solida
                        f = f.add(m.multiply(clf));//adicionando mudanca de fase a equacao geral
                        
                        co1 = co1.add(m.multiply(cl.multiply(tempF)));//adicionando fase liquida
                        co2 = co2.add(m.multiply(cl));//adicionando fase liquida
                        
                        //iniciando alanise da vaporizacao
                        mid = energForVaporate.add(energCedida_v);
                        
                        if(mid.doubleValue()<=0){   
                            //teve energia suficiente para passar da vaporizacao
                          
                            f = f.add(m.multiply(clv));//adicionando mudanca de fase a equacao geral
                            co1 = co1.add(m.multiply(cv.multiply(tempV)));//adicionando fase gasosa
                            co2 = co2.add(m.multiply(cv));//adicionando fase gasosa
                        
                        }   
                    
                    }else{
                        
                        co1 = co1.add(m.multiply(cs.multiply(tempIni)));
                        co2 = co2.add(m.multiply(cs));
                        
                    }
                    
                }else if(p.equals("onF")){
                    
                    throw new Exception("intervalo indeterminado por temperatura");
                                        
                }else if(p.equals("antV")){
                    
                    
                    //falta aquiiiii
                    
                }else if(p.equals("onV")){
                    
                    throw new Exception("intervalo indeterminado por temperatura");
                    
                }else if(p.equals("postV")){
                    
                    BigDecimal energForSolid = new BigDecimal(0);
                    BigDecimal energForLiquid = new BigDecimal(0);
                    BigDecimal energCedida_f = new BigDecimal(0);
                    BigDecimal energCedida_v = new BigDecimal(0);
                    BigDecimal mid = new BigDecimal(0);
                    
                    energForLiquid = m.multiply(cv.multiply(tempV.subtract(tempIni))).add(m.multiply(clvn)); //valor negativo
                    energForSolid = m.multiply(cl.multiply(tempF.subtract(tempV))).add(m.multiply(clfn)); //valor negativo
                    
                    energCedida_v = qtEnergiaCedida(listNoFaseChange,tempV); 
                    energCedida_f = qtEnergiaCedida(listNoFaseChange,tempF);
                    
                    if(energCedida_v.doubleValue()>0){
                        //a agua pode mudar de fase
                        
                        mid = energCedida_v.add(energForLiquid);
                        
                        if(mid.doubleValue()==0){
                            
                            co1 = co1.add(m.multiply(cv.multiply(tempIni)));//adicionando fase gasosa
                            co2 = co2.add(m.multiply(cv));//adicionando fase gasosa
                            f = f.add(m.multiply(clvn));//adicionando mudanca de fase a equacao geral
                            
                        }else if(mid.doubleValue()>0){
                            
                            co1 = co1.add(m.multiply(cv.multiply(tempIni)));//adicionando fase gasosa
                            co2 = co2.add(m.multiply(cv));//adicionando fase gasosa
                            f = f.add(m.multiply(clvn));//adicionando mudanca de fase a equacao geral
                            
                            co1 = co1.add(m.multiply(cl.multiply(tempV)));//adicionando fase liquida
                            co2 = co2.add(m.multiply(cl));//adicionando fase liquida
                            
                            if(energCedida_f.doubleValue()>0){
                                //continua mudando de fase
                                
                                mid = energCedida_f.add(energForSolid);
                                
                                if(mid.doubleValue()==0){
                                    f = f.add(m.multiply(clfn));//adicionando mudanca de fase a equacao geral
                                }else if(mid.doubleValue()>0){
                                    co1 = co1.add(m.multiply(cs.multiply(tempF)));//adicionando fase solida
                                    co2 = co2.add(m.multiply(cs));//adicionando fase solida
                                    f = f.add(m.multiply(clfn));//adicionando mudanca de fase a equacao geral
                                }
                           
                            }
                            
                        }else{
                            co1 = co1.add(m.multiply(cv.multiply(tempIni)));//adicionando fase gasosa
                            co2 = co2.add(m.multiply(cv));//adicionando fase gasosa
                        }
 
                    }else{
                        //a agua nao pode mudar de fase
                        co1 = co1.add(m.multiply(cv.multiply(tempIni)));//adicionando fase gasosa
                        co2 = co2.add(m.multiply(cv));//adicionando fase gasosa
                    }
                    
                }else{
                    throw new Exception("Falha geral!");
                }
                
                //fim do estudo de fases

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
        
    private BigDecimal qtEnergiaCedida(List<eqNoFaseChange> eqs,BigDecimal tempF){
        
        BigDecimal energ = new BigDecimal(0);
        
        for (eqNoFaseChange eq : eqs) {
                
            energ = energ.add(eq.m.multiply(eq.c.multiply(tempF.subtract(eq.tempIni))));
    
        }
        
        return energ;
    }
    
}