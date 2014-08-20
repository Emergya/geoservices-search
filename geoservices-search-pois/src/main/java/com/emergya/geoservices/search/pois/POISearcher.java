package com.emergya.geoservices.search.pois;

import com.emergya.geoservices.search.wsdl.SolrResponse;

/**
 *
 * @author lroman
 */
public interface POISearcher {
    
    public SolrResponse searchPOIs(String query);

    public SolrResponse searchPOIs(String query, String[] entitats, Integer filaInicial, Integer filaFinal);
    
}
