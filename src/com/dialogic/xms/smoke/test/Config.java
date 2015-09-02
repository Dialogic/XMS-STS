/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test;

import java.io.Serializable;

/**
 *
 * @author ssatyana
 */
public class Config implements Serializable {

    private String configFileName;
    private String ipAddress;
    private String appID;
    private String type;
    private int count;
    private int channels;
    private String recordFileName;
    private String playFileName;
    private String stim;
    private boolean video;
    private int maxTime;
    private String outboundAddress;
    private String callType;

    /**
     * @return the configFileName
     */
    public String getConfigFileName() {
        return configFileName;
    }

    /**
     * @param configFileName the configFileName to set
     */
    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the appID
     */
    public String getAppID() {
        return appID;
    }

    /**
     * @param appID the appID to set
     */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    /**
     * @return the type, either MSML or REST
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the channels
     */
    public int getChannels() {
        return channels;
    }

    /**
     * @param channels the channels to set
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * @return the recordFileName
     */
    public String getRecordFileName() {
        return recordFileName;
    }

    /**
     * @param recordFileName the recordFileName to set
     */
    public void setRecordFileName(String recordFileName) {
        this.recordFileName = recordFileName;
    }

    /**
     * @return the playFileName
     */
    public String getPlayFileName() {
        return playFileName;
    }

    /**
     * @param playFileName the playFileName to set
     */
    public void setPlayFileName(String playFileName) {
        this.playFileName = playFileName;
    }

    /**
     * @return the stim
     */
    public String getStim() {
        return stim;
    }

    /**
     * @param stim the stim to set
     */
    public void setStim(String stim) {
        this.stim = stim;
    }

    /**
     * @return the video
     */
    public boolean isVideo() {
        return video;
    }

    /**
     * @param video the video to set
     */
    public void setVideo(boolean video) {
        this.video = video;
    }

    /**
     * @return the maxTime
     */
    public int getMaxTime() {
        return maxTime;
    }

    /**
     * @param maxTime the maxTime to set
     */
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    /**
     * @return the outboundAddress
     */
    public String getOutboundAddress() {
        return outboundAddress;
    }

    /**
     * @param outboundAddress the outboundAddress to set
     */
    public void setOutboundAddress(String outboundAddress) {
        this.outboundAddress = outboundAddress;
    }

    /**
     * @return the callType, either inbound or outbound.
     */
    public String getCallType() {
        return callType;
    }

    /**
     * @param callType the callType to set
     */
    public void setCallType(String callType) {
        this.callType = callType;
    }

}
