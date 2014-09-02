package com.rehabstudio.plugins;
 
import com.atlassian.jira.blueprint.api.AddProjectHook;
import com.atlassian.jira.blueprint.api.ConfigureData;
import com.atlassian.jira.blueprint.api.ConfigureResponse;
import com.atlassian.jira.blueprint.api.ValidateData;
import com.atlassian.jira.blueprint.api.ValidateResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.*;

public class AddRehabProjectHook implements AddProjectHook
{

    private static final Logger log = LogManager.getLogger("atlassian.plugin");

    @Override
    public ValidateResponse validate (final ValidateData validateData)
    {
        ValidateResponse validateResponse = ValidateResponse.create();

        System.out.println("ERK! A");

        return validateResponse;
    }
 
    @Override
    public ConfigureResponse configure (final ConfigureData configureData)
    {
        ConfigureResponse configureResponse = ConfigureResponse.create();

        try {
            String cmd =    "/opt/atlassian/jira-cli/jira.sh " +
                            "--action createBoard " +
                            "--name " + configureData.project().getKey() + "-board " +
                            "--type scrum " + 
                            "--project " + configureData.project().getKey();
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            // output
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // errors
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return configureResponse;
    }
}
