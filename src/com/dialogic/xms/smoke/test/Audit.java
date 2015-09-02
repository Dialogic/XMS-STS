/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dialogic.xms.smoke.test;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ssatyana
 */
public class Audit implements Serializable {

    private String auditTestName;
    private String startTime;
    private String testEndTime;
    private String configFileName;
    private Config configContents;
    private Checkpoint lastCheckpoint;
    private List<Checkpoint> testCheckpoints;
    private int checkpointCount;
    private int numPass;
    private int numFail;
    private String testStatus;

    /**
     * @return the auditTestName
     */
    public String getAuditTestName() {
        return auditTestName;
    }

    /**
     * @param auditTestName the auditTestName to set
     */
    public void setAuditTestName(String auditTestName) {
        this.auditTestName = auditTestName;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the testEndTime
     */
    public String getTestEndTime() {
        return testEndTime;
    }

    /**
     * @param testEndTime the testEndTime to set
     */
    public void setTestEndTime(String testEndTime) {
        this.testEndTime = testEndTime;
    }

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
     * @return the configContents
     */
    public Config getConfigContents() {
        return configContents;
    }

    /**
     * @param configContents the configContents to set
     */
    public void setConfigContents(Config configContents) {
        this.configContents = configContents;
    }

    /**
     * @return the lastCheckpoint
     */
    public Checkpoint getLastCheckpoint() {
        return lastCheckpoint;
    }

    /**
     * @param lastCheckpoint the lastCheckpoint to set
     */
    public void setLastCheckpoint(Checkpoint lastCheckpoint) {
        this.lastCheckpoint = lastCheckpoint;
    }

    /**
     * @return the testCheckpoints
     */
    public List<Checkpoint> getTestCheckpoints() {
        return testCheckpoints;
    }

    /**
     * @param testCheckpoints the testCheckpoints to set
     */
    public void setTestCheckpoints(List<Checkpoint> testCheckpoints) {
        this.testCheckpoints = testCheckpoints;
    }

    /**
     * @return the checkpointCount
     */
    public int getCheckpointCount() {
        return checkpointCount;
    }

    /**
     * @param checkpointCount the checkpointCount to set
     */
    public void setCheckpointCount(int checkpointCount) {
        this.checkpointCount = checkpointCount;
    }

    /**
     * @return the numPass
     */
    public int getNumPass() {
        return numPass;
    }

    /**
     * @param numPass the numPass to set
     */
    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    /**
     * @return the numFail
     */
    public int getNumFail() {
        return numFail;
    }

    /**
     * @param numFail the numFail to set
     */
    public void setNumFail(int numFail) {
        this.numFail = numFail;
    }

    /**
     * @return the testStatus
     */
    public String getTestStatus() {
        return testStatus;
    }

    /**
     * @param testStatus the testStatus to set
     */
    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

}
