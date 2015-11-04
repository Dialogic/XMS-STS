/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.gui;

import com.dialogic.xms.smoke.test.examples.EchoCallbackDemo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/**
 *
 * @author ssatyana
 */
public class EchoCallbackDemoForm extends javax.swing.JFrame {

    public static final Logger logger = Logger.getLogger(EchoCallbackDemoForm.class.getName());
    public static FileInputStream xmlFile;
    private EchoCallbackDemo testobj;

    /**
     * Creates new form CallForm
     *
     * @param test
     */
    public EchoCallbackDemoForm(EchoCallbackDemo test) {
        this.testobj = test;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {                
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testobj.isCancelled();                
            }
        });
        stimComboBox.setEnabled(Boolean.FALSE);
        File f = new File("config/EchoCallbackConfig.xml");
        if (f.exists()) {
            try {
                readFromXMLFile(new FileInputStream("config/EchoCallbackConfig.xml"));
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldsPanel = new javax.swing.JPanel();
        typeComboBox = new javax.swing.JComboBox();
        ipAddressTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        techTypeLabel = new javax.swing.JLabel();
        xmsAddressLAbel = new javax.swing.JLabel();
        appIdLabel = new javax.swing.JLabel();
        countTextField = new javax.swing.JTextField();
        appIdLabel1 = new javax.swing.JLabel();
        channelTextField = new javax.swing.JTextField();
        appIdLabel2 = new javax.swing.JLabel();
        maxTimeTextField = new javax.swing.JTextField();
        appIdLabel3 = new javax.swing.JLabel();
        stimComboBox = new javax.swing.JComboBox();
        appIdLabel4 = new javax.swing.JLabel();
        recordFileNameTextField = new javax.swing.JTextField();
        appIdLabel5 = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        appIdLabel6 = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        fileTextField = new javax.swing.JTextField();
        fileButton = new javax.swing.JButton();
        enterButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EchoCallbackDemoConfig");

        fieldsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fields", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        typeComboBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Type", "REST", "MSML" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });

        ipAddressTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        userTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        userTextField.setText("app");

        clearButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        clearButton.setText("Clear");
        clearButton.setMaximumSize(new java.awt.Dimension(55, 23));
        clearButton.setMinimumSize(new java.awt.Dimension(55, 23));
        clearButton.setPreferredSize(new java.awt.Dimension(55, 23));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        techTypeLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        techTypeLabel.setForeground(new java.awt.Color(0, 0, 204));
        techTypeLabel.setText("TechType");

        xmsAddressLAbel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        xmsAddressLAbel.setForeground(new java.awt.Color(0, 0, 204));
        xmsAddressLAbel.setText("XMS Address");

        appIdLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel.setText("App ID");

        countTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        countTextField.setText("1");

        appIdLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel1.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel1.setText("No. of times to run");

        channelTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        channelTextField.setText("1");

        appIdLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel2.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel2.setText("No. of channels");

        maxTimeTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        maxTimeTextField.setText("10");

        appIdLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel3.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel3.setText("Config file name");

        stimComboBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        stimComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Auto" }));
        stimComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stimComboBoxActionPerformed(evt);
            }
        });

        appIdLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel4.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel4.setText("Stim Option");

        recordFileNameTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        recordFileNameTextField.setText("Test");

        appIdLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel5.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel5.setText("Record file name");

        fileNameTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        fileNameTextField.setText("config/EchoCallbackConfig.xml");

        appIdLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        appIdLabel6.setForeground(new java.awt.Color(0, 0, 204));
        appIdLabel6.setText("Max time");

        portLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        portLabel.setForeground(new java.awt.Color(0, 0, 204));
        portLabel.setText("Port");

        portTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        portTextField.setText("5070");

        javax.swing.GroupLayout fieldsPanelLayout = new javax.swing.GroupLayout(fieldsPanel);
        fieldsPanel.setLayout(fieldsPanelLayout);
        fieldsPanelLayout.setHorizontalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fieldsPanelLayout.createSequentialGroup()
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(techTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xmsAddressLAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipAddressTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addComponent(appIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fieldsPanelLayout.createSequentialGroup()
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appIdLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appIdLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appIdLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recordFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maxTimeTextField)
                                .addComponent(stimComboBox, 0, 191, Short.MAX_VALUE))
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addComponent(appIdLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(channelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(fieldsPanelLayout.createSequentialGroup()
                                .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fieldsPanelLayout.createSequentialGroup()
                                .addComponent(appIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(countTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fieldsPanelLayout.setVerticalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsPanelLayout.createSequentialGroup()
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(techTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xmsAddressLAbel)
                    .addComponent(ipAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appIdLabel))
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portLabel)
                            .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appIdLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(appIdLabel2)
                            .addComponent(channelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appIdLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appIdLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appIdLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stimComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appIdLabel4))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Upload Config File", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        fileTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        fileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileTextFieldActionPerformed(evt);
            }
        });

        fileButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        fileButton.setText("Browse");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileTextField)
                    .addComponent(fileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        enterButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton)
                    .addComponent(cancelButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileTextFieldActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        try {
            JFileChooser chooser = new JFileChooser("");
            FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
            chooser.setFileFilter(xmlfilter);
            chooser.setDialogTitle("Open config file");
            chooser.setFileFilter(xmlfilter);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int returnVal = chooser.showOpenDialog((java.awt.Component) null);
            File inFile = null;
            if (returnVal == chooser.APPROVE_OPTION) {
                // to populate the text field
                chooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
                            JFileChooser chooser = (JFileChooser) evt.getSource();
                            if (chooser.getSelectedFile() != null) {
                                fileTextField.setText(chooser.getSelectedFile().getName());
                            }
                        }
                    }
                });
                inFile = chooser.getSelectedFile();
                System.out.println("Selected File: " + inFile.getAbsolutePath());

                // copy to local file
                BufferedReader in = new BufferedReader(new FileReader(inFile));
                FileWriter fstream = new FileWriter(fileNameTextField.getText(), true);
                BufferedWriter out = new BufferedWriter(fstream);

                String line = in.readLine();
                while (line != null) {
                    out.write(line);
                    out.newLine();
                    line = in.readLine();
                }
                in.close();
                out.close();

                // auto populate the fields
                xmlFile = new FileInputStream(inFile);
                readFromXMLFile(xmlFile);
            } else if (returnVal == chooser.CANCEL_OPTION) {
                System.out.println("No file selected");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.testobj.isCancelled();
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        if (xmlFile != null) {
            File f = new File(fileNameTextField.getText());
            if (f.exists()) {
                this.testobj.setConfigFileName(fileNameTextField.getText());
//                this.testobj.setRecordFileName(recordFileNameTextField.getText());
//                this.testobj.setMaxTime(Integer.parseInt(maxTimeTextField.getText()));
                if (Integer.parseInt(countTextField.getText()) > 1) {
                    this.testobj.setCount(countTextField.getText());
                }
                if (stimComboBox.getSelectedItem().toString().equalsIgnoreCase("Auto")) {
                    this.testobj.setisStim();
                }
                this.dispose();
                return;
            }
        } else {
            try {
                if (typeComboBox.getSelectedItem() == "Type"
                        || ipAddressTextField.getText().isEmpty() || userTextField.getText().isEmpty()
                        || ipAddressTextField.getText().equalsIgnoreCase("http://enter_ip_adr:81/default/")
                        || ipAddressTextField.getText().contains("enter_ip_adr")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please Choose a config file or enter data in the fields", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = getXMLSource();

                StreamResult result = new StreamResult(new File(fileNameTextField.getText()));
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                transformer.transform(source, result);
                //this.testobj.setRecordFileName(recordFileNameTextField.getText());
                this.testobj.setConfigFileName(fileNameTextField.getText());
                //this.testobj.setMaxTime(Integer.parseInt(maxTimeTextField.getText()));
                if (Integer.parseInt(countTextField.getText()) > 1) {
                    this.testobj.setCount(countTextField.getText());
                }
                if (stimComboBox.getSelectedItem().toString().equalsIgnoreCase("Auto")) {
                    this.testobj.setisStim();
                }
                this.dispose();
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }//GEN-LAST:event_enterButtonActionPerformed

    private void stimComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stimComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stimComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        final JFileChooser SaveAs = new JFileChooser();
        SaveAs.setApproveButtonText("Save");
        int actionDialog = SaveAs.showOpenDialog(this);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File fileName = new File(SaveAs.getSelectedFile() + ".xml");
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = getXMLSource();

            StreamResult result = new StreamResult(fileName);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(source, result);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        typeComboBox.setSelectedItem("Type");
        ipAddressTextField.setText("");
        userTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        if (typeComboBox.getSelectedItem() == "REST") {
            userTextField.setText("app");
            ipAddressTextField.setText("http://enter_ip_adr:81/default/");
            portTextField.setEnabled(false);
        } else if (typeComboBox.getSelectedItem() == "MSML") {
            userTextField.setText("msml");
            ipAddressTextField.setText("");
            portTextField.setEnabled(true);
        }
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void readFromXMLFile(FileInputStream file) {
        Document doc;
        try {
            doc = new Builder().build(file);
            Element root = doc.getRootElement();
            Elements entries = root.getChildElements();
            for (int x = 0; x < entries.size(); x++) {
                Element element = entries.get(x);
                if (element.getLocalName().equals("appid")) {
                    userTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("baseurl")) {
                    ipAddressTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("techtype")) {
                    typeComboBox.setSelectedItem(element.getValue());
                }
                if (element.getLocalName().equals("port")) {
                    portTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("count")) {
                    countTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("channels")) {
                    channelTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("configFile")) {
                    fileNameTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("recordFile")) {
                    recordFileNameTextField.setText(element.getValue());
                }
                if (element.getLocalName().equals("maxTime")) {
                    maxTimeTextField.setText(element.getValue());
                }
//                if(element.getLocalName().equals("stim")) {
//                    stimComboBox.setSelectedItem(element.getValue());
//                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EchoCallbackDemoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DOMSource getXMLSource() {
        DOMSource source = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            org.w3c.dom.Document doc = docBuilder.newDocument();

            org.w3c.dom.Element rootElement = doc.createElement("xmsconfig");
            doc.appendChild(rootElement);

            org.w3c.dom.Element techType = doc.createElement("techtype");
            techType.appendChild(doc.createTextNode(typeComboBox.getSelectedItem().toString()));
            rootElement.appendChild(techType);

            org.w3c.dom.Element baseurl = doc.createElement("baseurl");
            baseurl.appendChild(doc.createTextNode(ipAddressTextField.getText()));
            rootElement.appendChild(baseurl);

            org.w3c.dom.Element appid = doc.createElement("appid");
            appid.appendChild(doc.createTextNode(userTextField.getText()));
            rootElement.appendChild(appid);

            org.w3c.dom.Element port = doc.createElement("port");
            port.appendChild(doc.createTextNode(portTextField.getText()));
            rootElement.appendChild(port);

            org.w3c.dom.Element count = doc.createElement("count");
            count.appendChild(doc.createTextNode(countTextField.getText()));
            rootElement.appendChild(count);

            org.w3c.dom.Element channels = doc.createElement("channels");
            channels.appendChild(doc.createTextNode(channelTextField.getText()));
            rootElement.appendChild(channels);

            org.w3c.dom.Element configFileName = doc.createElement("configFile");
            configFileName.appendChild(doc.createTextNode(fileNameTextField.getText()));
            rootElement.appendChild(configFileName);

            org.w3c.dom.Element recordFileName = doc.createElement("recordFile");
            recordFileName.appendChild(doc.createTextNode(recordFileNameTextField.getText()));
            rootElement.appendChild(recordFileName);

            org.w3c.dom.Element maxTime = doc.createElement("maxTime");
            maxTime.appendChild(doc.createTextNode(maxTimeTextField.getText()));
            rootElement.appendChild(maxTime);

            org.w3c.dom.Element stim = doc.createElement("stim");
            stim.appendChild(doc.createTextNode(stimComboBox.getSelectedItem().toString()));
            rootElement.appendChild(stim);

            source = new DOMSource(doc);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return source;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appIdLabel;
    private javax.swing.JLabel appIdLabel1;
    private javax.swing.JLabel appIdLabel2;
    private javax.swing.JLabel appIdLabel3;
    private javax.swing.JLabel appIdLabel4;
    private javax.swing.JLabel appIdLabel5;
    private javax.swing.JLabel appIdLabel6;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField channelTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField countTextField;
    private javax.swing.JButton enterButton;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JButton fileButton;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JTextField ipAddressTextField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField maxTimeTextField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JTextField recordFileNameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox stimComboBox;
    private javax.swing.JLabel techTypeLabel;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JTextField userTextField;
    private javax.swing.JLabel xmsAddressLAbel;
    // End of variables declaration//GEN-END:variables
}
