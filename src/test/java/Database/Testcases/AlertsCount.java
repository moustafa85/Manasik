package Database.Testcases;

import Pages.base.BasePage;

import java.io.IOException;
import java.sql.*;

public class AlertsCount extends BasePage {
    public AlertsCount() throws IOException {
    }

    public static String OpenhealthAlertsCount(String startDate, String enddate, String Site) throws SQLException, ClassNotFoundException {
        //Load MySQL JDBC Driver
        String AlertsCount = "";

        Class.forName("org.postgresql.Driver");
        Connection connection =
                DriverManager
                        .getConnection("jdbc:postgresql://"+prop.getProperty("dbHost")+":"+prop.getProperty("dbPort")+"/"+prop.getProperty("dbName"),prop.getProperty("dbUserName"),prop.getProperty("dbPassword"));

        Statement st = connection.createStatement();
        System.out.println("Connection");
        // String selectquery = "SELECT id FROM public.incidents ORDER BY ID DESC LIMIT 1;";
        String selectquery ="SELECT Count(id) FROM public.incidents WHERE incident_type_id IN (7,8,9,10,11,12) And status = 100 And site_id in (SELECT id FROM public.sites where name = '"+Site+"') AND Time Between '"+startDate+" 00:00:00+00' And '"+enddate+" 23:59:00+00';";
        System.out.println("Connection1");
        // Executing the SQL Query and store the results in ResultSet
        ResultSet rs = st.executeQuery(selectquery);

        // While loop to iterate through all data and print results
        while (rs.next()) {
            System.out.println(rs.getString("count"));
            AlertsCount = rs.getString("count");
        }

        // Closing DB Connection
        connection.close();
        return AlertsCount;
    }
}
