package com.a101.logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(iTestResult.getMethod().getMethodName() + " Started");
        Log.info(iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(iTestResult.getMethod().getMethodName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.error("Failed because of - "+ iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("Skipped because of - "+ iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("Hepsiburada onStart :-" + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("Hepsiburada  onFinish :-" + iTestContext.getName());
    }
}
