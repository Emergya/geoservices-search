package com.emergya.geoservices.search.pois;

import com.emergya.geoservices.search.wsdl.SolrResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author lroman
 */
@Service
public class POISearcherImpl implements POISearcher{

    @Override
    public SolrResponse searchPOIs(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolrResponse searchPOIs(String query, String entitats, Integer filaInicial, Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
