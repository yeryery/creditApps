package com.mycompany.app;

import com.sun.deploy.util.StringUtils;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class JdbcManager {
    private Connection connection;
    private boolean isConnected = false;

    public void connect(String database, String username, String password) throws SQLException {

        findJdbcDriver();
        closeOpenedConnection();

//        String url = String.format("jdbc:sqlserver://IKlinova\\MSSQLSERVER;databaseName=%s", database);
        String url = String.format("jdbc:sqlserver://localhost:1433;databaseName=%s", database);
        connection = DriverManager.getConnection(url, username, password);
        isConnected = true;
    }

    private void findJdbcDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeOpenedConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            isConnected = false;
        }
    }

    public Set<String> getTableColumns(String tableName) throws SQLException {
        Set<String> result = new LinkedHashSet<>();
        String sql = String.format("SELECT * FROM information_schema.columns WHERE table_name='%s'", tableName);

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                result.add(rs.getString("column_name"));
            }
        }

        return result;
    }

    public void insertValues(String tableName, String values) throws SQLException {
        String formattedValues = "'" + values.replace(",", "\',\'") + "'";
        String sql = String.format("INSERT INTO %s VALUES (%s)", tableName, formattedValues);

        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public void cleanTable(String tableName) throws SQLException {
        String sql = String.format("TRUNCATE TABLE %s", tableName);

        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    public List<DataSet> getDataContent(String tableName) throws SQLException {
        List<DataSet> result = new LinkedList<>();
        String sql = String.format("SELECT * FROM %s", tableName);

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                DataSet dataSet = new DataSet();
                result.add(dataSet);
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    dataSet.put(rsmd.getColumnName(i), rs.getObject(i));
                }
            }
        }

        return result;
    }

}
