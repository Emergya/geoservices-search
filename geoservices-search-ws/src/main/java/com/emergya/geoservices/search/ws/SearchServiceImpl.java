package com.emergya.geoservices.search.ws;

import com.emergya.geoservices.search.pois.POISearcher;
import com.emergya.geoservices.search.roads.RoadSearcher;
import com.emergya.geoservices.search.wsdl.Response;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import com.emergya.geoservices.search.wsdl.SearchService;
import com.emergya.geoservices.search.wsdl.SolrResponse;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Implementation for the WS interface for the search geoservices.
 *
 * @author lroman
 */
@WebService(serviceName = "SearchService")
@Stateless()
public class SearchServiceImpl implements SearchService {

    @Autowired
    RoadSearcher roadSearcher;

    @Autowired
    POISearcher poiSearcher;

    @Override
    public SolrResponse cercaSolrGeneral(
            @WebParam(name = "query", targetNamespace = "") String query) {

        return poiSearcher.searchPOIs(query);

    }

    @Override
    public SolrResponse cercaSolrParametritzada(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "entitats", targetNamespace = "") String entitats,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {
        return poiSearcher.searchPOIs(query, StringUtils.commaDelimitedListToStringArray(entitats), filaInicial, filaFinal);
    }

    @Override
    public Response cerca(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "entitats", targetNamespace = "") String entitats,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {

        Response response = new Response();
        String[] entitatsA = StringUtils.commaDelimitedListToStringArray(entitats);
        response.setRoadResponse(roadSearcher.searchRoad(query));
        response.setSolrResponse(poiSearcher.searchPOIs(query, entitatsA, filaInicial, filaFinal));
        return response;
    }

    @Override
    public Response cercaGeneral(
            @WebParam(name = "query", targetNamespace = "") String query,
            @WebParam(name = "filaInicial", targetNamespace = "") Integer filaInicial,
            @WebParam(name = "filaFinal", targetNamespace = "") Integer filaFinal) {
        Response response = new Response();
        response.setRoadResponse(roadSearcher.searchRoad(query));
        response.setSolrResponse(poiSearcher.searchPOIs(query, null, filaInicial, filaFinal));

        return response;
    }

    @Override
    public RoadResponse cercaCarreteres(
            @WebParam(name = "query", targetNamespace = "") String query) {

        RoadResponse response = this.roadSearcher.searchRoad(query);
        return response;
    }

}
