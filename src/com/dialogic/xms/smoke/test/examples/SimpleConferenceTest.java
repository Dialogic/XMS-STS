/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSConference;
import com.dialogic.XMSClientLibrary.XMSConnector;
import com.dialogic.XMSClientLibrary.XMSMediaType;
import com.dialogic.XMSClientLibrary.XMSObjectFactory;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.SimpleConferenceTestForm;
import com.dialogic.xms.smoke.test.Audit;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;
import com.dialogic.xms.smoke.test.stim.SimpleConferenceTestStim;
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
public class SimpleConferenceTest extends Observable {

    static final Logger logger = Logger.getLogger(SimpleConferenceTest.class.getName());
    String configName;
    static SimpleConferenceTestForm form;
    List<Checkpoint> checkpoints = new ArrayList<>();
    boolean stim = Boolean.FALSE;

    public Audit start() {
        Audit conferenceTestAudit = new Audit();
        if (stim) {
            SimpleConferenceTestStim stim = new SimpleConferenceTestStim();
        } else {
            try {
                if (this.getConfigFileName() != null) {
                    conferenceTestAudit.setAuditTestName("SimpleConferenceTest");
                    conferenceTestAudit.setStartTime(Utility.timeStamp());
                    conferenceTestAudit.setConfigFileName(this.getConfigFileName());
                    conferenceTestAudit.setConfigContents(Utility.getConfigContents(new FileInputStream(this.getConfigFileName())));

                    XMSObjectFactory myFactory = new XMSObjectFactory();
                    XMSConnector myConnector = myFactory.CreateConnector(this.getConfigFileName());
                    XMSCall call1 = myFactory.CreateCall(myConnector);
                    XMSCall call2 = myFactory.CreateCall(myConnector);
                    XMSCall call3 = myFactory.CreateCall(myConnector);

                    Checkpoint conf = Utility.getCheckpoint("Create Conference", "Creating a Conference");
                    setValue(conf.getShortDesc());
                    XMSConference myConf = myFactory.CreateConference(myConnector);
                    if (myConf == null) {
                        conf.setCheckpointStatus("FAILURE");
                        conferenceTestAudit.setNumFail(1);
                        this.checkpoints.add(conf);
                    } else {
                        conf.setCheckpointStatus("SUCCESS");
                        conferenceTestAudit.setNumPass(1);
                        if (myConf.getLastEvent() != null) {
                            conf.setLongDesc(myConf.getLastEvent().getInternalData());
                        }
                        this.checkpoints.add(conf);

                        Checkpoint waitCall1 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                        setValue(waitCall1.getShortDesc());
                        call1.WaitcallOptions.SetMediaType(XMSMediaType.VIDEO);
                        XMSReturnCode result1 = call1.Waitcall();
                        waitCall1 = Utility.setResult(conferenceTestAudit, waitCall1, result1, call1);
                        this.checkpoints.add(waitCall1);
                        setValue("Call1 Connected");

                        // play prompt adding to conf
                        Checkpoint playPrompt1 = Utility.getCheckpoint("Play Prompt", "Play prompt");
                        setValue(playPrompt1.getShortDesc());
                        XMSReturnCode playResult1 = call1.Play("smoketest/conf");
                        playPrompt1 = Utility.setResult(conferenceTestAudit, playPrompt1, playResult1, call1);
                        this.checkpoints.add(playPrompt1);

                        Checkpoint add1 = Utility.getCheckpoint("AddCall1", "Adding call1 to conference");
                        setValue(add1.getShortDesc());
                        XMSReturnCode addResult1 = myConf.Add(call1);
                        add1 = Utility.setResult(conferenceTestAudit, add1, addResult1, call1);
                        this.checkpoints.add(add1);

                        Checkpoint waitCall2 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                        setValue(waitCall2.getShortDesc());
                        call2.WaitcallOptions.SetMediaType(XMSMediaType.VIDEO);
                        XMSReturnCode result2 = call2.Waitcall();
                        waitCall2 = Utility.setResult(conferenceTestAudit, waitCall2, result2, call2);
                        this.checkpoints.add(waitCall2);
                        setValue("Call2 Connected");

                        // play prompt adding to conf
                        Checkpoint playPrompt2 = Utility.getCheckpoint("Play Prompt", "Play prompt");
                        setValue(playPrompt2.getShortDesc());
                        XMSReturnCode playResult2 = call2.Play("smoketest/conf");
                        playPrompt2 = Utility.setResult(conferenceTestAudit, playPrompt2, playResult2, call2);
                        this.checkpoints.add(playPrompt2);

                        Checkpoint add2 = Utility.getCheckpoint("AddCall2", "Adding call2 to conference");
                        setValue(add2.getShortDesc());
                        XMSReturnCode addResult2 = myConf.Add(call2);
                        add2 = Utility.setResult(conferenceTestAudit, add2, addResult2, call2);
                        this.checkpoints.add(add2);

                        Checkpoint waitCall3 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                        setValue(waitCall3.getShortDesc());
                        call3.WaitcallOptions.SetMediaType(XMSMediaType.VIDEO);
                        XMSReturnCode result3 = call3.Waitcall();
                        waitCall3 = Utility.setResult(conferenceTestAudit, waitCall3, result3, call3);
                        this.checkpoints.add(waitCall3);
                        setValue("Call3 Connected");

                        // play prompt adding to conf
                        Checkpoint playPrompt3 = Utility.getCheckpoint("Play Prompt", "Play prompt");
                        setValue(playPrompt3.getShortDesc());
                        XMSReturnCode playResult3 = call3.Play("smoketest/conf");
                        playPrompt3 = Utility.setResult(conferenceTestAudit, playPrompt3, playResult3, call3);
                        this.checkpoints.add(playPrompt3);

                        Checkpoint add3 = Utility.getCheckpoint("AddCall3", "Adding call3 to conference");
                        setValue(add3.getShortDesc());
                        XMSReturnCode addResult3 = myConf.Add(call3);
                        add3 = Utility.setResult(conferenceTestAudit, add3, addResult3, call3);
                        this.checkpoints.add(add3);

                        Utility.Sleep(20000);

                        Checkpoint drop1 = Utility.getCheckpoint("DropCall1", "Drop call1");
                        setValue(drop1.getShortDesc());
                        XMSReturnCode dropResult1 = call1.Dropcall();
                        drop1 = Utility.setResult(conferenceTestAudit, drop1, dropResult1, call1);
                        this.checkpoints.add(drop1);

                        Checkpoint drop2 = Utility.getCheckpoint("DropCall2", "Drop call2");
                        setValue(drop2.getShortDesc());
                        XMSReturnCode dropResult2 = call2.Dropcall();
                        drop2 = Utility.setResult(conferenceTestAudit, drop2, dropResult2, call2);
                        this.checkpoints.add(drop2);

                        Checkpoint drop3 = Utility.getCheckpoint("DropCall3", "Drop call3");
                        setValue(drop3.getShortDesc());
                        XMSReturnCode dropResult3 = call3.Dropcall();
                        drop3 = Utility.setResult(conferenceTestAudit, drop3, dropResult3, call3);
                        this.checkpoints.add(drop3);
                    }

                    conferenceTestAudit.setCheckpointCount(this.checkpoints.size());
                    conferenceTestAudit.setTestCheckpoints(this.checkpoints);
                    if (conferenceTestAudit.getNumFail() > 0) {
                        conferenceTestAudit.setTestStatus("FAILURE");
                        setValue("FAILURE");
                    } else {
                        conferenceTestAudit.setTestStatus("SUCCESS");
                        setValue("SUCCESS");
                    }
                } else {
                    System.out.println("NO CONFIG FILE SPECIFIED -> " + configName);
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return conferenceTestAudit;

    }

    public void configure() {
        form = new SimpleConferenceTestForm(this);
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
