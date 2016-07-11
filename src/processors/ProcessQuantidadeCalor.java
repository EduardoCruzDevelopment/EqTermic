package processors;

import entidades.Elemento;
import entidades.ItensQuantidadeCalor;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

public class ProcessQuantidadeCalor {

    public BigDecimal calc(List<ItensQuantidadeCalor> corpo) throws Exception {

        BigDecimal result = new BigDecimal(0);

        for (ItensQuantidadeCalor ie : corpo) {

            System.out.println("Corpo: " + ie.getElemento().getNome());

            
            BigDecimal m = new BigDecimal(0);
            Double tF = ie.getElemento().getTempF();
            Double tV = ie.getElemento().getTempV();
            System.out.println("Tp fusao - " + tF);
            System.out.println("Tp Vap - " + tV);
            System.out.println("Temperatura inicial - " + ie.getTempInicial());
            String pIni = position(ie.getTempInicial(), tF, tV);
            System.out.println("Temperatura final - " + ie.getTempFinal());
            String pFin = position(ie.getTempFinal(), tF, tV);
            
            //definindo a massa - inicio
            
            if (ie.getCapTermic() != 0 && ie.getMassa() == 0.d) {

                System.out.println("Capacidade termica informada!");
                
                try{
                
                    m = defCapTermic(pIni,ie.getElemento(),ie.getCapTermic());
                    
                }catch(Exception e){
                    
                    JOptionPane.showMessageDialog(null, "InternalSystem","Não é possivel calcular a capacidade termica de elementos em mudança de fase!"
                                                  ,JOptionPane.ERROR_MESSAGE);
                    
                    m = new BigDecimal(0);
                    
                }

            } else {

                m = new BigDecimal(ie.getMassa());

            }

            //definindo a massa - final    
            if (ie.getTempFinal() > ie.getTempInicial()) {

                System.out.println("Resultado crescente");

                if (pIni.equals("antF")) {

                    if (pFin.equals("antF")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcSolido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(c.multiply(dt))); //solido

                    } else if (pFin.equals("onF")) {

                        BigDecimal cs = new BigDecimal(ie.getElemento().getcSolido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clf = new BigDecimal(ie.getElemento().getlFusao());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a fusão do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(cs.multiply(dt)) //solido
                                    .add(m.multiply(clf))); //fusao

                        } else {

                            result = result.add(m.multiply(cs.multiply(dt)));

                        }

                    } else if (pFin.equals("antV")) {

                        BigDecimal cs = new BigDecimal(ie.getElemento().getcSolido()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dts = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                dtl = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clf = new BigDecimal(ie.getElemento().getlFusao());

                        result = result.add((m.multiply(cs.multiply(dts))) //solido
                                .add(m.multiply(cl.multiply(dtl))) //liquido
                                .add(m.multiply(clf))); //fusao

                    } else if (pFin.equals("onV")) {

                        BigDecimal cs = new BigDecimal(ie.getElemento().getcSolido()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dts = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                dtl = new BigDecimal(ie.getElemento().getTempV() - ie.getElemento().getTempF()),
                                clf = new BigDecimal(ie.getElemento().getlFusao()),
                                clv = new BigDecimal(ie.getElemento().getlVapor());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a vaporização do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add((m.multiply(cs.multiply(dts))) //solido
                                    .add(m.multiply(clf)) //fusao
                                    .add(m.multiply(cl.multiply(dtl))) //liquido
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add((m.multiply(cs.multiply(dts))) //solido
                                    .add(m.multiply(clf)) //fusao
                                    .add(m.multiply(cl.multiply(dtl)))); //liquido

                        }

                    } else if (pFin.equals("postV")) {

                        BigDecimal cs = new BigDecimal(ie.getElemento().getcSolido()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cg = new BigDecimal(ie.getElemento().getcGasoso()),
                                dts = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                dtl = new BigDecimal(ie.getElemento().getTempV() - ie.getElemento().getTempF()),
                                dtg = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV()),
                                clf = new BigDecimal(ie.getElemento().getlFusao()),
                                clv = new BigDecimal(ie.getElemento().getlVapor());

                        result = result.add((m.multiply(cs.multiply(dts)))//solido
                                .add(m.multiply(clf))//fusao
                                .add(m.multiply(cl.multiply(dtl)))//liquido
                                .add(m.multiply(clv))//vaporizacao
                                .add(m.multiply(cg.multiply(dtg))));//gasoso

                    } else {

                        throw new Exception("Erro de calculo, modulo 1 positivo");

                    }

                    //Fim do modulo 1 positivo
                } else if (pIni.equals("onF")) {

                    if (pFin.equals("antF")) {

                        throw new Exception("Erro de calculo, modulo 2 positivo -- pFin-antF");

                    } else if (pFin.equals("onF")) {

                        BigDecimal clf = new BigDecimal(ie.getElemento().getlFusao());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a fusão do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clf));

                        }

                    } else if (pFin.equals("antV")) {

                        BigDecimal clf = new BigDecimal(ie.getElemento().getlFusao()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempF());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a fusão do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add((m.multiply(clf)) //fusao
                                    .add(m.multiply(cl.multiply(dt)))); //liquido   

                        } else {

                            result = result.add(m.multiply(cl.multiply(dt))); //liquido

                        }

                    } else if (pFin.equals("onV")) {

                        BigDecimal clf = new BigDecimal(ie.getElemento().getlFusao()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempF()),
                                clv = new BigDecimal(ie.getElemento().getlVapor());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a fusão do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clf) //fusao
                                    .add(m.multiply(cl.multiply(dt)))); //liquido

                        } else {

                            result = result.add(m.multiply(cl.multiply(dt))); //liquido

                        }

                        r = JOptionPane.showConfirmDialog(null, "Deseja considerar a vaporização do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clv));

                        }

                    } else if (pFin.equals("postV")) {

                        BigDecimal clf = new BigDecimal(ie.getElemento().getlFusao()),
                                cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                clv = new BigDecimal(ie.getElemento().getlVapor()),
                                cv = new BigDecimal(ie.getElemento().getcGasoso()),
                                dtl = new BigDecimal(ie.getElemento().getTempV() - ie.getTempInicial()),
                                dtv = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a fusão do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add((m.multiply(clf)) //fusao
                                    .add(m.multiply(cl.multiply(dtl))) //liquido
                                    .add(m.multiply(clv)) // vaporizacao
                                    .add(m.multiply(cv.multiply(dtv)))); // gasoso

                        } else {

                            result = result.add(m.multiply(cl.multiply(dtl))) //liquido
                                    .add(m.multiply(clv)) // vaporizacao
                                    .add(m.multiply(cv.multiply(dtv))); // gasoso

                        }

                    } else {

                        throw new Exception("Erro de analise modulo 2 positivo");

                    }

                    //fim do modulo 2 positivo
                } else if (pIni.equals("antV")) {

                    if (pFin.equals("antF")) {

                        throw new Exception("Erro de calculo, modulo 3 positivo -- pFin-antF");

                    } else if (pFin.equals("onF")) {

                        throw new Exception("Erro de calculo, modulo 3 positivo -- pFin-onF");

                    } else if (pFin.equals("antV")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(cl.multiply(dt))); //liquido

                    } else if (pFin.equals("onV")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clv = new BigDecimal(ie.getElemento().getlVapor());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a vaporização do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(cl.multiply(dt)) //liquido
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add(m.multiply(cl.multiply(dt))); //liquido

                        }

                    } else if (pFin.equals("postV")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                dtl = new BigDecimal(ie.getElemento().getTempV() - ie.getTempInicial()),
                                clv = new BigDecimal(ie.getElemento().getlVapor()),
                                cv = new BigDecimal(ie.getElemento().getcGasoso()),
                                dtv = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV());

                        result = result.add((m.multiply(cl.multiply(dtl))) //liquido
                                .add(m.multiply(clv)) // vaporizacao
                                .add(m.multiply(cv.multiply(dtv)))); // gasoso

                    } else {

                        throw new Exception("Erro de analise modulo 3 positivo");

                    }

                    //fim do modulo 3 positivo
                } else if (pIni.equals("onV")) {

                    if (pFin.equals("antF")) {

                        throw new Exception("Erro de calculo, modulo 4 positivo -- pFin-antF");

                    } else if (pFin.equals("onF")) {

                        throw new Exception("Erro de calculo, modulo 4 positivo -- pFin-onF");

                    } else if (pFin.equals("antV")) {

                        throw new Exception("Erro de calculo, modulo 4 positivo -- pFin-antV");

                    } else if (pFin.equals("onV")) {

                        BigDecimal clv = new BigDecimal(ie.getElemento().getlVapor());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a vaporização do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clv));

                        }

                    } else if (pFin.equals("postV")) {

                        BigDecimal clv = new BigDecimal(ie.getElemento().getlVapor()),
                                cv = new BigDecimal(ie.getElemento().getcGasoso()),
                                dtv = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV());

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a vaporização do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add((m.multiply(clv)) // vaporizacao
                                    .add(m.multiply(cv.multiply(dtv)))); // gasoso

                        } else {

                            result = result.add(m.multiply(cv.multiply(dtv)));// gasoso

                        }
                    } else {

                        throw new Exception("Erro de analise modulo 4 positivo");

                    }

                } else if (pIni.equals("postV")) {

                    if (pFin.equals("antF")) {

                        throw new Exception("Erro de calculo, modulo 5 positivo -- pFin-antF");

                    } else if (pFin.equals("onF")) {

                        throw new Exception("Erro de calculo, modulo 5 positivo -- pFin-onF");

                    } else if (pFin.equals("antV")) {

                        throw new Exception("Erro de calculo, modulo 5 positivo -- pFin-antF");

                    } else if (pFin.equals("onV")) {

                        throw new Exception("Erro de calculo, modulo 5 positivo -- pFin-onV");

                    } else if (pFin.equals("postV")) {

                        BigDecimal cv = new BigDecimal(ie.getElemento().getcGasoso()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(cv.multiply(dt))); //gasoso

                    } else {

                        throw new Exception("Erro de analise modulo 5 positivo");

                    }

                    //fim do modulo 5 positivo
                } else {

                    throw new Exception("Erro de analise!");

                }

            } else if (ie.getTempInicial().equals(ie.getTempFinal())) {

                System.out.println("As temperaturas são iguais");

            } else if (ie.getTempInicial() > ie.getTempFinal()) {

                System.out.println("Resultado decrescente");

                if (pIni.equals("antF")) {

                    if (pFin.equals("antF")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcSolido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(c.multiply(dt))); //solido

                    } else if (pFin.equals("onF")) {

                        throw new Exception("Erro de calculo, modulo 1 negativo -- pFin>pIni");

                    } else if (pFin.equals("antV")) {

                        throw new Exception("Erro de calculo, modulo 1 negativo -- pFin>pIni");

                    } else if (pFin.equals("onV")) {

                        throw new Exception("Erro de calculo, modulo 1 negativo -- pFin>pIni");

                    } else if (pFin.equals("postV")) {

                        throw new Exception("Erro de calculo, modulo 1 negativo -- pFin>pIni");

                    } else {

                        throw new Exception("Erro de calculo, modulo 1 negativo");

                    }

                    //Fim do modulo 1 negativo
                } else if (pIni.equals("onF")) {

                    if (pFin.equals("antF")) {
                        BigDecimal c = new BigDecimal(ie.getElemento().getcSolido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clf = new BigDecimal((ie.getElemento().getlFusao()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a solidificação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clf) //fusao
                                    .add(m.multiply(c.multiply(dt)))); //solido

                        } else {

                            result = result.add(m.multiply(c.multiply(dt))); //solido

                        }

                    } else if (pFin.equals("onF")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcSolido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clf = new BigDecimal((ie.getElemento().getlFusao()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a solidificação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clf)); //solido

                        }

                    } else if (pFin.equals("antV")) {

                        throw new Exception("Erro de calculo, modulo 2 negativo -- pFin>pIni");

                    } else if (pFin.equals("onV")) {

                        throw new Exception("Erro de calculo, modulo 2 negativo -- pFin>pIni");

                    } else if (pFin.equals("postV")) {

                        throw new Exception("Erro de calculo, modulo 2 negativo -- pFin>pIni");

                    } else {

                        throw new Exception("Erro de analise modulo 2 negativo");

                    }

                    //fim do modulo 2 negativo
                } else if (pIni.equals("antV")) {

                    if (pFin.equals("antF")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cs = new BigDecimal(ie.getElemento().getcSolido()),
                                dtl = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                dts = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempF()),
                                cls = new BigDecimal((ie.getElemento().getlFusao()) * -1);

                        result = result.add(m.multiply(cl.multiply(dtl)) //liquido
                                .add(m.multiply(cls)) //fusao
                                .add(m.multiply(cs.multiply(dts)))); //solido

                    } else if (pFin.equals("onF")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                cl = new BigDecimal((ie.getElemento().getlFusao()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a solidificação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(c.multiply(dt)) //liquido
                                    .add(m.multiply(c))); //fusao

                        } else {

                            result = result.add(m.multiply(c.multiply(dt))); //liquido

                        }

                    } else if (pFin.equals("antV")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(c.multiply(dt))); //liquido

                    } else if (pFin.equals("onV")) {

                        throw new Exception("Erro de calculo, modulo 3 negativo -- pFin>pIni");

                    } else if (pFin.equals("postV")) {

                        throw new Exception("Erro de calculo, modulo 3 negativo -- pFin>pIni");

                    } else {

                        throw new Exception("Erro de analise modulo 3 negativo");

                    }

                    //fim do modulo 3 negativo
                } else if (pIni.equals("onV")) {

                    if (pFin.equals("antF")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cs = new BigDecimal(ie.getElemento().getcSolido()),
                                dtl = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                dts = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempF()),
                                cls = new BigDecimal((ie.getElemento().getlFusao()) * -1),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a liquefação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(cl.multiply(dtl)) //liquido
                                    .add(m.multiply(cls)) //fusao
                                    .add(m.multiply(cs.multiply(dts))) //solido
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add(m.multiply(cl.multiply(dtl)) //liquido
                                    .add(m.multiply(cls)) //fusao
                                    .add(m.multiply(cs.multiply(dts)))); //solido

                        }

                    } else if (pFin.equals("onF")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getElemento().getTempF() - ie.getTempInicial()),
                                cls = new BigDecimal((ie.getElemento().getlFusao()) * -1),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a liquefação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(c.multiply(dt)) //liquido
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add(m.multiply(c.multiply(dt))); //liquido

                        }

                        r = JOptionPane.showConfirmDialog(null, "Deseja considerar a solidificação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(cls));

                        }

                    } else if (pFin.equals("antV")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcLiquido()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a liquefação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(c.multiply(dt)) //liquido
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add(m.multiply(c.multiply(dt))); //liquido

                        }

                    } else if (pFin.equals("onV")) {

                        BigDecimal clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a liquefação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(clv));

                        }

                    } else if (pFin.equals("postV")) {

                        throw new Exception("Erro de calculo, modulo 4 negativo -- pFin>pIni");

                    } else {

                        throw new Exception("Erro de analise modulo 4 negativo");

                    }

                    //fim do modulo 4 negativo
                } else if (pIni.equals("postV")) {

                    if (pFin.equals("antF")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cs = new BigDecimal(ie.getElemento().getcSolido()),
                                cg = new BigDecimal(ie.getElemento().getcGasoso()),
                                dts = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempF()),
                                dtl = new BigDecimal(ie.getElemento().getTempF() - ie.getElemento().getTempV()),
                                dtg = new BigDecimal(ie.getElemento().getTempV() - ie.getTempInicial()),
                                cls = new BigDecimal((ie.getElemento().getlFusao()) * -1),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        result = result.add(m.multiply(cg.multiply(dtg)) //vapor
                                .add(m.multiply(clv)) //vaporizacao
                                .add(m.multiply(cl.multiply(dtl))) // liquido
                                .add(m.multiply(cls)) // fusao
                                .add(m.multiply(cs.multiply(dts)))); //solido

                    } else if (pFin.equals("onF")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cg = new BigDecimal(ie.getElemento().getcGasoso()),
                                dtl = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV()),
                                dtg = new BigDecimal(ie.getElemento().getTempV() - ie.getTempInicial()),
                                cls = new BigDecimal((ie.getElemento().getlFusao()) * -1),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a solidificação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(cg.multiply(dtg)) //vapor
                                    .add(m.multiply(clv)) //vaporizacao
                                    .add(m.multiply(cl.multiply(dtl))) // liquido
                                    .add(m.multiply(cls))); //fusao

                        } else {

                            result = result.add(m.multiply(cg.multiply(dtg)) //vapor
                                    .add(m.multiply(clv)) //vaporizacao
                                    .add(m.multiply(cl.multiply(dtl)))); //liquido 

                        }

                    } else if (pFin.equals("antV")) {

                        BigDecimal cl = new BigDecimal(ie.getElemento().getcLiquido()),
                                cg = new BigDecimal(ie.getElemento().getcGasoso()),
                                dtl = new BigDecimal(ie.getTempFinal() - ie.getElemento().getTempV()),
                                dtg = new BigDecimal(ie.getElemento().getTempV() - ie.getTempInicial()),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        result = result.add(m.multiply(cg.multiply(dtg)) //vapor
                                .add(m.multiply(clv)) //vaporizacao
                                .add(m.multiply(cl.multiply(dtl)))); //liquido 

                    } else if (pFin.equals("onV")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcGasoso()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial()),
                                clv = new BigDecimal((ie.getElemento().getlVapor()) * -1);

                        int r = JOptionPane.showConfirmDialog(null, "Deseja considerar a liquifação do elemento " + ie.getElemento().getNome() + "?",
                                "InternalSystem", JOptionPane.YES_NO_OPTION);

                        if (r == JOptionPane.YES_OPTION) {

                            result = result.add(m.multiply(c.multiply(dt)) //vapor
                                    .add(m.multiply(clv))); //vaporizacao

                        } else {

                            result = result.add(m.multiply(c.multiply(dt))); //vapor

                        }

                    } else if (pFin.equals("postV")) {

                        BigDecimal c = new BigDecimal(ie.getElemento().getcGasoso()),
                                dt = new BigDecimal(ie.getTempFinal() - ie.getTempInicial());

                        result = result.add(m.multiply(c.multiply(dt))); //vapor

                    } else {

                        throw new Exception("Erro de analise modulo 5 negativo");

                    }

                    //fim do modulo 5 negativo
                } else {

                    throw new Exception("Erro de analise!");

                }

            } else {

                System.err.println("Erro, valores invalidos");
                throw new Exception("Erro de analise de temperatura -- inicial/final");

            }

        }

        return result;

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
    
}
