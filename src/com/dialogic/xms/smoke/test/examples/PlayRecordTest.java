/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.xms.smoke.test.stim.PlayRecordTestStim;
import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSConnector;
import com.dialogic.XMSClientLibrary.XMSObjectFactory;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.PlayRecordTestForm;
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
public class PlayRecordTest extends Observable {

    static final Logger logger = Logger.getLogger(PlayRecordTest.class.getName());
    String configName;
    static PlayRecordTestForm form;
    List<Checkpoint> checkpoints = new ArrayList<>();
    boolean stim = Boolean.FALSE;

    public Audit start() {
        Audit playRecordAudit = new Audit();
        if (stim) {
            PlayRecordTestStim stim = new PlayRecordTestStim();
        } else {
            try {
                if (this.getConfigFileName() != null) {
                    playRecordAudit.setAuditTestName("PlayRecordTest");
                    playRecordAudit.setStartTime(Utility.timeStamp());
                    playRecordAudit.setConfigFileName(this.getConfigFileName());
                    playRecordAudit.setConfigContents(Utility.getConfigContents(new FileInputStream(this.getConfigFileName())));

                    XMSObjectFactory myFactory = new XMSObjectFactory();
                    XMSConnector myConnector = myFactory.CreateConnector(this.getConfigFileName());
                    XMSCall call = myFactory.CreateCall(myConnector);

                    Checkpoint waitCall = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall.getShortDesc());
                    XMSReturnCode result = call.Waitcall();
                    waitCall = Utility.setResult(playRecordAudit, waitCall, result, call);
                    this.checkpoints.add(waitCall);

                    call.RecordOptions.SetMaxTime(playRecordAudit.getConfigContents().getMaxTime());
                    call.RecordOptions.SetTerminateDigits("#");
                    setValue("Call Connected");

                    Checkpoint recordStat = Utility.getCheckpoint("Record", "Start Recording");
                    setValue(recordStat.getShortDesc());
                    XMSReturnCode recordResult = call.Record(playRecordAudit.getConfigContents().getRecordFileName());
                    recordStat = Utility.setResult(playRecordAudit, recordStat, recordResult, call);
                    this.checkpoints.add(recordStat);

                    Checkpoint playStat = Utility.getCheckpoint("Play", "Playing");
                    setValue(playStat.getShortDesc());
                    XMSReturnCode playResult = call.Play(playRecordAudit.getConfigContents().getRecordFileName());
                    playStat = Utility.setResult(playRecordAudit, playStat, playResult, call);
                    this.checkpoints.add(playStat);

                    Checkpoint dropStat = Utility.getCheckpoint("FinalDropCall", "Drop call");
                    setValue(dropStat.getShortDesc());
                    XMSReturnCode dropResult = call.Dropcall();
                    dropStat = Utility.setResult(playRecordAudit, dropStat, dropResult, call);
                    this.checkpoints.add(dropStat);

                    playRecordAudit.setCheckpointCount(this.checkpoints.size());
                    playRecordAudit.setTestCheckpoints(this.checkpoints);
                    if (playRecordAudit.getNumFail() > 0) {
                        playRecordAudit.setTestStatus("FAILURE");
                        setValue("FAILURE");
                    } else {
                        playRecordAudit.setTestStatus("SUCCESS");
                        setValue("SUCCESS");
                    }
                } else {
                    System.out.println("NO CONFIG FILE SPECIFIED -> " + configName);
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return playRecordAudit;

    }

    public void configure() {
        form = new PlayRecordTestForm(this);
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
