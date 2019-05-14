package Helpers;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class StatusTestsListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("\033[32m%-90s PASSED\033\n", result.getTestClass().getName() + ":" + result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("\033[31m%-90s FAILED  !\033\n", result.getTestClass().getName() + ":" + result.getMethod().getMethodName());
    }
}
