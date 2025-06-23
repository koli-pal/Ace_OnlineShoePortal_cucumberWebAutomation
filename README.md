# Ace_OnlineShoePortal_cucumberWebAutomation

## Overview

This project is a **Cucumber-based automation framework** using **Selenium and TestNG** for testing the Ace Online Shoe Portal (https://anupdamoda.github.io/AceOnlineShoePortal/SignIn.html).

## Tech Stack

* **Cucumber** (v7.2.3)
* **Selenium WebDriver** (v4.17.0)
* **TestNG** (v7.8.0)
* **Allure Reporting** (v2.24.0)
* **WebDriverManager** (v5.5.3)
* **Java 11+**
* **Maven**

---

## 📁 Page Object Model Structure

```
AceOnlineShoePortal/
├── src/
│   └── test/
│       └── java/
│           ├── feature/                   
│           │   ├── LoginPage.feature
│           │   ├── NewUserPage.feature
│           │   ├── ProductPage.feature
│           │   └── ProductPage2.feature
│           │
│           ├── pages/                     
│           │   ├── BasePage.java          
│           │   ├── LoginPage.java         
│           │   ├── NewUserPage.java       
│           │   ├── ProductPage.java       
│           │   └── ProductPage2.java      
│           │
│           ├── stepDefinition/           
│           │   ├── Hook.java               
│           │   ├── LoginPageDef.java       
│           │   ├── NewUserPageDef.java     
│           │   ├── ProductPageDef.java    
│           │   └── ProductPage2Def.java   
│           │
│           ├── testRunner/                
│           │   └── TestRunner.java
│           │
│           └── utilities/                
│               ├── DriverSetup.java        
│                    
│                                                
├── pom.xml                                
└── README.md                              
```

---

## Features Covered

* 📄 Login Page Validation
* 📄 New User Registration Page
* 📄 Product Page
* 📄 Product Details Page


---

##  How to Run the Project

### ✅ Prerequisites

Make sure the following tools are installed:

* Java JDK 8 or above
* Maven
* Allure Commandline (`npm install -g allure-commandline`)
* An IDE like IntelliJ IDEA

###  Install Dependencies

```bash
mvn clean install
```

###  Run Tests

```bash
mvn test
```

Or specify a browser:

```bash
mvn test -Dbrowser=Firefox
```

### Generate Allure Report

```bash
allure serve allure-results
```

---

## Sample Feature: Login

```gherkin
Feature: Login Functionality

  Scenario: Valid user logs into the portal
    Given the login page is open
    Then Username field should present
    And Username field should be writable
    And Password field should be present
    And Password field should be writable
    And Login button should present
    And Login button label should be "Login"
    And the login button should be enabled
    And the new user button should be visible
    When username "sandy" is entered
    And password "SandyPass@123" is entered
    And the login button is clicked
```
##  Sample Feature: Registration
```gherkin
Feature: User Registration Functionality

  Scenario: Register a new user with valid data
    Given the registration page is open
    Then the registration page heading should be "User Registration Page"
    When first name "Sandy" is entered
    And last name "Smith" is entered
    And email "sandy@example.com" is entered
    And contact number "01712345678" is entered
    And New Username is entered "sandy"
    And new user password is entered "SandyPass@123"
    Then the submit button should be enabled
    When the submit button is clicked

```
---

## Key Concepts Used

* **Page Object Model (POM)** to keep locators and logic clean
* **ThreadLocal WebDriver** for safe parallel execution
* **Allure Screenshot Attachment** on failure

---

##  Allure Report Screenshots
![Screenshot 2025-06-09 211021](https://github.com/user-attachments/assets/fd7e8a45-dc0f-461d-a301-c4fc777211b0)
![Screenshot 2025-06-09 210846](https://github.com/user-attachments/assets/2edf53bf-34c4-4834-9c22-5c8ac5d97e45)
![Screenshot 2025-06-09 210948](https://github.com/user-attachments/assets/7e917664-a4da-49c9-856b-0181ec9da95f)
![Screenshot 2025-06-09 212444](https://github.com/user-attachments/assets/61c22a5c-1480-4c49-96a3-323c5d23e611)


