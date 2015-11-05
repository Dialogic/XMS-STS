/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.XMSClientLibrary.*;
import com.dialogic.xms.smoke.test.Audit;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author ssatyana
 */
public class LoadTestCallback extends Observable implements XMSEventCallback {

    boolean isDone = false;
    List<Checkpoint> checkpoints = new ArrayList<>();
    private Audit audit;
    static int counter = 0;

    @Override
    public void ProcessEvent(XMSEvent a_event) {
        XMSCall myCall = a_event.getCall();
        switch (a_event.getEventType()) {
            case CALL_CONNECTED:
                Checkpoint callConnected = Utility.getCheckpoint("Call Connected", "Call Connected");
                setValue("Call Connected");
                Utility.setResult(getAudit(), callConnected, XMSReturnCode.SUCCESS, myCall);
                this.checkpoints.add(callConnected);

                Checkpoint playStat = Utility.getCheckpoint("Play", "Playing");
                setValue(playStat.getShortDesc());
                myCall.Play("smoketest/success");
                this.checkpoints.add(playStat);
                break;
            case CALL_PLAY_END:
                Checkpoint playEnd = Utility.getCheckpoint("Play Ended", "Play Ended");
                setValue("Play Ended");
                Utility.setResult(getAudit(), playEnd, XMSReturnCode.SUCCESS, myCall);
                this.checkpoints.add(playEnd);

                Checkpoint dropStat = Utility.getCheckpoint("DropCall" + counter++, "Drop call");
                setValue("Drop Call");
                XMSReturnCode dropRes = myCall.Dropcall();
                Utility.setResult(getAudit(), dropStat, dropRes, myCall);
                this.checkpoints.add(dropStat);
                break;
            case CALL_DISCONNECTED:  // The far end hung up will simply wait for the media

                break;
            case CALL_INFO:
                if (myCall.getLastEvent().getReason().equalsIgnoreCase("PLAY_END")) {
                    Checkpoint playEnded = Utility.getCheckpoint("Play Ended", "Play Ended");
                    setValue("Play Ended");
                    Utility.setResult(getAudit(), playEnded, XMSReturnCode.SUCCESS, myCall);
                    this.checkpoints.add(playEnded);

                    Checkpoint dropCall = Utility.getCheckpoint("DropCall" + counter++, "Drop call");
                    setValue("Drop Call");
                    XMSReturnCode dropResult = myCall.Dropcall();
                    Utility.setResult(getAudit(), dropCall, dropResult, myCall);
                    this.checkpoints.add(dropCall);
                }
                break;
            default:
                System.out.println("Unknown Event Type!!");
        }
        List<Checkpoint> updatedList = getAudit().getTestCheckpoints();
        if (updatedList != null) {
            updatedList.addAll(this.checkpoints);
        }
        int updatedSize = getAudit().getCheckpointCount() + this.checkpoints.size();
        getAudit().setCheckpointCount(updatedSize);
        getAudit().setTestCheckpoints(updatedList);
        isDone = true;
    }

    public void setValue(String value) {
        setChanged();
        notifyObservers(value);
    }

    /**
     * @return the audit
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * @param audit the audit to set
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

}
