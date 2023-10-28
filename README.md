Test Automation Assignment

The main Frameworks included in the project:

Selenium Webdriver
Rest-Assured
TestNG
Allure Report
Extent Reports
Apachi POI
Design implementation:

Page Object Model (POM) design pattern
Data Driven framework
Have a supporting Utilities package in src/main/java file path, named "Utils" that includes utility classes and many wrapper methods which services as the core engine for the project
How to execute the test cases locally:

Setup

Import or clone the maven project on any java IDE (Eclipse or IntelliJ for example)
A properties file "configurations.properties" can be found it src/main/resources file path including all the configurations needed in the execution (make sure that the "execution.type" property is "Local" if you need to execute locally)
For GUI PHPTRAVELS Test Cases:

A properties file "phptravels.properties" can be found it src/main/resources file path including all the configurations/global test data needed in the execution for the tests
Can find the test cases in the src/test/java folder inside the phptravels.gui.tests package "JsonPlaceholderTests"
Execution

Can execute each class sperately
Or an find the test suite xml file in the src/test/resources folder inside the TestSuites folder; To start executing the test classes, you can right click on the FullExecution.xml* folder and then click "Run As" > "TestNG Suite"
Reporting

After executing, you can easily generate the Allure Report by opening a commandline terminal on the project root path and type mvn allure:serve (needs to be able to execute mvn commands); Or you can find the Extent Report ExtentReports.html in the project root path for the latest execution
How to see the execution and the test report from the GitHub Actions:

Click on the "Actions" tab
Click on the latest workflow run link
Click on "Test on Ubuntu" and open "Run tests - Chrome Headless" to see the execution logs
And you can check the execution reports by clicking on "ExtentReport" and/or "Allure Report" in the Artifacts section (Just download, unzip and open it)
