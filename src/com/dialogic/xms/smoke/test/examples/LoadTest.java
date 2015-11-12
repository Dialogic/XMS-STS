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
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ssatyana
 *
 * Load test with 10 calls.
 */
public class LoadTest extends Observable implements Observer {

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

                    LoadTestCallback myCallback1 = new LoadTestCallback();
                    myCallback1.addObserver(this);
                    LoadTestCallback myCallback2 = new LoadTestCallback();
                    myCallback2.addObserver(this);
                    LoadTestCallback myCallback3 = new LoadTestCallback();
                    myCallback3.addObserver(this);
                    LoadTestCallback myCallback4 = new LoadTestCallback();
                    myCallback4.addObserver(this);
                    LoadTestCallback myCallback5 = new LoadTestCallback();
                    myCallback5.addObserver(this);
                    LoadTestCallback myCallback6 = new LoadTestCallback();
                    myCallback6.addObserver(this);
                    LoadTestCallback myCallback7 = new LoadTestCallback();
                    myCallback7.addObserver(this);
                    LoadTestCallback myCallback8 = new LoadTestCallback();
                    myCallback8.addObserver(this);
                    LoadTestCallback myCallback9 = new LoadTestCallback();
                    myCallback9.addObserver(this);
                    LoadTestCallback myCallback10 = new LoadTestCallback();
                    myCallback10.addObserver(this);

                    XMSCall call1 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback1);
                    XMSCall call2 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback2);
                    XMSCall call3 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback3);
                    XMSCall call4 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback4);
                    XMSCall call5 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback5);
                    XMSCall call6 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback6);
                    XMSCall call7 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback7);
                    XMSCall call8 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback8);
                    XMSCall call9 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback9);
                    XMSCall call10 = createCallAndCallbacks(myFactory, myConnector, loadTestAudit, myCallback10);

                    Checkpoint waitCall1 = createWaitCallCheckpoint(1, loadTestAudit);
                    call1.Waitcall();
                    this.checkpoints.add(waitCall1);

                    Checkpoint waitCall2 = createWaitCallCheckpoint(2, loadTestAudit);
                    call2.Waitcall();
                    this.checkpoints.add(waitCall2);

                    Checkpoint waitCall3 = createWaitCallCheckpoint(3, loadTestAudit);
                    call3.Waitcall();
                    this.checkpoints.add(waitCall3);

                    Checkpoint waitCall4 = createWaitCallCheckpoint(4, loadTestAudit);
                    call4.Waitcall();
                    this.checkpoints.add(waitCall4);

                    Checkpoint waitCall5 = createWaitCallCheckpoint(5, loadTestAudit);
                    call5.Waitcall();
                    this.checkpoints.add(waitCall5);

                    Checkpoint waitCall6 = createWaitCallCheckpoint(6, loadTestAudit);
                    call6.Waitcall();
                    this.checkpoints.add(waitCall6);

                    Checkpoint waitCall7 = createWaitCallCheckpoint(7, loadTestAudit);
                    call7.Waitcall();
                    this.checkpoints.add(waitCall7);

                    Checkpoint waitCall8 = createWaitCallCheckpoint(8, loadTestAudit);
                    call8.Waitcall();
                    this.checkpoints.add(waitCall8);

                    Checkpoint waitCall9 = createWaitCallCheckpoint(9, loadTestAudit);
                    call9.Waitcall();
                    this.checkpoints.add(waitCall9);

                    Checkpoint waitCall10 = createWaitCallCheckpoint(10, loadTestAudit);
                    call10.Waitcall();
                    this.checkpoints.add(waitCall10);
                    loadTestAudit.setCheckpointCount(this.checkpoints.size());
                    loadTestAudit.setTestCheckpoints(this.checkpoints);

                    while (!myCallback1.isDone && !myCallback2.isDone && !myCallback3.isDone && !myCallback4.isDone
                            && !myCallback5.isDone && !myCallback6.isDone && !myCallback7.isDone && !myCallback8.isDone
                            && !myCallback9.isDone && !myCallback10.isDone) {
                        Sleep(1000);
                    }

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

    private XMSCall createCallAndCallbacks(XMSObjectFactory myFactory, XMSConnector myConnector,
            Audit loadTestAudit, LoadTestCallback myCallback) {
        XMSCall call = myFactory.CreateCall(myConnector);
        myCallback.setAudit(loadTestAudit);
        call.EnableAllEvents(myCallback);
        return call;
    }

    private Checkpoint createWaitCallCheckpoint(int callnum, Audit audit) {
        Checkpoint ck = null;
        try {
            if (audit.getConfigContents().getType().equalsIgnoreCase("MSML")) {
                ck = Utility.getCheckpoint("WaitCall" + callnum, "Adding to waitCalllist, Call" + callnum + " "
                        + Inet4Address.getLocalHost().getHostAddress() + ":" + audit.getConfigContents().getPort());
            } else if (audit.getConfigContents().getType().equalsIgnoreCase("REST")) {
                Pattern pattern = Pattern.compile("\\/\\/(.*?):");
                Matcher m = pattern.matcher(audit.getConfigContents().getIpAddress());
                String event = "";
                if (m.find()) {
                    event = m.group(1);
                }
                ck = Utility.getCheckpoint("WaitCall" + callnum, "Adding to waitCalllist, Call" + callnum + " "
                        + audit.getConfigContents().getAppID() + "@" + event);
            } else {
                ck = Utility.getCheckpoint("WaitCall" + callnum, "Adding to waitCalllist");
            }
            setValue(ck.getShortDesc());
        } catch (UnknownHostException ex) {
            Logger.getLogger(SimpleConferenceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ck;
    }

    @Override
    public void update(Observable o, Object o1) {
        String message = (String) o1;
        setValue(message);
    }
}
