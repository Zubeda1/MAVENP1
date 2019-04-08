package com.mavenitseleniumtraining;

import com.mavenitseleniumtraining.Driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
    private DriverManager drivermanager = new DriverManager();
    private String url=System.getProperty("url");

    @Before
    public void setup(){
        drivermanager.runOnLocalHost();
        drivermanager.navigateTo("https://www.argos.co.uk");
        drivermanager.maxBrowser();
        drivermanager.handleApplicationCookies();
        drivermanager.applyImlicit();
        drivermanager.sleep(3000);
    }
    @After
    public  void teardown(Scenario scenario){
        if(scenario.isFailed()){
            drivermanager.takeSceenShot(scenario);
        }

        drivermanager.closeBrowser();
    }

}
