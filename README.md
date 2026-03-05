**📱 Appium Mobile Automation Framework**

A mobile test automation framework built using Appium, Java, TestNG, and Selenium for automating Android applications.
This framework demonstrates scalable automation architecture using Page Object Model (POM), parallel execution, logging, retry mechanisms, and data-driven testing.

The goal of this project is to provide a maintainable and extensible automation framework for testing mobile applications efficiently.


**🚀 Features**

📱 Mobile automation using Appium

🧱 Page Object Model (POM) design pattern

🔁 Retry Analyzer for failed tests

📊 Data-driven testing with DataProviders

🧾 Log4j logging for debugging and traceability

⚡ Parallel test execution using TestNG

📋 Test grouping (Sanity / Regression)

📱 Supports Android emulators and real devices

☁️ Designed to support Selenium Grid / distributed execution

🧪 Modular test architecture for easy scalability


Mobile automation frameworks built with Appium allow testers to automate Android and iOS applications using the WebDriver protocol, similar to Selenium-based automation frameworks.


**🛠 Tech Stack**
Tool / Framework	Purpose
Java	Programming language
Appium	Mobile automation framework
Selenium WebDriver	WebDriver protocol support
TestNG	Test execution and reporting
Maven	Dependency management
Log4j	Logging framework
Android Studio	Emulator and SDK management
Appium Inspector	Element inspection


**📂 Project Structure**


<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/48570d63-e2aa-4b6c-b974-1fa7d83cd6c2" />



**⚙️ Prerequisites**

Make sure the following tools are installed:

Java JDK 11+

Maven

Node.js

Appium

Android Studio

Android SDK

Appium Inspector


Install Appium
npm install -g appium

Verify installation:
appium -v


**📱 Start Android Emulator**

Open Android Studio → Device Manager
Start an emulator or connect a real device.

Verify device connection:
adb devices

▶️ Running the Tests

1️⃣ Start Appium Server
appium

Default server:
http://127.0.0.1:4723

2️⃣ Run Using Maven
mvn clean test

3️⃣ Run Specific TestNG Suite
mvn test -Dsurefire.suiteXmlFiles=testng.xml


**⚡ Parallel Execution**

This framework supports parallel test execution using TestNG.

Example:

<suite name="MobileSuite" parallel="tests" thread-count="2">

This allows tests to run on multiple emulators or devices simultaneously.


**🧾 Logging**

The framework uses Log4j for logging test execution.

Logs include:

Test start and completion

Element interactions

Debug information

Failure details

Configuration file:
src/test/resources/log4j2.xml


**🔁 Retry Mechanism**

Failed tests automatically retry using RetryAnalyzer.

Example:

@Test(retryAnalyzer = RetryAnalyzer.class)

This helps reduce flaky test failures.

🧪 Sample Test Scenario

Example automated flow:

Launch mobile application

Enter user details

Select country

Navigate to products page

Add item to cart

Validate terms and conditions alert


**🔮 Future Enhancements**

Selenium Grid support for distributed execution

Cloud device integration (BrowserStack / Sauce Labs)

iOS automation support


**👩‍💻 Author**

Nitisha Kondadhasula

QA Automation Engineer

Expertise in Selenium, Appium, TestNG, and Automation Framework Design

GitHub:
https://github.com/Nitisha-19
