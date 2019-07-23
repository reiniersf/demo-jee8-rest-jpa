package ee.language.app;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@DataSourceDefinition(name = "java:comp/env/jdbc/primary", className = "org.postgresql.xa.PGXADataSource", user = "postgres", password = "sqlpg", databaseName = "greetings", portNumber = 5432, serverName = "localhost")
public class DatasourceConfig {
    @Resource(lookup = "java:comp/env/jdbc/primary")
    DataSource ds;

    @Produces
    public DataSource getDatasource() {
        return ds;
    }
}