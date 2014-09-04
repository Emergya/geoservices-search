package com.emergya.geoservices.search.roads.dao;

import java.util.List;

import com.emergya.geoservices.search.roads.dto.Road;

/**
 *
 * @author marcos
 */
public interface RoadDao {
	public List<Road> searchRoad(String roadName);
}
