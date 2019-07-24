package ee.language.app;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
    name = "java:global/primary",
    className = "org.postgresql.ds.PGSimpleDataSource",
    serverName = "localhost",
    portNumber = 5432,
    databaseName = "greetings",
    user = "postgres",
    password = "sqlpg"
)
public class DataSourceConfig{

}