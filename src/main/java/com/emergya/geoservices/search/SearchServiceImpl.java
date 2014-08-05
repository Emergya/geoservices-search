package com.emergya.geoservices.search;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author lroman
 */
@WebService(serviceName = "SearchService")
@Stateless()
public class SearchServiceImpl implements SearchService{

    @Override
    public SolrResponse cercaSolrGeneral(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolrResponse cercaSolrParametritzada(String query, String entitats, Integer filaInicial, Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response cerca(String query, String entitats, Integer filaInicial, Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response cercaGeneral(String query, Integer filaInicial, Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoadResponse cercaCarreteres(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
