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
import com.emergya.geoservices.search.roads.dto.RoadPk;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import com.emergya.geoservices.search.wsdl.RoadResponseItem;

/**
 *
 * @author lroman
 */
@Service
public class RoadSearcherImpl implements RoadSearcher {

    @Autowired
    private PkDao pkSearchDAO;

    @Override
    public RoadResponse searchRoad(String query) {
    	
    	final AtomicReference<String> wayCode = new AtomicReference<>();
    	final AtomicReference<String> km = new AtomicReference<>();
    	
    	PKLexer l = new PKLexer(new ANTLRInputStream(query));
    	PKParser p = new PKParser(new CommonTokenStream(l));
	    p.addErrorListener(new BaseErrorListener() {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	            throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
	        }
	    });
	    p.addParseListener(new PKBaseListener(){
	    	@Override
	    	public void exitItem(PKParser.ItemContext ctx){
	    		wayCode.set(ctx.waycode.getText());
	    	}
	    	@Override
	    	public void exitRest(PKParser.RestContext ctx){
	    		km.set(ctx.kmvalue.getText());
	    	}
	    });
	    p.pk();
	    
	    String wayname = wayCode.get();
	    Integer pk_km = new Integer(0);
	    if(km.get() != null){
	    	pk_km = Integer.parseInt(km.get());
	    }
	    
        List<RoadPk> foundPks = pkSearchDAO.searchPK(wayname, pk_km);

        RoadResponse response = new RoadResponse();

        for (RoadPk pk : foundPks) {
            RoadResponseItem roadResponseItem = new RoadResponseItem();
            roadResponseItem.setId(pk.getObjectId());
            roadResponseItem.setNom(pk.getRoadName());
            roadResponseItem.setValor((double)pk.getPk());
            
            response.getLst().add(roadResponseItem);
        }

        return response;
    }

}
