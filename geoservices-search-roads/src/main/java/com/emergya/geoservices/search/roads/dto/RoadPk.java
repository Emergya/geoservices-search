package com.emergya.geoservices.search.roads.dto;

/**
 *
 * @author lroman
 */
public class RoadPk {
    private int objectId;
    private String roadName;
    private int pk;

    /**
     * @return the objectId
     */
    public int getObjectId() {
        return objectId;
    }

    /**
     * @param objectId the objectId to set
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    /**
     * @return the roadName
     */
    public String getRoadName() {
        return roadName;
    }

    /**
     * @param roadName the roadName to set
     */
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    /**
     * @return the pk
     */
    public int getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(int pk) {
        this.pk = pk;
    }
    
}
