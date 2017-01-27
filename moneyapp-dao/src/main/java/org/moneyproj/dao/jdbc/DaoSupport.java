package org.moneyproj.dao.jdbc;

import org.apache.commons.configuration.Configuration;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class DaoSupport extends JdbcDaoSupport {

    private Configuration config;

    public final void setConfig(final Configuration configuration) {
        config = configuration;
    }

    public final Configuration getConfig() {
        return config;
    }
}
