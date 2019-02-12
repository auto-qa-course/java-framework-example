package customLibs.utils;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class RestAssuredLogListener implements ITestListener {
    private ByteArrayOutputStream restAssuredLogs = new ByteArrayOutputStream();
    private PrintStream requestStream = new PrintStream(restAssuredLogs, true);
    private PrintStream responseStream = new PrintStream(restAssuredLogs, true);

    public void onStart(ITestContext iTestContext) {
        RequestLoggingFilter responsesFilter = new RequestLoggingFilter(LogDetail.ALL, requestStream);
        ResponseLoggingFilter requestsFilter = new ResponseLoggingFilter(LogDetail.ALL, responseStream);
        RestAssured.filters(responsesFilter, requestsFilter);
    }

    public void onTestSuccess(ITestResult iTestResult) { logRequest(restAssuredLogs); }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
    }

    @Attachment(value = "restAssuredLogs")
    private byte[] logRequest(ByteArrayOutputStream stream) { return attach(stream); }

    private byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}