package com.emergya.geoservices.search.roads;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emergya.geoservices.search.antlr4.PKBaseListener;
import com.emergya.geoservices.search.antlr4.PKLexer;
import com.emergya.geoservices.search.antlr4.PKParser;
import com.emergya.geoservices.search.roads.dao.PkDao;
import com.emergya.geoservices.search.roads.dao.RoadDao;
import com.emergya.geoservices.search.roads.dto.Road;
import com.emergya.geoservices.search.roads.dto.RoadPk;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import com.emergya.geoservices.search.wsdl.RoadResponseItem;
import org.springframework.util.StringUtils;

/**
 *
 * @author lroman
 */
@Service
public class RoadSearcherImpl implements RoadSearcher {

    @Autowired
    private PkDao pkSearchDAO;
    
    @Autowired
    private RoadDao roadSearchDao;
    
    private final static String MISSING_NAME = "<missing Name>";

    @Override
    public RoadResponse searchRoad(final String query) {
    	
    	final AtomicReference<String> wayCode = new AtomicReference<>();
    	final AtomicReference<String> km = new AtomicReference<>();
    	
    	
    	PKLexer l = new PKLexer(new ANTLRInputStream(query));
    	PKParser p = new PKParser(new CommonTokenStream(l));
	    p.addErrorListener(new BaseErrorListener() {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	           // Do nothing
	        }
	    });
	    p.addParseListener(new PKBaseListener(){
	    	@Override
	    	public void exitItem(PKParser.ItemContext ctx){
                if(ctx.waycode==null) {
                    wayCode.set(MISSING_NAME);
                    return;
                }
	    		wayCode.set(ctx.waycode.getText());
	    	}
	    	@Override
	    	public void exitRest(PKParser.RestContext ctx){
	    		km.set(ctx.kmvalue.getText());
	    	}
	    });
	    p.pk();
	    
	    String wayname = wayCode.get();
	    if(MISSING_NAME.equals(wayname)){
	    	wayname = query;
	    }
	    
	    RoadResponse response = new RoadResponse();
	    Integer pk_km = null;
	    if(km.get() != null){
	    	pk_km = Integer.parseInt(km.get());
	    	List<RoadPk> foundPks = pkSearchDAO.searchPK(wayname, pk_km);
	        for (RoadPk pk : foundPks) {
	            RoadResponseItem roadResponseItem = new RoadResponseItem();
	            roadResponseItem.setId(pk.getObjectId());
	            roadResponseItem.setNom(pk.getRoadName());
	            roadResponseItem.setValor((double)pk.getPk());
	            roadResponseItem.setEntitat("y");
	            response.getLst().add(roadResponseItem);
	        }
	    }else{
	    	List<Road> foundRoads = roadSearchDao.searchRoad(wayname);
	    	for(Road r: foundRoads){
	    		RoadResponseItem roadResponseItem = new RoadResponseItem();
	            roadResponseItem.setId(r.getObjectId());
	            roadResponseItem.setNom(r.getRoadName());
	            roadResponseItem.setEntitat("x");
	            response.getLst().add(roadResponseItem);
	    	}
	    }

        return response;
    }

}
