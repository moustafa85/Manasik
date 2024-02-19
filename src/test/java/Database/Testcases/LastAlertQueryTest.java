package Database.Testcases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Pages.base.BasePage;
import org.testng.annotations.Test;

@Test public class LastAlertQueryTest extends BasePage {
    public LastAlertQueryTest() throws IOException {
    }

    public static String CheckCreatedIncident(String  incedient_type) throws SQLException, ClassNotFoundException {
//        int incedientType = Integer.parseInt(incedient_type.substring(0,incedient_type.indexOf('.')));
        int incedientType = Integer.parseInt(incedient_type);
        //Load MySQL JDBC Driver
        String AlertId = "";

        Class.forName("org.postgresql.Driver");
        System.out.println("jdbc:postgresql://"+prop.getProperty("dbHost")+":"+prop.getProperty("dbPort")+"/"+prop.getProperty("dbName")+prop.getProperty("dbUserName")+prop.getProperty("dbPassword"));
        Connection connection =
                DriverManager
                        .getConnection("jdbc:postgresql://"+prop.getProperty("dbHost")+":"+prop.getProperty("dbPort")+"/"+prop.getProperty("dbName"),prop.getProperty("dbUserName"),prop.getProperty("dbPassword"));
        Statement st = connection.createStatement();
        System.out.println("Connection");
       // String selectquery = "SELECT id FROM public.incidents ORDER BY ID DESC LIMIT 1;";
        String selectquery ="SELECT id FROM public.incidents WHERE incident_type_id="+incedientType+" AND time>= CURRENT_DATE ORDER BY ID DESC LIMIT 1;";
        System.out.println("Connection1");
        // Executing the SQL Query and store the results in ResultSet
        ResultSet rs = st.executeQuery(selectquery);

        // While loop to iterate through all data and print results
        while (rs.next()) {
            System.out.println(rs.getString("id"));
            AlertId = rs.getString("id");
        }

        // Closing DB Connection
        connection.close();
        return AlertId;
    }
    public static String CheckLastIncident(String  incedient_type,String site) throws SQLException, ClassNotFoundException {
        int incedientType = Integer.parseInt(incedient_type);
        String AlertId = "";

        Class.forName("org.postgresql.Driver");
        System.out.println("jdbc:postgresql://"+prop.getProperty("dbHost")+":"+prop.getProperty("dbPort")+"/"+prop.getProperty("dbName")+prop.getProperty("dbUserName")+prop.getProperty("dbPassword"));
        Connection connection =
                DriverManager
                        .getConnection("jdbc:postgresql://"+prop.getProperty("dbHost")+":"+prop.getProperty("dbPort")+"/"+prop.getProperty("dbName"),prop.getProperty("dbUserName"),prop.getProperty("dbPassword"));
        Statement st = connection.createStatement();
        String selectquery ="SELECT id FROM public.incidents WHERE incident_type_id="+incedientType+" And site_id in (SELECT id FROM public.sites where name = '"+site+"') ORDER BY ID DESC LIMIT 1;";
        // Executing the SQL Query and store the results in ResultSet
        ResultSet rs = st.executeQuery(selectquery);

        // While loop to iterate through all data and print results
        while (rs.next()) {
            System.out.println(rs.getString("id"));
            AlertId = rs.getString("id");
        }

        // Closing DB Connection
        connection.close();
        return AlertId;
    }
}

