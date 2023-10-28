Test Automation Assignment

It's a mini cross-browser automation framework based on Maven, Selenium and TestNG.
Written on Java language. Pattern used in this project is a Page Object Model.

Framework is used for automation testing of the demo-website: https://admin-demo.nopcommerce.com.
Supports Firefox, Internet Explorer, Opera and Google Chrome browsers.
You can clone it into your IDE and run as a test suite. 
To run the builds use the run.bat file and Jenkins.
(In a batch file change the path to the project to your own)
To run build in Jenkins use the batch run.bat as well, and also the git URL of this repository.

Test suite  is defined in testng.xml file.
To view the code, the framework written on, go to src > test/java.

The main Frameworks included in the project:

Selenium Webdriver
TestNG
Allure Report
Extent Reports

Design implementation:

Page Object Model (POM) design pattern
Data Driven framework
Have a supporting Utilities package in src/main/java file path, named "Utils" that includes utility classes and many wrapper methods which services as the core engine for the project
How to execute the test cases locally:

Setup

Import or clone the maven project on any java IDE (Eclipse or IntelliJ for example)
A properties file "configurations.properties" can be found it src/main/resources file path including all the configurations needed in the execution (make sure that the "execution.type" property is "Local" if you need to execute locally)

