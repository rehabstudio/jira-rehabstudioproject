jira project plugin
===================

This plugin is designed to create a tailored Workflow and Issue Scheme project template


Requirements
------------
`Atlas SDK <https://www.google.co.uk/search?q=download+atlas+sdk&oq=download+atlas+sdk&aqs=chrome..69i57j0.3465j0j4&sourceid=chrome&es_sm=93&ie=UTF-8>`_.

`jira-cli-4.0.0-SNAPSHOT-distribution.zip
<https://bobswift.atlassian.net/wiki/download/attachments/16285777/jira-cli-4.0.0-SNAPSHOT-distribution.zip?version=16&modificationDate=1409573483826&api=v2>`_.

**note:** you should move `jira-cli-4.0.0-SNAPSHOT-distribution.zip` to `/opt/atlassian/jira-cli/` and modify `/opt/atlassian/jira-cli/jira.sh` to suit your setup

Install
-------

This project has been designed to be ran with `atlas-run` / `atlas-debug` etc.

You have successfully created an Atlassian Plugin!
--------------------------------------------------

Here are the SDK commands you'll use immediately:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-cli   -- after atlas-run or atlas-debug, opens a Maven command line window:
                 - 'pi' reinstalls the plugin into the running product instance
* atlas-help  -- prints description for all commands in the SDK

Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK
