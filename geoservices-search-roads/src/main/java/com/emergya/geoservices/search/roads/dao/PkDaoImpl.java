package com.emergya.geoservices.search.roads.dao;

import com.emergya.geoservices.search.roads.dto.RoadPk;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lroman
 */
@Repository
public class PkDaoImpl  extends JdbcBaseDao implements PkDao {
    
    private static final PKDataMapper MAPPER = new PKDataMapper();

    
    private static final String QUERY= "select * from (" +
"        select OBJECTID, MATRICULA, PK, min(abs(TO_NUMBER(PK) - %1$s)) as distance, dense_rank() over (order by min(abs(TO_NUMBER(PK) - %1$s)) asc) r" +
"          from PK_SHP   where lower(MATRICULA) like lower('%2$s') " +
"         group by MATRICULA, OBJECTID, PK ) where r = 1 order by MATRICULA";


    @Override
    public List<RoadPk> searchPK(String roadName, int desiredPk) {
        
        // Using String.format is not a good approach but using the JdbcTemplate's provided way resulted in
        // 'invalid column type' errors. :(
        String query = String.format(QUERY, desiredPk, "%"+ roadName.trim()+"%");

        
        List<RoadPk> result = this.getTemplate().query(query, MAPPER);
        
        return result;
    }

    private static class PKDataMapper implements RowMapper<RoadPk>{

        public PKDataMapper() {
        }

        @Override
        public RoadPk mapRow(ResultSet rs, int rowNum) throws SQLException {
            RoadPk result = new RoadPk();
            
            // Result sets values indexes start with 1.
            result.setObjectId(rs.getInt("OBJECTID"));
            result.setRoadName(rs.getString("MATRICULA"));
            result.setPk(rs.getInt("PK"));
            
            return result;
        }
    }
    
}
