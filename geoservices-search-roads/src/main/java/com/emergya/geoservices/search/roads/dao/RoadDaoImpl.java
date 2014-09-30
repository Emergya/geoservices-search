package com.emergya.geoservices.search.roads.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.emergya.geoservices.search.roads.dto.Road;

/**
 *
 * @author marcos
 */
@Repository
public class RoadDaoImpl extends JdbcBaseDao implements RoadDao {
	
	private static final RoadDataMapper MAPPER = new RoadDataMapper();
	@Value("${geoservices.search.roads.roadsdatabase}")
    private String ROADS_DATA_BASE;
	
	// TODO Prepare the request query
	private static final String QUERY= "SELECT objectid, nombre FROM %1$s WHERE lower(nombre) like lower('%2$s')";

	@Override
	public List<Road> searchRoad(String roadName) {
		String query = String.format(QUERY, ROADS_DATA_BASE, "%"+ roadName.trim()+"%");
		
		List<Road> result = this.getTemplate().query(query, MAPPER);
        
        return result;
	}
	
	private static class RoadDataMapper implements RowMapper<Road>{

        public RoadDataMapper() {
        }

        @Override
        public Road mapRow(ResultSet rs, int rowNum) throws SQLException {
            Road result = new Road();
            
            // Result sets values indexes start with 1.
            result.setObjectId(rs.getInt("OBJECTID"));
            result.setRoadName(rs.getString("NOMBRE"));
            
            return result;
        }
    }

}
