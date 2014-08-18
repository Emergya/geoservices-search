package com.emergya.geoservices.search.roads.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Base class for JDBC backed daos.
 * 
 * @author lroman
 */
public abstract class JdbcBaseDao {

    @Autowired
    DataSource dataSource;

    JdbcTemplate template;

    protected JdbcTemplate getTemplate() {
        if (this.template != null) {
            return this.template;
        }
        return this.template = new JdbcTemplate(dataSource);
    }
}
