package com.emergya.geoservices.search.pois;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.emergya.geoservices.search.wsdl.SolrResponse;
import com.emergya.geoservices.search.wsdl.SolrResponseItem;

/**
 *
 * @author lroman
 */
@Service
public class POISearcherImpl implements POISearcher {

    @Value("${geoservices.search.pois.solrUrl}")
    private String SOLR_URL;
    @Value("${geoservices.search.pois.charEncode}")
    private String CHAR_ENCODE;

    private SolrServer solrServer;

    @Override
    public SolrResponse searchPOIs(String query) {
        return this.searchPOIs(query, null, 0, 10);
    }

    @Override
    public SolrResponse searchPOIs(String query, String[] layers, Integer firstRow, Integer lastRow) {
        SolrQuery solrQuery = new SolrQuery();

        query =  query.trim();
        
        try {
        	query = new String(query.getBytes(this.CHAR_ENCODE), "UTF-8");
        	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (layers != null && layers.length > 0) {
            query = String.format("layer:(%s) %s", StringUtils.arrayToDelimitedString(StringUtils.trimArrayElements(layers), " "), query);
            solrQuery.addFacetField("layer");
        }

        solrQuery.set("q", query);
        if(firstRow != null && lastRow != null){
        	solrQuery.set("start", firstRow);
        	solrQuery.set("rows", lastRow - firstRow +1);
        }
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
            this.solrServer = new HttpSolrServer(SOLR_URL);
        }

        return this.solrServer;

    }

}
