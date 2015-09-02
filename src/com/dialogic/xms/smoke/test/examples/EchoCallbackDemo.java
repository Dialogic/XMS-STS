/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.xms.smoke.test.stim.EchoCallbackDemoStim;
import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSConnector;
import com.dialogic.XMSClientLibrary.XMSObjectFactory;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.EchoCallbackDemoForm;
import com.dialogic.xms.smoke.test.Audit;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ssatyana
 */
public class EchoCallbackDemo extends Observable {

    static final Logger logger = Logger.getLogger(EchoCallbackDemo.class.getName());
    String configName;
    static EchoCallbackDemoForm form;
    List<Checkpoint> checkpoints = new ArrayList<>();
    boolean stim = Boolean.FALSE;

    public Audit start() {
        Audit echoTestAudit = new Audit();
        if (stim) {
            EchoCallbackDemoStim stim = new EchoCallbackDemoStim();
        } else {
            try {
                if (this.getConfigFileName() != null) {
                    echoTestAudit.setAuditTestName("EchoCallbackDemo");
                    echoTestAudit.setStartTime(Utility.timeStamp());
                    echoTestAudit.setConfigFileName(this.getConfigFileName());
                    echoTestAudit.setConfigContents(Utility.getConfigContents(new FileInputStream(this.getConfigFileName())));

                    XMSObjectFactory myFactory = new XMSObjectFactory();
                    XMSConnector myConnector = myFactory.CreateConnector(this.getConfigFileName());
                    XMSCall call = myFactory.CreateCall(myConnector);

                    Checkpoint waitCall = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall.getShortDesc());
                    XMSReturnCode result = call.Waitcall();
                    waitCall = Utility.setResult(echoTestAudit, waitCall, result, call);
                    this.checkpoints.add(waitCall);

                    String adr = call.getConnectionAddress();
                    System.out.println("ADDRESS! -> " + adr);

                    call.RecordOptions.SetMaxTime(echoTestAudit.getConfigContents().getMaxTime());
                    call.RecordOptions.SetTerminateDigits("#");
                    setValue("Call Connected");

                    Checkpoint recordStat = Utility.getCheckpoint("Record", "Start Recording");
                    setValue(recordStat.getShortDesc());
                    XMSReturnCode recordResult = call.Record(echoTestAudit.getConfigContents().getRecordFileName());
                    recordStat = Utility.setResult(echoTestAudit, recordStat, recordResult, call);
                    this.checkpoints.add(recordStat);

                    Checkpoint dropStat = Utility.getCheckpoint("DropCall", "Drop call");
                    setValue(dropStat.getShortDesc());
                    XMSReturnCode dropResult = call.Dropcall();
                    dropStat = Utility.setResult(echoTestAudit, dropStat, dropResult, call);
                    this.checkpoints.add(dropStat);

                    Checkpoint makeStat = Utility.getCheckpoint("MakeCall", "Making call");
                    setValue(makeStat.getShortDesc());
                    XMSReturnCode makeResult = call.Makecall(adr);
                    makeStat = Utility.setResult(echoTestAudit, makeStat, makeResult, call);
                    this.checkpoints.add(makeStat);

                    Checkpoint playStat = Utility.getCheckpoint("Play", "Playing");
                    setValue(playStat.getShortDesc());
                    XMSReturnCode playResult = call.Play(echoTestAudit.getConfigContents().getRecordFileName());
                    playStat = Utility.setResult(echoTestAudit, playStat, playResult, call);
                    this.checkpoints.add(playStat);

                    Checkpoint secondDropStat = Utility.getCheckpoint("FinalDropCall", "Drop call");
                    setValue(secondDropStat.getShortDesc());
                    XMSReturnCode secondDropResult = call.Dropcall();
                    secondDropStat = Utility.setResult(echoTestAudit, secondDropStat, secondDropResult, call);
                    this.checkpoints.add(secondDropStat);

                    echoTestAudit.setCheckpointCount(this.checkpoints.size());
                    echoTestAudit.setTestCheckpoints(this.checkpoints);
                    if (echoTestAudit.getNumFail() > 0) {
                        echoTestAudit.setTestStatus("FAILURE");
                        setValue("FAILURE");
                    } else {
                        echoTestAudit.setTestStatus("SUCCESS");
                        setValue("SUCCESS");
                    }
                } else {
                    System.out.println("NO CONFIG FILE SPECIFIED -> " + configName);
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return echoTestAudit;

    }

    public void configure() {
        form = new EchoCallbackDemoForm(this);
    }

    public void setConfigFileName(String file) {
        configName = file;
    }

    public String getConfigFileName() {
        System.out.println("filename -> " + configName);
        return configName;
    }

    public void setCount(String count) {
        setValue("Count:" + count);
    }

    public void setisStim() {
        stim = Boolean.TRUE;
    }

    public void isCancelled() {
        setValue("CANCELLED");
    }

    public void setValue(String value) {
        setChanged();
        notifyObservers(value);
    }
}
