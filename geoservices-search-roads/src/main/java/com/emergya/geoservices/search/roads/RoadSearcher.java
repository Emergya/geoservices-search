
package com.emergya.geoservices.search.roads;

import com.emergya.geoservices.search.wsdl.RoadResponse;

/**
 *
 * @author lroman
 */
public interface RoadSearcher {

    public RoadResponse searchRoad(String query);
    
}
