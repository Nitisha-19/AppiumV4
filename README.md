**📱 Appium Mobile Automation Framework**

A scalable mobile automation testing framework built using Appium, Java, TestNG, and Selenium WebDriver.

This project demonstrates a production-style automation framework implementing Page Object Model (POM), parallel execution, retry mechanisms, logging, and data-driven testing.

The framework is designed for Android mobile automation and can be extended to support distributed execution with Selenium Grid or cloud device farms.

**Repository:**

https://github.com/Nitisha-19/AppiumV4

🚀 **Framework Architecture**

                TestNG Test Cases
                       │
                       ▼
                BaseClass (Driver Setup)
                       │
                       ▼
               Page Object Model (POM)
                       │
                       ▼
              Appium Server (WebDriver)
                       │
                       ▼
              Android Emulator / Device
              
📊 **Automation Workflow**


Start Test
   │
   ▼
Launch Appium Server
   │
   ▼
Initialize Driver (BaseClass)
   │
   ▼
Execute Test Cases
   │
   ▼
Page Object Methods
   │
   ▼
Perform Mobile Actions
   │
   ▼
Assertions & Validation
   │
   ▼
Test Result & Logs


**✨ Key Features**

✔ Page Object Model (POM) architecture
✔ Appium mobile automation for Android apps
✔ TestNG test execution framework
✔ Parallel test execution support
✔ Retry mechanism for flaky tests
✔ Log4j logging for debugging and traceability
✔ Data-driven testing using TestNG DataProviders
✔ Modular and maintainable project structure
✔ Maven dependency management
✔ Easily extendable to Selenium Grid

🛠 **Tech Stack**

Tool	Purpose
Java	Programming language
Appium	Mobile automation
Selenium WebDriver	WebDriver protocol
TestNG	Test framework
Maven	Build & dependency management
Log4j	Logging framework
Android Studio	Emulator management
Appium Inspector	UI element inspection

📂 **Project Structure**


AppiumV4
│
├── src/test/java
│
│   ├── TestBase
│   │       BaseClass.java
│   │
│   ├── PageObjects
│   │       HomePage.java
│   │       ProductsPage.java
│   │       CartPage.java
│   │
│   ├── TestCases
│   │       LetsShop.java
│   │       AddToCart.java
│   │       TermsAndConditions.java
│   │       ValidateToastMessage.java
│   │
│   └── Utilities
│           RetryAnalyzer.java
│           DataProviders.java
│
├── src/test/resources
│       config.properties
│       log4j2.xml
│
├── testng.xml
├── pom.xml
└── README.md


⚙️ **Prerequisites**

Install the following tools:
Java JDK 11+
Maven
Node.js
Appium
Android Studio
Android SDK
Appium Inspector

📦 **Install Appium**

npm install -g appium

**Verify installation:**

appium -v

📱 **Start Android Emulator**

Open Android Studio → Device Manager
Start an emulator.
Verify connection:
adb devices

**Example output:**

emulator-5554 device
▶️ Running the Tests
Start Appium Server
appium

Default URL
http://127.0.0.1:4723

Execute Tests Using Maven
mvn clean test

Run TestNG Suite
mvn test -Dsurefire.suiteXmlFiles=testng.xml

⚡ **Parallel Execution**
This framework supports parallel test execution using TestNG.

Example configuration:
<suite name="MobileSuite" parallel="tests" thread-count="2">

Tests can run simultaneously on:
Multiple Android emulators
Multiple physical devices

🧾 **Logging**

Logging is implemented using Log4j2.

Logs capture:
Test execution steps
Debug information
Errors and failures
Assertion results
Configuration file:

src/test/resources/log4j2.xml

🔁 **Retry Mechanism**

Failed tests are automatically retried using RetryAnalyzer.

Example:

@Test(retryAnalyzer = RetryAnalyzer.class)

This helps reduce flaky test failures.

🧪 Sample Test Scenario

Example automated flow:

1️⃣ Launch mobile application
2️⃣ Enter user name and gender
3️⃣ Select country
4️⃣ Navigate to products page
5️⃣ Add product to cart
6️⃣ Validate terms and conditions alert

🔮 **Future Improvements**

Planned enhancements:

Selenium Grid integration
Cloud device execution
iOS automation support

👩‍💻 **Author**

Nitisha Kondadhasula
QA Automation Engineer specializing in Selenium, Appium, and Automation Framework Design

GitHub
https://github.com/Nitisha-19
