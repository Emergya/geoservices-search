package com.emergya.geoservices.search.roads;

import com.emergya.geoservices.search.wsdl.CercaCarreteres;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author lroman
 */
@Service
public class RoadSearcherImpl implements RoadSearcher{

    @Override
    public RoadResponse searchRoad(CercaCarreteres search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
