package Pages.Testrail;


import com.google.gson.Gson;
import Pages.Testrail.entities.Result;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Pages.utils.TestListener.capture;
import static org.testng.Assert.assertEquals;

public class TestRailHelper {
    public static Properties prop;
    public static String TEST_RUN_ID;
    public static String TEST_PROJECT_ID;
    public static String TEST_SUITE_ID;
    String TESTRAIL_USERNAME;
    String TESTRAIL_PASSWORD;
    public static final int PASSED_STATUS = 1;
    public static final int FAILED_STATUS = 5;
    public static final int SKIPPED_STATUS = 3;
    public static final int BLOCKED_STATUS = 2;

    public RestAssured restAssured = null;
    public RequestSpecification request = null;

    APIClient client;

    public TestRailHelper() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\Configuration");
        prop.load(ip);
        TEST_RUN_ID = prop.getProperty("TEST_RAIL_RUN_ID");
        TEST_PROJECT_ID = prop.getProperty("TEST_PROJECT_ID");
        TEST_SUITE_ID = prop.getProperty("TEST_SUITE_ID");
        TESTRAIL_USERNAME = prop.getProperty("TESTRAIL_USERNAME");
        TESTRAIL_PASSWORD = prop.getProperty("TESTRAIL_PASSWORD");
        restAssured.baseURI = prop.getProperty("URi");
        client = new APIClient(prop.getProperty("URi"));
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
    }


    public void add_result_for_case(String TC_ID, String RUN_ID, String result,String TestName) {
        String TC_Title = "Connection Failed to TestRail";
        try {

            Map data = new HashMap();
            switch (result) {
                case "Passed":
                    data.put("status_id", PASSED_STATUS);
                    break;
                case "Failed":
                    data.put("status_id", FAILED_STATUS);
                    break;
                case "Skipped":
                    data.put("status_id", BLOCKED_STATUS);
                    break;
                default:
                    data.put("status_id", SKIPPED_STATUS);
                    break;
            }
            data.put("comment", "Test Class :"+TestName+"\n Test Executed - Status updated automatically using Regression Suite");
            JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + RUN_ID + "/" + TC_ID, data);
            if (result.equalsIgnoreCase("Failed")){
                add_attachment_for_case(TC_ID,RUN_ID,capture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add_result_for_case(String TC_ID, String result){
        System.out.println("add_result_for_case:" + TC_ID);
        String TC_Title = "Connection Failed to TestRail";
        try {

            Map data = new HashMap();
            switch (result) {
                case "Passed":
                    data.put("status_id", PASSED_STATUS);
                    break;
                case "Failed":
                    data.put("status_id", FAILED_STATUS);
                    break;
                case "Skipped":
                    data.put("status_id", BLOCKED_STATUS);
                    break;
                default:
                    data.put("status_id", SKIPPED_STATUS);
                    break;
            }

            data.put("comment", "Test Executed - Status updated automatically using Regression Suite");
            JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + TEST_RUN_ID + "/" + TC_ID, data);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add_result_for_cases(String[] TC_ID, String result) {
        System.out.println("add_result_for_cases");
        String TC_Title = "Connection Failed to TestRail";
        if (TC_ID.length >0) {
            for(String name : TC_ID){
                name = name.trim().substring(1);
                System.out.println(name);
                add_result_for_case(name, result);
            }
        }
    }

    public void add_results_for_cases(String RUN_ID) {
        String TC_Title = "Connection Failed to TestRail";
        try {

            Map data = new HashMap();
            data.put("status_id", new Integer(1));
            data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
            JSONObject r = (JSONObject) client.sendPost("add_results_for_cases/" + TEST_RUN_ID, data);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void add_attachment_for_case(String TC_ID, String RUN_ID, String attachment){
        try {

            int resultID = getLatestResultID(Integer.parseInt(RUN_ID),Integer.parseInt(TC_ID));
            JSONObject n = (JSONObject) client.sendPost("add_attachment_to_result/" + resultID,attachment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void attachScreenshotToResult(String screenshot, String TC_ID, String RUN_ID) {
        int resultID = getLatestResultID(Integer.parseInt(RUN_ID),Integer.parseInt(TC_ID));
        try {
            JSONObject response = (JSONObject) client.sendPost("add_attachment_to_result/" + resultID,
                    screenshot);
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
    }
    public int getLatestResultID(int runId, int caseId) {
        int resultId = 0;
        ArrayList<Result> results = new ArrayList<Result>();
        Result firstResult;
        try {
            // getting latest Results for the CaseId (in the Run)
            Gson gson = new Gson();
            JSONArray r = (JSONArray) client.sendGet("get_results_for_case/" + runId + "/" + caseId);
            System.out.println(r.toString());
            firstResult = gson.fromJson(r.get(0).toString(),Result.class);
            // getting 1st element from array (latest reported Result)
           // Result firstResult = results.get(0);
            // getting ID of the Result
            resultId = firstResult.getId();
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
        return resultId;
    }

    public String add_run(String[] TC_ID) {
        System.out.println("add_run");
        String result = "Connection Failed to TestRail";
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            List cases = new ArrayList();
            for (int i=0;i<TC_ID.length;i++) {
                cases.add(TC_ID[i]);
            }
            Map data = new HashMap();
            data.put("suite_id", TEST_SUITE_ID);
            data.put("name", " Automation Test Run " + dtf.format(now));
            data.put("description", "Test Run created automatically for regression test");
            data.put("include_all", false);
            data.put("case_ids", cases);
            data.put("refs", "Ref:Regression Suite");
            //data.put("milestone_id", 24);
            JSONObject r = (JSONObject) client.sendPost("add_run/" + TEST_PROJECT_ID, data);
            TEST_RUN_ID = r.get("id").toString();
            System.out.println("TEST_RUN_ID "+ TEST_RUN_ID);
            return TEST_RUN_ID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String update_run(String[] TC_ID) {
        System.out.println("update_run");
        String result = "Connection Failed to TestRail";
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            List cases = new ArrayList();
            for (int i=0;i<TC_ID.length;i++) {
                cases.add(TC_ID[i]);
            }
            Map data = new HashMap();
            data.put("suite_id", "1");
            data.put("name", " Automation Test Run " + dtf.format(now));
            data.put("description", "Test Run created automatically by Selenium test automation");
            data.put("include_all", false);
            data.put("case_ids", cases);
            JSONObject r = (JSONObject) client.sendPost("update_run/" + "5899", data);
            TEST_RUN_ID = r.get("id").toString();
            System.out.println("TEST_RUN_ID "+ TEST_RUN_ID);
            return TEST_RUN_ID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update_case(String TC_ID) {
        System.out.println("update_case");
        try {

            Map data = new HashMap();
            data.put("custom_automation", "1");
            JSONObject c = (JSONObject) client.sendPost("update_case/" + TC_ID,data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_cases(String[] TC_ID) {
        System.out.println("update_cases");
        if (TC_ID.length >0) {
            for(String name : TC_ID){
                System.out.println(name);
                update_case(name);
            }
        }
    }
}
