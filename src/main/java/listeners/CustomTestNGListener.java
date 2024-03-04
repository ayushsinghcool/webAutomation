package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomTestNGListener implements ITestListener {

    private List<String> reportEntries;

    @Override
    public void onStart(ITestContext context) {
        reportEntries = new ArrayList<>();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Capture test start event
        reportEntries.add("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Capture test success event
        reportEntries.add("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture test failure event
        reportEntries.add("Test Failed: " + result.getName());
        reportEntries.add("Failure Details: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Generate HTML report based on captured test results
        generateHTMLReport();
    }

    private void generateHTMLReport() {
        try {
            FileWriter fileWriter = new FileWriter("test-report.html");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write HTML header
            printWriter.println("<!DOCTYPE html>");
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>Test Report</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");

            // Write test entries
            for (String entry : reportEntries) {
                printWriter.println("<p>" + entry + "</p>");
            }

            // Write HTML footer
            printWriter.println("</body>");
            printWriter.println("</html>");

            printWriter.close();
            fileWriter.close();

            System.out.println("HTML report generated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
