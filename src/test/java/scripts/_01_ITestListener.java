package scripts;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class _01_ITestListener implements ITestListener {

    public void onTestFailure(ITestResult result){
        System.out.println("Test has failed and this message is from the ITestListener interface");
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test has passed this message is from the ITestListener interface");
    }

}
