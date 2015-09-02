/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test.examples;

import com.dialogic.XMSClientLibrary.*;
import com.dialogic.xms.smoke.test.Checkpoint;
import com.dialogic.xms.smoke.test.Utility;

/**
 *
 * @author dwolansk
 */
enum AppState {

    WAITCALL,
    RECORD,
    MAKECALL,
    PLAY
}

public class LoadTestCallback implements XMSEventCallback {

    String addr = "";
    AppState myState = AppState.WAITCALL;
    boolean isDone = false;

    @Override
    public void ProcessEvent(XMSEvent a_event) {
        //throw new UnsupportedOperationException("Not supported yet.");
        XMSCall myCall = a_event.getCall();
        switch (a_event.getEventType()) {
            case CALL_CONNECTED:
                myCall.Play("smoketest/success");
                break;
            case CALL_PLAY_END:
                myCall.Dropcall();
                isDone = true;
                break;
            case CALL_DISCONNECTED:  // The far end hung up will simply wait for the media

                break;
            case CALL_INFO:
                break;
            default:
                System.out.println("Unknown Event Type!!");
        }
    }
}
