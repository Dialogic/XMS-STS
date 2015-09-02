/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test;

import com.dialogic.XMSClientLibrary.XMSCall;
import com.dialogic.XMSClientLibrary.XMSReturnCode;
import com.dialogic.xms.smoke.gui.EchoCallbackDemoForm;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/**
 *
 * @author ssatyana
 */
public class Utility {

    private static int count = 0;

    public static String timeStamp() {
        return new SimpleDateFormat("[HH:mm:ss.SSS] ").format(Calendar.getInstance().getTime());
    }

    public static Checkpoint getCheckpoint(String name, String desc) {
        Checkpoint ckpt = new Checkpoint();
        ckpt.setCheckpointName(name);
        ckpt.setCheckpointStartTime(timeStamp());
        ckpt.setShortDesc(desc);
        return ckpt;
    }

    public static Checkpoint setResult(Audit audit, Checkpoint ck, XMSReturnCode status, XMSCall call) {
        if (status.equals(XMSReturnCode.SUCCESS)) {
            ck.setCheckpointStatus("SUCCESS");
            audit.setNumPass(count++);
        } else {
            ck.setCheckpointStatus("FAILURE");
            audit.setNumFail(count++);
        }
        ck.setLongDesc(call.getLastEvent().getInternalData());
        return ck;
    }

    public static Config getConfigContents(FileInputStream file) {
        Config config = new Config();
        Document doc;
        try {
            doc = new Builder().build(file);
            Element root = doc.getRootElement();
            Elements entries = root.getChildElements();
            for (int x = 0; x < entries.size(); x++) {
                Element element = entries.get(x);
                if (element.getLocalName().equals("appid")) {
                    config.setAppID(element.getValue());
                }
                if (element.getLocalName().equals("baseurl")) {
                    config.setIpAddress(element.getValue());
                }
                if (element.getLocalName().equals("techtype")) {
                    config.setType(element.getValue());
                }
                if (element.getLocalName().equals("count")) {
                    config.setCount(Integer.parseInt(element.getValue()));
                }
                if (element.getLocalName().equals("channels")) {
                    config.setChannels(Integer.parseInt(element.getValue()));
                }
                if (element.getLocalName().equals("stim")) {
                    config.setStim(element.getValue());
                }
                if (element.getLocalName().equals("recordFile")) {
                    config.setRecordFileName(element.getValue());
                }
                if (element.getLocalName().equals("playFile")) {
                    config.setPlayFileName(element.getValue());
                }
                if (element.getLocalName().equals("video")) {
                    config.setVideo(Boolean.parseBoolean(element.getValue()));
                }
                if (element.getLocalName().equals("maxTime")) {
                    config.setMaxTime(Integer.parseInt(element.getValue()));
                }
                if (element.getLocalName().equals("callType")) {
                    config.setCallType(element.getValue());
                }
                if (element.getLocalName().equals("outboundAddress")) {
                    config.setOutboundAddress(element.getValue());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EchoCallbackDemoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }

    public static void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.print(ex);
        }
    }
}
