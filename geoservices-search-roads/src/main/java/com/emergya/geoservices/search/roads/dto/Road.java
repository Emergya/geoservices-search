package com.emergya.geoservices.search.roads.dto;

/**
 *
 * @author marcos
 */
public class Road {
	private int objectId;
    private String roadName;
    
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
    
    
}
