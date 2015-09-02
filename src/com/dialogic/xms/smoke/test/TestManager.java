/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test;

import com.dialogic.xms.smoke.test.examples.EchoCallbackDemo;
import com.dialogic.xms.smoke.gui.Controller;
import com.dialogic.xms.smoke.test.examples.ConnectTest;
import com.dialogic.xms.smoke.test.examples.JoinTest;
import com.dialogic.xms.smoke.test.examples.LoadTest;
import com.dialogic.xms.smoke.test.examples.PlayRecordTest;
import com.dialogic.xms.smoke.test.examples.SimpleConferenceTest;
import com.dialogic.xms.smoke.test.examples.SimpleIVRTest;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ssatyana
 */
public class TestManager implements Runnable {

    Map<Object, String> caseMap;
    static Controller controller;

    public TestManager(Map<Object, String> testCaseMap) {
        this.caseMap = testCaseMap;
        //execute();
    }

    private void execute() {
        Iterator it = caseMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String testname = pair.getValue().toString();

            if (testname.equalsIgnoreCase("EchoCallbackDemo")) {
                EchoCallbackDemo test = (EchoCallbackDemo) pair.getKey();
                Audit audit = test.start();
                writeToFile(audit, "EchoCallbackDemoAudit.xml");
            } else if (testname.equalsIgnoreCase("PlayRecordTest")) {
                PlayRecordTest playRecordTest = (PlayRecordTest) pair.getKey();
                Audit audit = playRecordTest.start();
                writeToFile(audit, "PlayRecordTestAudit.xml");
            } else if (testname.equalsIgnoreCase("ConnectTest")) {
                ConnectTest connectTest = (ConnectTest) pair.getKey();
                Audit audit = connectTest.start();
                writeToFile(audit, "ConnectTestAudit.xml");
            } else if (testname.equalsIgnoreCase("JoinTest")) {
                JoinTest joinTest = (JoinTest) pair.getKey();
                Audit audit = joinTest.start();
                writeToFile(audit, "JoinTestAudit.xml");
            } else if (testname.equalsIgnoreCase("SimpleConferenceTest")) {
                SimpleConferenceTest confTest = (SimpleConferenceTest) pair.getKey();
                Audit audit = confTest.start();
                writeToFile(audit, "SimpleConferenceAudit.xml");
            } else if (testname.equalsIgnoreCase("SimpleIVRTest")) {
                SimpleIVRTest simpleIVRTest = (SimpleIVRTest) pair.getKey();
                Audit audit = simpleIVRTest.start();
                writeToFile(audit, "SimpleIVRAudit.xml");
            } else if (testname.equalsIgnoreCase("LoadTest")) {
                LoadTest loadTest = (LoadTest) pair.getKey();
                Audit audit = loadTest.start();
                writeToFile(audit, "LoadTest.xml");
            }
            it.remove();
        }
        controller.enableButton();
    }

    private void writeToFile(Audit audit, String fileName) {
        try {
            XMLEncoder objectOutputStream = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            objectOutputStream.writeObject(audit);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        controller = new Controller();
    }

    @Override
    public void run() {
        execute();
    }
}
