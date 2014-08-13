package com.emergya.geoservices.search.roads;

import com.emergya.geoservices.search.wsdl.RoadResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author lroman
 */
@Service
public class RoadSearcherImpl implements RoadSearcher{

    @Override
    public RoadResponse searchRoad(String query, String entitats, Integer filaInicial, Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoadResponse searchRoad(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
