
package com.emergya.geoservices.search.roads;

import com.emergya.geoservices.search.wsdl.CercaCarreteres;
import com.emergya.geoservices.search.wsdl.RoadResponse;

/**
 *
 * @author lroman
 */
public interface RoadSearcher {
    
    RoadResponse searchRoad(CercaCarreteres search);
    
}
