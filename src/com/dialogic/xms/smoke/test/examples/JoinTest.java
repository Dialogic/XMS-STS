/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.xms.smoke.test.stim.JoinTestStim;
import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSConnector;
import com.dialogic.XMSClientLibrary.XMSMediaType;
import com.dialogic.XMSClientLibrary.XMSObjectFactory;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.JoinTestForm;
import com.dialogic.xms.smoke.test.Audit;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;
import java.io.FileInputStream;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ssatyana
 */
public class JoinTest extends Observable {

    static final Logger logger = Logger.getLogger(JoinTest.class.getName());
    String configName;
    static JoinTestForm form;
    List<Checkpoint> checkpoints = new ArrayList<>();
    boolean stim = Boolean.FALSE;

    public Audit start() {
        Audit joinTestAudit = new Audit();
        if (stim) {
            JoinTestStim stim = new JoinTestStim();
        } else {
            try {
                if (this.getConfigFileName() != null) {
                    joinTestAudit.setAuditTestName("JoinTest");
                    joinTestAudit.setStartTime(Utility.timeStamp());
                    joinTestAudit.setConfigFileName(this.getConfigFileName());
                    joinTestAudit.setConfigContents(Utility.getConfigContents(new FileInputStream(this.getConfigFileName())));

                    XMSObjectFactory myFactory = new XMSObjectFactory();
                    XMSConnector myConnector = myFactory.CreateConnector(this.getConfigFileName());
                    XMSCall call1 = myFactory.CreateCall(myConnector);
                    XMSCall call2 = myFactory.CreateCall(myConnector);

                    call1.WaitcallOptions.SetMediaType(XMSMediaType.VIDEO);
                    Checkpoint waitCall1 = null;
                    if (joinTestAudit.getConfigContents().getType().equalsIgnoreCase("MSML")) {
                        waitCall1 = Utility.getCheckpoint("WaitCall1", "Adding to waitCalllist, Call "
                                + Inet4Address.getLocalHost().getHostAddress() + ":" + joinTestAudit.getConfigContents().getPort());
                    } else if (joinTestAudit.getConfigContents().getType().equalsIgnoreCase("REST")) {
                        Pattern pattern = Pattern.compile("\\/\\/(.*?):");
                        Matcher m = pattern.matcher(joinTestAudit.getConfigContents().getIpAddress());
                        String event = "";
                        if (m.find()) {
                            event = m.group(1);
                        }
                        waitCall1 = Utility.getCheckpoint("WaitCall", "Adding to waitCalllist, Call "
                                + joinTestAudit.getConfigContents().getAppID() + "@" + event);
                    } else {
                        waitCall1 = Utility.getCheckpoint("WaitCall1", "Adding to waitCalllist");
                    }
                    setValue(waitCall1.getShortDesc());
                    XMSReturnCode result1 = call1.Waitcall();
                    waitCall1 = Utility.setResult(joinTestAudit, waitCall1, result1, call1);
                    this.checkpoints.add(waitCall1);
                    setValue("Call1 Connected");

                    //play prompt to call1 - Please wait for second caller to join
                    Checkpoint playPrompt1 = Utility.getCheckpoint("Play Prompt", "Play prompt");
                    setValue(playPrompt1.getShortDesc());
                    XMSReturnCode playResult1 = call1.Play("smoketest/join1");
                    playPrompt1 = Utility.setResult(joinTestAudit, playPrompt1, playResult1, call1);
                    this.checkpoints.add(playPrompt1);

                    call2.WaitcallOptions.SetMediaType(XMSMediaType.VIDEO);
                    Checkpoint waitCall2 = null;
                    if (joinTestAudit.getConfigContents().getType().equalsIgnoreCase("MSML")) {
                        waitCall2 = Utility.getCheckpoint("WaitCall2", "Adding to waitCalllist, Call "
                                + Inet4Address.getLocalHost().getHostAddress() + ":" + joinTestAudit.getConfigContents().getPort());
                    } else if (joinTestAudit.getConfigContents().getType().equalsIgnoreCase("REST")) {
                        Pattern pattern = Pattern.compile("\\/\\/(.*?):");
                        Matcher m = pattern.matcher(joinTestAudit.getConfigContents().getIpAddress());
                        String event = "";
                        if (m.find()) {
                            event = m.group(1);
                        }
                        waitCall2 = Utility.getCheckpoint("WaitCall2", "Adding to waitCalllist, Call "
                                + joinTestAudit.getConfigContents().getAppID() + "@" + event);
                    } else {
                        waitCall2 = Utility.getCheckpoint("WaitCall2", "Adding to waitCalllist");
                    }
                    setValue(waitCall2.getShortDesc());
                    XMSReturnCode result2 = call2.Waitcall();
                    waitCall2 = Utility.setResult(joinTestAudit, waitCall2, result2, call2);
                    this.checkpoints.add(waitCall2);
                    setValue("Call2 Connected");

                    // play prompt to call1 - Now joining with first caller
                    Checkpoint playPrompt2 = Utility.getCheckpoint("Play Prompt", "Play prompt");
                    setValue(playPrompt2.getShortDesc());
                    XMSReturnCode playResult2 = call2.Play("smoketest/join2");
                    playPrompt2 = Utility.setResult(joinTestAudit, playPrompt2, playResult2, call2);
                    this.checkpoints.add(playPrompt2);

                    // join call1 and call2
                    Checkpoint joinStat = Utility.getCheckpoint("Join", "Joining the calls");
                    setValue(joinStat.getShortDesc());
                    XMSReturnCode joinResult = call1.Join(call2);
                    joinStat = Utility.setResult(joinTestAudit, joinStat, joinResult, call1);
                    this.checkpoints.add(joinStat);
                    setValue("Joined");

                    Utility.Sleep(20000);

                    Checkpoint dropStat1 = Utility.getCheckpoint("DropCall1", "Drop caller 1");
                    setValue(dropStat1.getShortDesc());
                    XMSReturnCode dropResult1 = call1.Dropcall();
                    dropStat1 = Utility.setResult(joinTestAudit, dropStat1, dropResult1, call1);
                    this.checkpoints.add(dropStat1);

                    Checkpoint dropStat2 = Utility.getCheckpoint("DropCall2", "Drop caller 2");
                    setValue(dropStat2.getShortDesc());
                    XMSReturnCode dropResult2 = call2.Dropcall();
                    dropStat2 = Utility.setResult(joinTestAudit, dropStat2, dropResult2, call2);
                    this.checkpoints.add(dropStat2);

                    joinTestAudit.setCheckpointCount(this.checkpoints.size());
                    joinTestAudit.setTestCheckpoints(this.checkpoints);
                    if (joinTestAudit.getNumFail() > 0) {
                        joinTestAudit.setTestStatus("FAILURE");
                        setValue("FAILURE");
                    } else {
                        joinTestAudit.setTestStatus("SUCCESS");
                        setValue("SUCCESS");
                    }
                } else {
                    System.out.println("NO CONFIG FILE SPECIFIED -> " + configName);
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return joinTestAudit;

    }

    public void configure() {
        form = new JoinTestForm(this);
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
