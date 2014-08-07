package com.emergya.geoservices.search.ws;

import com.emergya.geoservices.search.roads.RoadSearcher;
import com.emergya.geoservices.search.wsdl.CercaCarreteres;
import com.emergya.geoservices.search.wsdl.Response;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import com.emergya.geoservices.search.wsdl.SearchService;
import com.emergya.geoservices.search.wsdl.SolrResponse;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation for the WS interface for the search geoservices.
 *
 * @author lroman
 */
@WebService(serviceName = "SearchService")
@Stateless()
public class SearchServiceImpl implements SearchService{
    
    @Autowired
    RoadSearcher roadSearcher;

    @Override
    public SolrResponse cercaSolrGeneral(
            @WebParam(name = "query", targetNamespace = "") String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolrResponse cercaSolrParametritzada(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "entitats", targetNamespace = "") String entitats,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response cerca(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "entitats", targetNamespace = "") String entitats,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response cercaGeneral(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoadResponse cercaCarreteres(
            @WebParam(name = "query", targetNamespace = "") String query) {
       
        CercaCarreteres cercaCarreteres = new CercaCarreteres();
        cercaCarreteres.setQuery(query);
        return this.roadSearcher.searchRoad(cercaCarreteres);
    }

}
