package com.shuchi;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
   static void fetchDeploymentDetails() {

        Response response = RestAssured.get("/deployments");

        List<Map<String, Object>> deployments = response.jsonPath().getList("deployments");

        for (Map<String, Object> deployment : deployments) {
            int id = (int) deployment.get("id");
            String user = (String) deployment.get("user");
            String deploymentTime = (String) deployment.get("deploymentTime");
            String description = (String) deployment.get("description");
            String state = (String) deployment.get("state");
            boolean multipleErrors = (boolean) deployment.get("multipleErrors");

            Map<String, Object> targetEnvironment = (Map<String, Object>) deployment.get("targetEnvironment");
            int targetEnvironmentId = (int) targetEnvironment.get("id");
            String targetEnvironmentName = (String) targetEnvironment.get("name");
            boolean minimumUpdateMandatory = (boolean) targetEnvironment.get("minimumUpdateMandatory");

            List<Map<String, Object>> revisions = (List<Map<String, Object>>) deployment.get("revisions");

            for (Map<String, Object> revision : revisions) {
                int revisionId = (int) revision.get("id");
                String revisionDescription = (String) revision.get("description");
                String revisionName = (String) revision.get("name");
                boolean includeJars = (boolean) revision.get("includeJars");
                boolean includeI18N = (boolean) revision.get("includeI18N");
                boolean includeStatistics = (boolean) revision.get("includeStatistics");
                boolean includeServerProperties = (boolean) revision.get("includeServerProperties");
                boolean includeWebContainerProperties = (boolean) revision.get("includeWebContainerProperties");
                boolean includeJdbcWrapperProperties = (boolean) revision.get("includeJdbcWrapperProperties");
                boolean includeVdpDependencies = (boolean) revision.get("includeVdpDependencies");
                boolean includeUsersAndPrivileges = (boolean) revision.get("includeUsersAndPrivileges");

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World! \n This Code is executed by Shuchi on Git Acrion Runner using Maven Build tool");
        fetchDeploymentDetails();
    }
}
