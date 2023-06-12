package src.database;

import java.sql.*;
import java.util.Objects;

/**
 * The type Database connection.
 */
public class DatabaseConnection {
    private static Connection connection;
    private static void tryConnection() {
        try {
            connection = DriverManager.getConnection(DatabasePropertiesGetter.getUrl(), DatabasePropertiesGetter.getUser(), DatabasePropertiesGetter.getPassword());
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    /**
     * Execute statement.
     *
     * @param query the query
     */
    public static void executeStatement(String query) {
        tryConnection();
        try {
            connection.createStatement().execute(query);
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    /**
     * Execute prepared statement result set.
     *
     * @param sqlRequest the sql request
     * @param values     the values
     * @return the result set
     */
    public static ResultSet executePreparedStatement(String sqlRequest, String... values) {
        tryConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            for (int i = 0; i < values.length; ++i) {
                preparedStatement.setString(i + 1, values[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
           throw new IllegalArgumentException();
        } finally {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
    }

    /**
     * Create tables if not exist.
     */
    public static void createTablesIfNotExist() {
        try {
            executePreparedStatement("SELECT * FROM VEHICLE").close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            executeStatement("CREATE TABLE VEHICLE (id bigint PRIMARY KEY, creator text NOT NULL, creationdate bigint NOT NULL, name text NOT NULL, enginepower double precision NOT NULL, type text NOT NULL, capacity bigint NOT NULL, fuelconsumption bigint NOT NULL, x double precision NOT NULL, y bigint NOT NULL)");
        }
        try {
            executePreparedStatement("SELECT * FROM USERS").close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            executeStatement("CREATE TABLE USERS (login text  PRIMARY KEY, hash text NOT NULL, salt text NOT NULL)");
        }
        try {
            executePreparedStatement("SELECT * FROM id").close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            try {
                ResultSet resultSet = executePreparedStatement("SELECT id FROM VEHICLE");
                long maxId = 1;
                while (Objects.requireNonNull(resultSet).next()) {
                    maxId = Long.max(resultSet.getLong(1), maxId);
                }
                executeStatement("CREATE SEQUENCE id START " + maxId);
                resultSet.close();
            } catch (SQLException exception) {
                System.out.println(e.getMessage());
            }
        }
    }
}
