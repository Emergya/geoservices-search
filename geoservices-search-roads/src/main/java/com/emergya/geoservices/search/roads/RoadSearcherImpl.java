package com.emergya.geoservices.search.roads;

import com.emergya.geoservices.search.roads.dao.PkDao;
import com.emergya.geoservices.search.roads.dto.RoadPk;
import com.emergya.geoservices.search.wsdl.RoadResponse;
import com.emergya.geoservices.search.wsdl.RoadResponseItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lroman
 */
@Service
public class RoadSearcherImpl implements RoadSearcher {

    @Autowired
    private PkDao pkSearchDAO;

    @Override
    public RoadResponse searchRoad(String query, String entitats, Integer filaInicial, Integer filaFinal) {

        // TODO: Parser for the query #
        List<RoadPk> foundPks = pkSearchDAO.searchPK("ap-", 15, filaInicial, filaFinal);

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

    @Override
    public RoadResponse searchRoad(String query) {
        return this.searchRoad(query, null, 0, Integer.MAX_VALUE);
    }

}
