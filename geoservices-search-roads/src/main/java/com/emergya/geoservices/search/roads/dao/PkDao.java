package com.emergya.geoservices.search.roads.dao;

import com.emergya.geoservices.search.roads.dto.RoadPk;
import java.util.List;

/**
 *
 * @author lroman
 */
public interface PkDao {
    public List<RoadPk> searchPK(String roadName, int desiredPK, int firstRow, int lastRow);
}
