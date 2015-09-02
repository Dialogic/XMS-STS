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
public class Checkpoint implements Serializable {

    private String checkpointName;
    private String checkpointStartTime;
    private String checkpointStatus;
    private String shortDesc;
    private String longDesc;

    /**
     * @return the checkpointName
     */
    public String getCheckpointName() {
        return checkpointName;
    }

    /**
     * @param checkpointName the checkpointName to set
     */
    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    /**
     * @return the checkpointStartTime
     */
    public String getCheckpointStartTime() {
        return checkpointStartTime;
    }

    /**
     * @param checkpointStartTime the checkpointStartTime to set
     */
    public void setCheckpointStartTime(String checkpointStartTime) {
        this.checkpointStartTime = checkpointStartTime;
    }

    /**
     * @return the checkpointStatus
     */
    public String getCheckpointStatus() {
        return checkpointStatus;
    }

    /**
     * @param checkpointStatus the checkpointStatus to set
     */
    public void setCheckpointStatus(String checkpointStatus) {
        this.checkpointStatus = checkpointStatus;
    }

    /**
     * @return the shortDesc
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * @param shortDesc the shortDesc to set
     */
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    /**
     * @return the longDesc
     */
    public String getLongDesc() {
        return longDesc;
    }

    /**
     * @param longDesc the longDesc to set
     */
    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

}
