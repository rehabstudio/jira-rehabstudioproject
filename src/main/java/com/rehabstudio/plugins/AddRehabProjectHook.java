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
        return validateResponse;
    }
 
    @Override
    public ConfigureResponse configure (final ConfigureData configureData)
    {
        String sId = "?";

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
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                // A bit hacky - seek cleaner method
                sId = s.replaceAll("^.*?([0-9]+).$", "$1");
            }

            // errors
            while ((s = stdError.readLine()) != null) {
                System.out.println("[ERROR]: " + s);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        ConfigureResponse configureResponse = ConfigureResponse.create().setRedirect("/secure/RapidBoard.jspa?rapidView=" + sId);

        return configureResponse;
    }
}
