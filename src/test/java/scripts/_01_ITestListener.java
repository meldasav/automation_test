package scripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class _01_ITestListener implements ITestListener {

    public synchronized void onStart(ITestContext context){
        ExtentManager.getReport();
        ExtentManager.createTest(context.getName(),context.getHost());
    }

    public synchronized void onTestFailure(ITestResult result){
        ExtentManager.getTest().fail(result.getThrowable());
        try{
            System.out.println("Test failed: " + result.getName());
            ExtentManager.takescreenShot(result.getMethod().getMethodName());
            ExtentManager.attachImage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public synchronized void onFinish(ITestContext context){
        ExtentManager.flushReport();

    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test has passed this message is from the ITestListener interface");
    }

}
