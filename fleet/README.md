# Selenium-Appium Hybrid Framework

The aim of this project is to create a test automation framework that will be used for testing web applications. This is a Selenium Java framework designed using Page Factory design pattern.

## Getting Started

This project is a Maven project. To access this project, clone this project directly from Azure into your IntelliJ IDE/Eclipse and open the Maven project from your local directory into IntelliJ.

## Prerequisites

```bash
IntelliJ IDEA/Eclipse
JRE-1.8
JDK-1.8

```

## Install the below
```bash
Download and Install:
1.	IntelliJ IDE 
4.	JRE and JDK
```

## Framework
### Tools
```bash
Testing Framework: Selenium
Build Tool: Maven
Testing Tool: TestNG
Programming Language: Java
```

### Design
```bash
web-config and webdriver manager stored within framework to easily access and use. Making the solution portable.
```

```bash
Framework consists of following modules / packages:
•	Common (driver initialization classes), 
•	Pages (web applications page factory), 
•	resources(web-config.properties files, TestListeners
•	tests (for web tests)

```

```bash
tests use TestNG annotations following the same structure:

@BeforeMethod – This is the precondition / setup of the tests
@Test – steps to run
@AfterMethod – Post condition / resetting the driver into its initial state 

```
## Running the tests with TestNG

```bash
Open Edit run/debug configuration dialog
```

```bash
tests Class for executing web App tests.
```

```bash
To execute each Class, navigate to the respective class > right-click on it > run using the respective configuration set on previous step
```

```bash

### To execute Mobile tests

```bash
1.	Launch the browser
```

```bash
2.	Change the device details in web_config.properties file to match your details

```bash
3.	Navigate to the tests class > Right-click and run using the TestNG
```