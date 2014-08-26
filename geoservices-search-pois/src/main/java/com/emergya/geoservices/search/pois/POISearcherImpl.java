package com.emergya.geoservices.search.pois;

import com.emergya.geoservices.search.wsdl.SolrResponse;
import com.emergya.geoservices.search.wsdl.SolrResponseItem;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author lroman
 */
@Service
public class POISearcherImpl implements POISearcher {

    String solrUrl = "http://localhost:8983/solr/poi-search";

    SolrServer solrServer;

    @Override
    public SolrResponse searchPOIs(String query) {
        return this.searchPOIs(query, null, 0, 10);
    }

    @Override
    public SolrResponse searchPOIs(String query, String[] entitats, Integer filaInicial, Integer filaFinal) {
        SolrQuery solrQuery = new SolrQuery();

        query =  query.trim();

        if (entitats != null && entitats.length > 0) {
            query = String.format("layer:(%s) %s", StringUtils.arrayToDelimitedString(StringUtils.trimArrayElements(entitats), " "), query);
            solrQuery.addFacetField("layer");
        }

        solrQuery.set("q", query);

        QueryResponse solrResult;
        try {
            solrResult = this.getSolrServer().query(solrQuery);
        } catch (SolrServerException ex) {
            Logger.getLogger(POISearcherImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        SolrResponse response = new SolrResponse();
        SolrDocumentList solrDocsInfo = solrResult.getResults();

        response.setElapsedTime(solrResult.getElapsedTime());
        response.setTotalHits(solrDocsInfo.getNumFound());

        for (SolrDocument doc : solrDocsInfo) {
            SolrResponseItem solrResponseItem = new SolrResponseItem();
            solrResponseItem.setId(Long.parseLong((String) doc.getFieldValue("id")));
            solrResponseItem.setNom((String) doc.getFieldValue("name"));
            solrResponseItem.setMunicipi((String) doc.getFieldValue("locality"));
            solrResponseItem.setTipus((String) doc.getFieldValue("type"));
            solrResponseItem.setEntitat((String) doc.getFieldValue("layer"));
            solrResponseItem.setUtmX((double) doc.getFieldValue("utmX"));
            solrResponseItem.setUtmY((double) doc.getFieldValue("utmY"));
   
            // TODO: retrieve coordinates!
            solrResponseItem.setScore((float) doc.getFieldValue("score"));

            response.getLst().add(solrResponseItem);
        }

        return response;
    }

    private SolrServer getSolrServer() {
        if (this.solrServer == null) {
            this.solrServer = new HttpSolrServer(solrUrl);
        }

        return this.solrServer;

    }

}
