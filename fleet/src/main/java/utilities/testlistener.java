package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class testlistener extends common_actions implements ITestListener {

    public static ExtentReports extent = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/Fleet_Execution_Report.html");
    private static Map<String, ExtentTest> extentTestMap = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ITestListener.super.onTestSuccess(iTestResult);
        String passedTest = iTestResult.getMethod().getDescription();
        reporter.config().setDocumentTitle("Fleet Execution Results");
        reporter.config().setReportName("Fleet Execution Results");
        reporter.config().setTheme(Theme.DARK);
        takeScreenshot(passedTest);
        extent.attachReporter(reporter);
        ExtentTest test = extent.createTest(passedTest)
                .assignAuthor("Mlungisi_Mbele")
                .assignCategory("REGRESSION")
                .log(Status.PASS, passedTest + " executed successfully");
        extentTestMap.put(passedTest, test);  // Store test for future reporting
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ITestListener.super.onTestFailure(iTestResult);
        String failedTest = iTestResult.getMethod().getDescription();
        reporter.config().setDocumentTitle("Fleet Execution Results");
        reporter.config().setReportName("Fleet Execution Results");
        reporter.config().setTheme(Theme.DARK);
        takeScreenshot(failedTest);
        extent.attachReporter(reporter);
        ExtentTest test = extent.createTest(failedTest)
                .assignAuthor("Mlungisi_Mbele")
                .assignCategory("REGRESSION")
                .log(Status.FAIL, failedTest + " was unsuccessful. See logs/stacktrace for errors");
        extentTestMap.put(failedTest, test);  // Store test for future reporting
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onStart(ITestContext iTestResult) {
        ITestListener.super.onStart(iTestResult);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        try {
            exportTestSummary("./reports/TestSummary.txt");
            generateHtmlReport("./reports/TestSummary.html");
        } catch (IOException e) {
            System.err.println("Error generating summary or report: " + e.getMessage());
        }
    }

    // Generate a summary in HTML format for the HTML report
    private static String generateSummary() {
        int totalTests = extentTestMap.size();
        int passedTests = 0, failedTests = 0, skippedTests = 0;

        for (ExtentTest test : extentTestMap.values()) {
            switch (test.getStatus()) {
                case PASS:
                    passedTests++;
                    break;
                case FAIL:
                    failedTests++;
                    break;
                case SKIP:
                    skippedTests++;
                    break;
            }
        }

        StringBuilder summary = new StringBuilder();
        summary.append("<h2>Summary</h2>");
        summary.append("<p>Total Tests: ").append(totalTests).append("</p>");
        summary.append("<p>Passed: ").append(passedTests).append("</p>");
        summary.append("<p>Failed: ").append(failedTests).append("</p>");
        summary.append("<p>Skipped: ").append(skippedTests).append("</p>");

        return summary.toString();
    }

    // Export test summary to a plain-text file
    public static void exportTestSummary(String filePath) throws IOException {
        int totalTests = extentTestMap.size();
        int passedTests = 0, failedTests = 0, skippedTests = 0;

        // Capture current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String formattedDateTime = currentDateTime.format(formatter);

        for (ExtentTest test : extentTestMap.values()) {
            switch (test.getStatus()) {
                case PASS:
                    passedTests++;
                    break;
                case FAIL:
                    failedTests++;
                    break;
                case SKIP:
                    skippedTests++;
                    break;
            }
        }

        // Writing the summary to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.format("execution_date=%s\n", formattedDateTime));  // Add execution date
            writer.write(String.format("total_tests=%d\n", totalTests));
            writer.write(String.format("passed=%d\n", passedTests));
            writer.write(String.format("failed=%d\n", failedTests));
            writer.write(String.format("skipped=%d\n", skippedTests));
        } catch (IOException e) {
            System.err.println("Error writing test summary: " + e.getMessage());
            throw e;
        }

        System.out.println("Test summary exported successfully to: " + filePath);
    }

    // Generate a custom HTML report
    public static void generateHtmlReport(String outputPath) throws IOException {
        StringBuilder reportContent = new StringBuilder();

        reportContent.append("<html><head><title>Test Report</title></head><body>");
        reportContent.append("<h1>Test Automation Report</h1>");
        reportContent.append("<h2>Run Date: ").append(LocalDate.now()).append("</h2>");

        String summary = generateSummary();
        reportContent.append(summary);

        reportContent.append("<h2>Test Case Details</h2>");
        reportContent.append("<table border='1' cellpadding='5' cellspacing='0'>");
        reportContent.append("<tr><th>Test Name</th><th>Status</th></tr>");

        extentTestMap.values().forEach(test -> {
            reportContent.append(String.format("<tr><td>%s</td><td>%s</td></tr>",
                    test.getModel().getName(), test.getStatus()));
        });

        reportContent.append("</table>");
        reportContent.append("</body></html>");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(reportContent.toString());
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
            throw e;  // Rethrow to handle upstream if needed
        }

        System.out.println("Report generated successfully at: " + outputPath);
    }
}
