
package grafico;

import entidades.Elemento;
import entidades.ItensEquilibrioTermico;
import entidades.ItensQuantidadeCalor;
import grafico.conversores.ConverEnerg;
import grafico.conversores.ConverMassa;
import grafico.conversores.ConverTemp;
import java.awt.Toolkit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Conversores;
import util.JtextFieldNumbers;
import processors.ProcessQuantidadeCalor;

public class MainTela extends javax.swing.JFrame {
    
    public static Integer precisao = 1000;
    
    //qc - ini
    private List<ItensQuantidadeCalor> qcLista = new ArrayList();
    private Elemento qcE;
    //qc - end
    
    //et - ini
    private List<ItensEquilibrioTermico> etLista = new ArrayList();
    private Elemento etE;
    //et - end
    

    public MainTela() {
        initComponents();
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("livropreto.png")));
        
        
        //qc - ini
        qcTxtNome.setEditable(false);
        qcRadBtMassa.setSelected(true);
        qcAmont();
        //qc - end
        
        //et - ini
        etTxtNome.setEditable(false);
        etRadBtMassa.setSelected(true);
        etAmont();
        //et - end
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qcGroupBut = new javax.swing.ButtonGroup();
        etGroupBut = new javax.swing.ButtonGroup();
        comportPanels = new javax.swing.JTabbedPane();
        qcPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        qcButProcurar = new javax.swing.JButton();
        qcButCalc = new javax.swing.JButton();
        qcButAdd = new javax.swing.JButton();
        qcButLimpar = new javax.swing.JButton();
        qcCombTempIni = new javax.swing.JComboBox();
        qcCombTempFin = new javax.swing.JComboBox();
        qcCombMassa = new javax.swing.JComboBox();
        qcTxtTempIni = new JtextFieldNumbers();
        qcTxtTempIniPow = new JtextFieldNumbers();
        qcTxtTempFin = new JtextFieldNumbers();
        qcTxtTempFinPow = new JtextFieldNumbers();
        qcTxtMassa = new JtextFieldNumbers();
        qcTxtMassaPow = new JtextFieldNumbers();
        qcTxtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        qcTab = new javax.swing.JTable();
        qcRadBtMassa = new javax.swing.JRadioButton();
        qcRadBtCapTermic = new javax.swing.JRadioButton();
        etPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        etButProcurar = new javax.swing.JButton();
        etButCalc = new javax.swing.JButton();
        etButAdd = new javax.swing.JButton();
        etButLimpar = new javax.swing.JButton();
        etCombTempIni = new javax.swing.JComboBox();
        etCombMassa = new javax.swing.JComboBox();
        etTxtTempIni = new JtextFieldNumbers();
        etTxtTempIniPow = new JtextFieldNumbers();
        etTxtMassa = new JtextFieldNumbers();
        etTxtMassaPow = new JtextFieldNumbers();
        etTxtNome = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        etTab = new javax.swing.JTable();
        etRadBtMassa = new javax.swing.JRadioButton();
        etRadBtCapTermic = new javax.swing.JRadioButton();
        menuBar = new javax.swing.JMenuBar();
        itmElemento = new javax.swing.JMenu();
        itmEAdc = new javax.swing.JMenuItem();
        itmEList = new javax.swing.JMenuItem();
        itmConversor = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        itmConvTemp = new javax.swing.JMenuItem();
        itmConvMassa = new javax.swing.JMenuItem();
        itmConvEnerg = new javax.swing.JMenuItem();
        itmConfig = new javax.swing.JMenu();
        itmCAjustPrec = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EqTermic 3.2");
        setResizable(false);

        comportPanels.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        qcPanel.setMaximumSize(new java.awt.Dimension(1000, 400));
        qcPanel.setPreferredSize(new java.awt.Dimension(1000, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome do elemento:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Temperatura inicial:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("x10 a");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Temperatura final:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("x10 a");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("x10 a");

        qcButProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        qcButProcurar.setToolTipText("Buscar");
        qcButProcurar.setPreferredSize(new java.awt.Dimension(36, 36));
        qcButProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcButProcurarActionPerformed(evt);
            }
        });

        qcButCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/raio.png"))); // NOI18N
        qcButCalc.setToolTipText("Calcular");
        qcButCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcButCalcActionPerformed(evt);
            }
        });

        qcButAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N
        qcButAdd.setToolTipText("Adicionar");
        qcButAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcButAddActionPerformed(evt);
            }
        });

        qcButLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vassoura.png"))); // NOI18N
        qcButLimpar.setToolTipText("Limpar");
        qcButLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcButLimparActionPerformed(evt);
            }
        });

        qcCombTempIni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qcCombTempIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "°C", "°F", "K" }));

        qcCombTempFin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qcCombTempFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "°C", "°F", "K" }));

        qcCombMassa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qcCombMassa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "g", "Kg", "L", "mL", "cm³" }));

        qcTxtTempIni.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        qcTxtTempIniPow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qcTxtTempIniPow.setText("0");

        qcTxtTempFin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        qcTxtTempFinPow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qcTxtTempFinPow.setText("0");

        qcTxtMassa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        qcTxtMassaPow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        qcTxtMassaPow.setText("0");

        qcTxtNome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        qcTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        qcTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qcTabKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(qcTab);

        qcGroupBut.add(qcRadBtMassa);
        qcRadBtMassa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qcRadBtMassa.setText("Massa:");
        qcRadBtMassa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcRadBtMassaActionPerformed(evt);
            }
        });

        qcGroupBut.add(qcRadBtCapTermic);
        qcRadBtCapTermic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qcRadBtCapTermic.setText("Capacidade térmica:");
        qcRadBtCapTermic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qcRadBtCapTermicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout qcPanelLayout = new javax.swing.GroupLayout(qcPanel);
        qcPanel.setLayout(qcPanelLayout);
        qcPanelLayout.setHorizontalGroup(
            qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qcPanelLayout.createSequentialGroup()
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qcPanelLayout.createSequentialGroup()
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(qcPanelLayout.createSequentialGroup()
                                .addComponent(qcButCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qcButLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qcButAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qcPanelLayout.createSequentialGroup()
                                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qcTxtTempIni, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qcPanelLayout.createSequentialGroup()
                                        .addComponent(qcRadBtMassa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(qcRadBtCapTermic))
                                    .addComponent(qcTxtTempFin)
                                    .addComponent(qcTxtMassa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(qcPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qcTxtTempIniPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qcCombTempIni, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qcPanelLayout.createSequentialGroup()
                                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(qcPanelLayout.createSequentialGroup()
                                                .addComponent(qcTxtMassaPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(qcCombMassa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(qcPanelLayout.createSequentialGroup()
                                                .addComponent(qcTxtTempFinPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(qcCombTempFin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(qcPanelLayout.createSequentialGroup()
                                .addComponent(qcTxtNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qcButProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        qcPanelLayout.setVerticalGroup(
            qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qcPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(qcButProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qcTxtNome))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qcTxtTempIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(qcTxtTempIniPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qcCombTempIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qcTxtTempFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(qcTxtTempFinPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qcCombTempFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qcPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qcRadBtMassa)
                                    .addComponent(qcRadBtCapTermic))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qcTxtMassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(qcTxtMassaPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qcCombMassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(qcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qcButCalc, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(qcButLimpar, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qcPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qcButAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        comportPanels.addTab("Quantidade de Calor", qcPanel);

        etPanel.setMaximumSize(new java.awt.Dimension(1000, 400));
        etPanel.setPreferredSize(new java.awt.Dimension(1000, 400));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Nome do elemento:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Temperatura inicial:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("x10 a");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("x10 a");

        etButProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        etButProcurar.setToolTipText("Procurar");
        etButProcurar.setPreferredSize(new java.awt.Dimension(36, 36));
        etButProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etButProcurarActionPerformed(evt);
            }
        });

        etButCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/raio.png"))); // NOI18N
        etButCalc.setToolTipText("Calcular");
        etButCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etButCalcActionPerformed(evt);
            }
        });

        etButAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N
        etButAdd.setToolTipText("Adicionar");
        etButAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etButAddActionPerformed(evt);
            }
        });

        etButLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vassoura.png"))); // NOI18N
        etButLimpar.setToolTipText("Limpar");
        etButLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etButLimparActionPerformed(evt);
            }
        });

        etCombTempIni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etCombTempIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "°C", "°F", "K" }));

        etCombMassa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etCombMassa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "g", "Kg", "L", "mL", "cm³" }));

        etTxtTempIni.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        etTxtTempIniPow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        etTxtTempIniPow.setText("0");

        etTxtMassa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        etTxtMassaPow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        etTxtMassaPow.setText("0");

        etTxtNome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        etTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        etTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etTabKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(etTab);

        etGroupBut.add(etRadBtMassa);
        etRadBtMassa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etRadBtMassa.setText("Massa:");
        etRadBtMassa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etRadBtMassaActionPerformed(evt);
            }
        });

        etGroupBut.add(etRadBtCapTermic);
        etRadBtCapTermic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etRadBtCapTermic.setText("Capacidade térmica:");
        etRadBtCapTermic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etRadBtCapTermicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout etPanelLayout = new javax.swing.GroupLayout(etPanel);
        etPanel.setLayout(etPanelLayout);
        etPanelLayout.setHorizontalGroup(
            etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(etPanelLayout.createSequentialGroup()
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etPanelLayout.createSequentialGroup()
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(etPanelLayout.createSequentialGroup()
                                .addComponent(etButCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etButLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etButAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, etPanelLayout.createSequentialGroup()
                                .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etTxtTempIni, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etPanelLayout.createSequentialGroup()
                                        .addComponent(etRadBtMassa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(etRadBtCapTermic))
                                    .addComponent(etTxtMassa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(etPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etTxtTempIniPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etCombTempIni, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etTxtMassaPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etCombMassa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(etPanelLayout.createSequentialGroup()
                                .addComponent(etTxtNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etButProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        etPanelLayout.setVerticalGroup(
            etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(etPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etButProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etTxtNome))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etTxtTempIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(etTxtTempIniPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etCombTempIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etRadBtMassa)
                            .addComponent(etRadBtCapTermic))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etTxtMassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(etTxtMassaPow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etCombMassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(etPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etButCalc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etButLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etButAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addContainerGap())
        );

        comportPanels.addTab("Equilibrio Térmico", etPanel);

        itmElemento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/atom.png"))); // NOI18N
        itmElemento.setText("Elementos");

        itmEAdc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cads.png"))); // NOI18N
        itmEAdc.setText("Adicionar");
        itmEAdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEAdcActionPerformed(evt);
            }
        });
        itmElemento.add(itmEAdc);

        itmEList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/files.png"))); // NOI18N
        itmEList.setText("Listar");
        itmEList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEListActionPerformed(evt);
            }
        });
        itmElemento.add(itmEList);

        menuBar.add(itmElemento);

        itmConversor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tools.png"))); // NOI18N
        itmConversor.setText("Ferramentas");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/conver.png"))); // NOI18N
        jMenu1.setText("Conversores");

        itmConvTemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itnconver.png"))); // NOI18N
        itmConvTemp.setText("Temperatura");
        itmConvTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConvTempActionPerformed(evt);
            }
        });
        jMenu1.add(itmConvTemp);

        itmConvMassa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itnconver.png"))); // NOI18N
        itmConvMassa.setText("Massa");
        itmConvMassa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConvMassaActionPerformed(evt);
            }
        });
        jMenu1.add(itmConvMassa);

        itmConvEnerg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itnconver.png"))); // NOI18N
        itmConvEnerg.setText("Energia");
        itmConvEnerg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConvEnergActionPerformed(evt);
            }
        });
        jMenu1.add(itmConvEnerg);

        itmConversor.add(jMenu1);

        menuBar.add(itmConversor);

        itmConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/configs.png"))); // NOI18N
        itmConfig.setText("Configurações");

        itmCAjustPrec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/engre.png"))); // NOI18N
        itmCAjustPrec.setText("Ajustar Precisão");
        itmCAjustPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCAjustPrecActionPerformed(evt);
            }
        });
        itmConfig.add(itmCAjustPrec);

        menuBar.add(itmConfig);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comportPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comportPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //gerAction - ini
    
    private void itmEAdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEAdcActionPerformed
        System.out.println("Adicionar elemento.");
        CadElement ce = new CadElement(null, true);
        ce.setVisible(true);
        
    }//GEN-LAST:event_itmEAdcActionPerformed

    private void itmEListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEListActionPerformed
        System.out.println("Listar elementos");
        ListElement le = new ListElement();
        le.setVisible(true); 
    }//GEN-LAST:event_itmEListActionPerformed

    private void itmCAjustPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCAjustPrecActionPerformed
        
        System.out.println("Ajustando precisão");
        Precision p = new Precision(null,true,precisao);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        System.out.println("Precisão ajustada para: "+precisao);
        
    }//GEN-LAST:event_itmCAjustPrecActionPerformed
    
    //gerAction - end
    
    
    //qcAction - ini
    
    
    private void qcRadBtCapTermicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcRadBtCapTermicActionPerformed
        qcCombMassa.setEnabled(false);
    }//GEN-LAST:event_qcRadBtCapTermicActionPerformed

    private void qcRadBtMassaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcRadBtMassaActionPerformed
        qcCombMassa.setEnabled(true);
    }//GEN-LAST:event_qcRadBtMassaActionPerformed

    private void qcTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qcTabKeyPressed
        if(evt.getKeyCode() == 127 || evt.getKeyCode() == 110){

            try{
                qcLista.remove(qcTab.getSelectedRow());
                System.out.println("Item removido da lista!");
                qcAmont();
            }catch(ArrayIndexOutOfBoundsException e){

                System.out.println("Erro ao deletar o item da tabela! - "+e.getMessage());
                JOptionPane.showMessageDialog(null, "Nenhum item selecionado! ","InternalSystem",JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_qcTabKeyPressed

    private void qcButLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcButLimparActionPerformed

        qcClear("full");

    }//GEN-LAST:event_qcButLimparActionPerformed

    private void qcButAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcButAddActionPerformed

        if(qcE==null ||
            qcTxtMassa.getText().isEmpty()||
            qcTxtMassaPow.getText().isEmpty()||
            qcTxtTempFin.getText().isEmpty()||
            qcTxtTempFinPow.getText().isEmpty()||
            qcTxtTempIni.getText().isEmpty()||
            qcTxtTempIniPow.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!","InternalSystem",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                ItensQuantidadeCalor ie = new ItensQuantidadeCalor();
                ie.setElemento(qcE);

                String combMassa = (String) qcCombMassa.getSelectedItem();
                String combTempIni = (String) qcCombTempIni.getSelectedItem();
                String combTempFin = (String) qcCombTempFin.getSelectedItem();

                Conversores c = new Conversores();

                if(qcRadBtMassa.isSelected()){

                    if(combMassa.equals("g")){
                        ie.setMassa(Math.pow(10,Integer.parseInt(qcTxtMassaPow.getText())) * Double.parseDouble(qcTxtMassa.getText()));
                        ie.setCapTermic(0.d);
                    }else{
                        ie.setMassa(c.massa(combMassa, "g",
                            Math.pow(10,Integer.parseInt(qcTxtMassaPow.getText())) * Double.parseDouble(qcTxtMassa.getText())));
                        ie.setCapTermic(0.d);
                    }

                }else if(qcRadBtCapTermic.isSelected()){

                    ie.setMassa(0.d);
                    ie.setCapTermic(Math.pow(10,Integer.parseInt(qcTxtMassaPow.getText())) * Double.parseDouble(qcTxtMassa.getText()));

                }

                if(combTempIni.equals("°C")){
                    System.out.println(Math.pow(10,Integer.parseInt(qcTxtTempIniPow.getText())) * Double.parseDouble(qcTxtTempIni.getText()));
                    ie.setTempInicial(Math.pow(10,Integer.parseInt(qcTxtTempIniPow.getText())) * Double.parseDouble(qcTxtTempIni.getText()));
                }else{
                    ie.setTempInicial(c.temperatura(combTempIni, "°C",
                        Math.pow(10,Integer.parseInt(qcTxtTempIniPow.getText())) * Double.parseDouble(qcTxtTempIni.getText())));
                }

                if(combTempFin.equals("°C")){
                    ie.setTempFinal(Math.pow(10,Integer.parseInt(qcTxtTempFinPow.getText())) * Double.parseDouble(qcTxtTempFin.getText()));
                }else{
                    ie.setTempFinal(c.temperatura(combTempFin, "°C",
                    Math.pow(10,Integer.parseInt(qcTxtTempFinPow.getText())) * Double.parseDouble(qcTxtTempFin.getText())));
                }

                qcLista.add(ie);
                qcAmont();
                qcClear("object");

            }catch(Exception e){
                System.out.println("Erro na conversão de valores!--"+e.getMessage());

                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!","InternalSystem",JOptionPane.ERROR_MESSAGE);
            }
        
        }

    }//GEN-LAST:event_qcButAddActionPerformed

    private void qcButCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcButCalcActionPerformed
        if(qcLista.size()>0){

            try{

                ProcessQuantidadeCalor p = new ProcessQuantidadeCalor();
                ShowResult sr = new ShowResult(null, true,"qc",p.calc(qcLista));
                sr.setLocationRelativeTo(null);
                sr.setVisible(true);
                qcClear("full");

            }catch(Exception e){

                System.err.println(e.getMessage());

            }

        }else{

            System.out.println("Lista vazia");
            JOptionPane.showMessageDialog(null, "Adicione corpos a tabela!","InternalSystem", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_qcButCalcActionPerformed

    private void qcButProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qcButProcurarActionPerformed
        
        System.out.println("Pesquisa de elemento");
        PesqElement pq = new PesqElement(null,true);
        pq.setVisible(true);

        if(pq.getE() != null){
            this.qcE = pq.getE();
            qcTxtNome.setText(qcE.getNome());
        }

    }//GEN-LAST:event_qcButProcurarActionPerformed

    private void qcAmont(){
        try{
    
            DefaultTableModel modelo = new DefaultTableModel();
        
            modelo.addColumn("Nome");
            modelo.addColumn("Temperatura Incial (°C)");
            modelo.addColumn("Temperatura Final (°C)");
            modelo.addColumn("Massa (g)");
    
            for (ItensQuantidadeCalor ie : qcLista) {
            
                modelo.addRow(new Object[]{
                    ie.getElemento().getNome(),
                    ie.getTempInicial(),
                    ie.getTempFinal(),
                    ie.getMassa()
                });
        
            }
        
        qcTab.setModel(modelo);

        }catch(Exception e){
   
        System.err.println("Tabela: "+e.getMessage());
       
        }
    }

    private void qcClear(String tipe){

        switch(tipe){
    
            case "object":
            
                this.qcE = null;
                qcTxtMassa.setText("");
                qcTxtMassaPow.setText("0");
                qcTxtNome.setText("");
                qcTxtTempFin.setText("");
                qcTxtTempFinPow.setText("0");
                qcTxtTempIni.setText("");
                qcTxtTempIniPow.setText("0");
                qcCombMassa.setSelectedIndex(0);
                qcCombTempIni.setSelectedIndex(0);
                qcCombTempFin.setSelectedIndex(0);
                qcRadBtMassa.setSelected(true);
                qcCombMassa.setEnabled(true);
                qcAmont();
                break;
            
            case "full":
            
                System.out.println("Limpar corpos");
                int r  =  JOptionPane.showConfirmDialog(null, "Deseja limpar todos os elementos?","InternalSystem", JOptionPane.YES_NO_OPTION);    
            
                if (r == JOptionPane.YES_OPTION) {
                
                    this.qcE = null;
                    qcLista.clear();
                    qcTxtMassa.setText("");
                    qcTxtMassaPow.setText("0");
                    qcTxtNome.setText("");
                    qcTxtTempFin.setText("");
                    qcTxtTempFinPow.setText("0");
                    qcTxtTempIni.setText("");
                    qcTxtTempIniPow.setText("0");
                    qcCombMassa.setSelectedIndex(0);
                    qcCombTempIni.setSelectedIndex(0);
                    qcCombTempFin.setSelectedIndex(0);
                    qcRadBtMassa.setSelected(true);
                    qcCombMassa.setEnabled(true);
                    qcAmont();
       
                }else{
        
                    System.out.println("Abortado");
        
                }
            
                break;
        
        }
    
    }

    //qcAction - end
    
    //etAction - ini
    
    
    private void etButProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etButProcurarActionPerformed
       System.out.println("Pesquisa de elemento");
        PesqElement pq = new PesqElement(null,true);
        pq.setVisible(true);

        if(pq.getE() != null){
            this.etE = pq.getE();
            etTxtNome.setText(etE.getNome());
        }
    }//GEN-LAST:event_etButProcurarActionPerformed

    private void etButCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etButCalcActionPerformed
        System.out.println("No Action!\n\n\n");
    }//GEN-LAST:event_etButCalcActionPerformed

    private void etButAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etButAddActionPerformed
        if(etE==null ||
            etTxtMassa.getText().isEmpty()||
            etTxtMassaPow.getText().isEmpty()||
            etTxtTempIni.getText().isEmpty()||
            etTxtTempIniPow.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!","InternalSystem",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                ItensEquilibrioTermico iet = new ItensEquilibrioTermico();
                iet.setElemento(etE);

                String combMassa = (String) etCombMassa.getSelectedItem();
                String combTempIni = (String) etCombTempIni.getSelectedItem();
                

                Conversores c = new Conversores();

                if(etRadBtMassa.isSelected()){

                    if(combMassa.equals("g")){
                        iet.setMassa(Math.pow(10,Integer.parseInt(etTxtMassaPow.getText())) * Double.parseDouble(etTxtMassa.getText()));
                        iet.setCapTermic(0.d);
                    }else{
                        iet.setMassa(c.massa(combMassa, "g",
                            Math.pow(10,Integer.parseInt(etTxtMassaPow.getText())) * Double.parseDouble(etTxtMassa.getText())));
                        iet.setCapTermic(0.d);
                    }

                }else if(etRadBtCapTermic.isSelected()){

                    iet.setMassa(0.d);
                    iet.setCapTermic(Math.pow(10,Integer.parseInt(etTxtMassaPow.getText())) * Double.parseDouble(etTxtMassa.getText()));

                }

                if(combTempIni.equals("°C")){
                    System.out.println(Math.pow(10,Integer.parseInt(etTxtTempIniPow.getText())) * Double.parseDouble(etTxtTempIni.getText()));
                    iet.setTempIni(Math.pow(10,Integer.parseInt(etTxtTempIniPow.getText())) * Double.parseDouble(etTxtTempIni.getText()));
                }else{
                    iet.setTempIni(c.temperatura(combTempIni, "°C",
                        Math.pow(10,Integer.parseInt(etTxtTempIniPow.getText())) * Double.parseDouble(etTxtTempIni.getText())));
                }
                
                etLista.add(iet);
                etAmont();
                etClear("object");

            }catch(Exception e){
                System.out.println("Erro na conversão de valores!--"+e.getMessage());

                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!","InternalSystem",JOptionPane.ERROR_MESSAGE);
            }
        
        }
    }//GEN-LAST:event_etButAddActionPerformed

    private void etButLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etButLimparActionPerformed
        etClear("full");
    }//GEN-LAST:event_etButLimparActionPerformed

    private void etTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etTabKeyPressed
        if(evt.getKeyCode() == 127 || evt.getKeyCode() == 110){

            try{
                etLista.remove(etTab.getSelectedRow());
                System.out.println("Item removido da lista!");
                etAmont();
            }catch(ArrayIndexOutOfBoundsException e){

                System.out.println("Erro ao deletar o item da tabela! - "+e.getMessage());
                JOptionPane.showMessageDialog(null, "Nenhum item selecionado! ","InternalSystem",JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_etTabKeyPressed

    private void etRadBtMassaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etRadBtMassaActionPerformed
        etCombMassa.setEnabled(true);
    }//GEN-LAST:event_etRadBtMassaActionPerformed

    private void etRadBtCapTermicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etRadBtCapTermicActionPerformed
        etCombMassa.setEnabled(false);
    }//GEN-LAST:event_etRadBtCapTermicActionPerformed

    private void itmConvTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConvTempActionPerformed
        
        ConverTemp ct = new ConverTemp();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
        
    }//GEN-LAST:event_itmConvTempActionPerformed

    private void itmConvMassaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConvMassaActionPerformed
        ConverMassa cm = new ConverMassa();
        cm.setLocationRelativeTo(null);
        cm.setVisible(true);
    }//GEN-LAST:event_itmConvMassaActionPerformed

    private void itmConvEnergActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConvEnergActionPerformed
        ConverEnerg ce = new ConverEnerg();
        ce.setLocationRelativeTo(null);
        ce.setVisible(true);
    }//GEN-LAST:event_itmConvEnergActionPerformed

    private void etAmont(){
        
        try{
    
            DefaultTableModel modelo = new DefaultTableModel();
        
            modelo.addColumn("Nome");
            modelo.addColumn("Temperatura Incial (°C)");
            modelo.addColumn("Massa (g)");

            for (ItensEquilibrioTermico iet : etLista) {
            
                modelo.addRow(new Object[]{
                    iet.getElemento().getNome(),
                    iet.getTempIni(),
                    iet.getMassa()
                });
        
            }
        
            etTab.setModel(modelo);

        }catch(Exception e){
   
            System.err.println("Tabela: "+e.getMessage());
       
        }
        
    }

    private void etClear(String tipe){

        switch(tipe){
    
            case "object":
            
                this.etE = null;
                etTxtMassa.setText("");
                etTxtMassaPow.setText("0");
                etTxtNome.setText("");
                etTxtTempIni.setText("");
                etTxtTempIniPow.setText("0");
                etCombMassa.setSelectedIndex(0);
                etCombTempIni.setSelectedIndex(0);
                etRadBtMassa.setSelected(true);
                etCombMassa.setEnabled(true);
                qcAmont();
                break;
            
            case "full":
            
                System.out.println("Limpar corpos");
                int r  =  JOptionPane.showConfirmDialog(null, "Deseja limpar todos os elementos?","InternalSystem", JOptionPane.YES_NO_OPTION);    
            
                if (r == JOptionPane.YES_OPTION) {
                
                    this.etE = null;
                    etLista.clear();
                    etTxtMassa.setText("");
                    etTxtMassaPow.setText("0");
                    etTxtNome.setText("");
                    etTxtTempIni.setText("");
                    etTxtTempIniPow.setText("0");
                    etCombMassa.setSelectedIndex(0);
                    etCombTempIni.setSelectedIndex(0);
                    etRadBtMassa.setSelected(true);
                    etCombMassa.setEnabled(true);
                    etAmont();

                }else{
        
                    System.out.println("Abortado");
        
                }
            
                break;
        
        }
    
    }
    
        
    //etAction - end

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainTela maintela = new MainTela();
                maintela.setLocationRelativeTo(null);
                maintela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane comportPanels;
    private javax.swing.JButton etButAdd;
    private javax.swing.JButton etButCalc;
    private javax.swing.JButton etButLimpar;
    private javax.swing.JButton etButProcurar;
    private javax.swing.JComboBox etCombMassa;
    private javax.swing.JComboBox etCombTempIni;
    private javax.swing.ButtonGroup etGroupBut;
    private javax.swing.JPanel etPanel;
    private javax.swing.JRadioButton etRadBtCapTermic;
    private javax.swing.JRadioButton etRadBtMassa;
    private javax.swing.JTable etTab;
    private javax.swing.JTextField etTxtMassa;
    private javax.swing.JTextField etTxtMassaPow;
    private javax.swing.JTextField etTxtNome;
    private javax.swing.JTextField etTxtTempIni;
    private javax.swing.JTextField etTxtTempIniPow;
    private javax.swing.JMenuItem itmCAjustPrec;
    private javax.swing.JMenu itmConfig;
    private javax.swing.JMenuItem itmConvEnerg;
    private javax.swing.JMenuItem itmConvMassa;
    private javax.swing.JMenuItem itmConvTemp;
    private javax.swing.JMenu itmConversor;
    private javax.swing.JMenuItem itmEAdc;
    private javax.swing.JMenuItem itmEList;
    private javax.swing.JMenu itmElemento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton qcButAdd;
    private javax.swing.JButton qcButCalc;
    private javax.swing.JButton qcButLimpar;
    private javax.swing.JButton qcButProcurar;
    private javax.swing.JComboBox qcCombMassa;
    private javax.swing.JComboBox qcCombTempFin;
    private javax.swing.JComboBox qcCombTempIni;
    private javax.swing.ButtonGroup qcGroupBut;
    private javax.swing.JPanel qcPanel;
    private javax.swing.JRadioButton qcRadBtCapTermic;
    private javax.swing.JRadioButton qcRadBtMassa;
    private javax.swing.JTable qcTab;
    private javax.swing.JTextField qcTxtMassa;
    private javax.swing.JTextField qcTxtMassaPow;
    private javax.swing.JTextField qcTxtNome;
    private javax.swing.JTextField qcTxtTempFin;
    private javax.swing.JTextField qcTxtTempFinPow;
    private javax.swing.JTextField qcTxtTempIni;
    private javax.swing.JTextField qcTxtTempIniPow;
    // End of variables declaration//GEN-END:variables
}
