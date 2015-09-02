/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSConnector;
import com.dialogic.XMSClientLibrary.XMSObjectFactory;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.LoadTestForm;
import com.dialogic.xms.smoke.test.Audit;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;
import com.dialogic.xms.smoke.test.stim.LoadTestStim;
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
public class LoadTest extends Observable {

    static final Logger logger = Logger.getLogger(LoadTest.class.getName());
    String configName;
    static LoadTestForm form;
    List<Checkpoint> checkpoints = new ArrayList<>();
    boolean stim = Boolean.FALSE;

    public Audit start() {
        Audit loadTestAudit = new Audit();
        if (stim) {
            LoadTestStim stim = new LoadTestStim();
        } else {
            try {
                if (this.getConfigFileName() != null) {
                    loadTestAudit.setAuditTestName("LoadTest");
                    loadTestAudit.setStartTime(Utility.timeStamp());
                    loadTestAudit.setConfigFileName(this.getConfigFileName());
                    loadTestAudit.setConfigContents(Utility.getConfigContents(new FileInputStream(this.getConfigFileName())));

                    XMSObjectFactory myFactory = new XMSObjectFactory();
                    XMSConnector myConnector = myFactory.CreateConnector(this.getConfigFileName());

                    XMSCall call1 = myFactory.CreateCall(myConnector);
                    XMSCall call2 = myFactory.CreateCall(myConnector);
                    XMSCall call3 = myFactory.CreateCall(myConnector);
                    XMSCall call4 = myFactory.CreateCall(myConnector);
                    XMSCall call5 = myFactory.CreateCall(myConnector);
                    XMSCall call6 = myFactory.CreateCall(myConnector);
                    XMSCall call7 = myFactory.CreateCall(myConnector);
                    XMSCall call8 = myFactory.CreateCall(myConnector);
                    XMSCall call9 = myFactory.CreateCall(myConnector);
                    XMSCall call10 = myFactory.CreateCall(myConnector);

                    LoadTestCallback myCallback1 = new LoadTestCallback();
                    LoadTestCallback myCallback2 = new LoadTestCallback();
                    LoadTestCallback myCallback3 = new LoadTestCallback();
                    LoadTestCallback myCallback4 = new LoadTestCallback();
                    LoadTestCallback myCallback5 = new LoadTestCallback();
                    LoadTestCallback myCallback6 = new LoadTestCallback();
                    LoadTestCallback myCallback7 = new LoadTestCallback();
                    LoadTestCallback myCallback8 = new LoadTestCallback();
                    LoadTestCallback myCallback9 = new LoadTestCallback();
                    LoadTestCallback myCallback10 = new LoadTestCallback();

                    call1.EnableAllEvents(myCallback1);
                    call2.EnableAllEvents(myCallback2);
                    call3.EnableAllEvents(myCallback3);
                    call4.EnableAllEvents(myCallback4);
                    call5.EnableAllEvents(myCallback5);
                    call6.EnableAllEvents(myCallback6);
                    call7.EnableAllEvents(myCallback7);
                    call8.EnableAllEvents(myCallback8);
                    call9.EnableAllEvents(myCallback9);
                    call10.EnableAllEvents(myCallback10);

                    Checkpoint waitCall1 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall1.getShortDesc());
                    XMSReturnCode result1 = call1.Waitcall();
                    waitCall1 = Utility.setResult(loadTestAudit, waitCall1, result1, call1);
                    this.checkpoints.add(waitCall1);

                    Checkpoint waitCall2 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall2.getShortDesc());
                    XMSReturnCode result2 = call2.Waitcall();
                    waitCall2 = Utility.setResult(loadTestAudit, waitCall2, result2, call2);
                    this.checkpoints.add(waitCall2);

                    Checkpoint waitCall3 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall3.getShortDesc());
                    XMSReturnCode result3 = call3.Waitcall();
                    waitCall3 = Utility.setResult(loadTestAudit, waitCall3, result3, call3);
                    this.checkpoints.add(waitCall3);

                    Checkpoint waitCall4 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall4.getShortDesc());
                    XMSReturnCode result4 = call4.Waitcall();
                    waitCall4 = Utility.setResult(loadTestAudit, waitCall4, result4, call4);
                    this.checkpoints.add(waitCall4);

                    Checkpoint waitCall5 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall5.getShortDesc());
                    XMSReturnCode result5 = call5.Waitcall();
                    waitCall5 = Utility.setResult(loadTestAudit, waitCall5, result5, call5);
                    this.checkpoints.add(waitCall5);

                    Checkpoint waitCall6 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall6.getShortDesc());
                    XMSReturnCode result6 = call6.Waitcall();
                    waitCall6 = Utility.setResult(loadTestAudit, waitCall6, result6, call6);
                    this.checkpoints.add(waitCall6);

                    Checkpoint waitCall7 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall7.getShortDesc());
                    XMSReturnCode result7 = call7.Waitcall();
                    waitCall7 = Utility.setResult(loadTestAudit, waitCall7, result7, call7);
                    this.checkpoints.add(waitCall7);

                    Checkpoint waitCall8 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall8.getShortDesc());
                    XMSReturnCode result8 = call8.Waitcall();
                    waitCall8 = Utility.setResult(loadTestAudit, waitCall8, result8, call8);
                    this.checkpoints.add(waitCall8);

                    Checkpoint waitCall9 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall9.getShortDesc());
                    XMSReturnCode result9 = call9.Waitcall();
                    waitCall9 = Utility.setResult(loadTestAudit, waitCall9, result9, call9);
                    this.checkpoints.add(waitCall9);

                    Checkpoint waitCall10 = Utility.getCheckpoint("WaitCall", "Add to waitCall list");
                    setValue(waitCall10.getShortDesc());
                    XMSReturnCode result10 = call10.Waitcall();
                    waitCall10 = Utility.setResult(loadTestAudit, waitCall10, result10, call10);
                    this.checkpoints.add(waitCall10);

                    Checkpoint playStat = Utility.getCheckpoint("Play", "Playing");
                    setValue(playStat.getShortDesc());
//                    XMSReturnCode playResult = call1.Play("smoketest/success");
//                    playStat = Utility.setResult(loadTestAudit, playStat, playResult, call1);
//                    this.checkpoints.add(playStat);

                    //Utility.Sleep(30000);
//                    Checkpoint dropStat1 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat1.getShortDesc());
//                    XMSReturnCode dropResult1 = call1.Dropcall();
//                    dropStat1 = Utility.setResult(loadTestAudit, dropStat1, dropResult1, call1);
//                    this.checkpoints.add(dropStat1);
//
//                    Checkpoint dropStat2 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat2.getShortDesc());
//                    XMSReturnCode dropResult2 = call2.Dropcall();
//                    dropStat2 = Utility.setResult(loadTestAudit, dropStat2, dropResult2, call2);
//                    this.checkpoints.add(dropStat2);
//
//                    Checkpoint dropStat3 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat3.getShortDesc());
//                    XMSReturnCode dropResult3 = call3.Dropcall();
//                    dropStat3 = Utility.setResult(loadTestAudit, dropStat3, dropResult3, call3);
//                    this.checkpoints.add(dropStat3);
//
//                    Checkpoint dropStat4 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat4.getShortDesc());
//                    XMSReturnCode dropResult4 = call4.Dropcall();
//                    dropStat4 = Utility.setResult(loadTestAudit, dropStat4, dropResult4, call4);
//                    this.checkpoints.add(dropStat4);
//
//                    Checkpoint dropStat5 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat5.getShortDesc());
//                    XMSReturnCode dropResult5 = call5.Dropcall();
//                    dropStat5 = Utility.setResult(loadTestAudit, dropStat5, dropResult5, call5);
//                    this.checkpoints.add(dropStat5);
//
//                    Checkpoint dropStat6 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat6.getShortDesc());
//                    XMSReturnCode dropResult6 = call6.Dropcall();
//                    dropStat6 = Utility.setResult(loadTestAudit, dropStat6, dropResult6, call6);
//                    this.checkpoints.add(dropStat6);
//
//                    Checkpoint dropStat7 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat7.getShortDesc());
//                    XMSReturnCode dropResult7 = call7.Dropcall();
//                    dropStat7 = Utility.setResult(loadTestAudit, dropStat7, dropResult7, call7);
//                    this.checkpoints.add(dropStat7);
//
//                    Checkpoint dropStat8 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat8.getShortDesc());
//                    XMSReturnCode dropResult8 = call8.Dropcall();
//                    dropStat8 = Utility.setResult(loadTestAudit, dropStat8, dropResult8, call8);
//                    this.checkpoints.add(dropStat8);
//
//                    Checkpoint dropStat9 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat9.getShortDesc());
//                    XMSReturnCode dropResult9 = call9.Dropcall();
//                    dropStat9 = Utility.setResult(loadTestAudit, dropStat9, dropResult9, call9);
//                    this.checkpoints.add(dropStat9);
//
//                    Checkpoint dropStat10 = Utility.getCheckpoint("DropCall", "Drop call");
//                    setValue(dropStat10.getShortDesc());
//                    XMSReturnCode dropResult10 = call10.Dropcall();
//                    dropStat10 = Utility.setResult(loadTestAudit, dropStat10, dropResult10, call10);
//                    this.checkpoints.add(dropStat10);
                    //At this point event handler thread will process all events so this thread just waits to complete
                    while (!myCallback1.isDone && !myCallback2.isDone && !myCallback3.isDone && !myCallback4.isDone
                            && !myCallback5.isDone && !myCallback6.isDone && !myCallback7.isDone && !myCallback8.isDone
                            && !myCallback9.isDone && !myCallback10.isDone) {
                        Sleep(1000);
                    }

                    Checkpoint dropStat1 = Utility.getCheckpoint("DropCall", "Drop call");
                    setValue(dropStat1.getShortDesc());

                    loadTestAudit.setCheckpointCount(this.checkpoints.size());
                    loadTestAudit.setTestCheckpoints(this.checkpoints);
                    if (loadTestAudit.getNumFail() > 0) {
                        loadTestAudit.setTestStatus("FAILURE");
                        setValue("FAILURE");
                    } else {
                        loadTestAudit.setTestStatus("SUCCESS");
                        setValue("SUCCESS");
                    }
                } else {
                    System.out.println("NO CONFIG FILE SPECIFIED -> " + configName);
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return loadTestAudit;

    }

    public static void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.print(ex);
        }

    }

    public void configure() {
        form = new LoadTestForm(this);
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
