package com.automation.web.tests.listeners;

import com.automation.web.tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Class listeners.
 * @author natalia.mateus
 */
public class Listener extends BaseTest implements ITestListener  {

    private Logger log = Logger.getLogger(Listener.class);


    @Override
    public void onStart(ITestContext arg0) {
        Reporter.log("Starts Test Execution..." +arg0.getName());
    }

    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("Finish Test Execution..." +arg0.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Execution status..." +result.getStatus());
        failedTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Execution status..." +result.getStatus());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Starts test..." +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Execution status..." +result.getStatus());
    }

}
