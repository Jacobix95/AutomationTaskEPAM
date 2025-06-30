# SauceDemo Automation Task

## ✅ Project Description

This project automates the login functionality for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver with Java, TestNG, and AssertJ.  
The framework supports **Chrome** and **Firefox**, includes **logging (SLF4J + Logback)**, and uses the **Strategy design pattern** for browser selection.

---

## 🔧 Tech Stack

- **Test Automation Tool**: Selenium WebDriver
- **Test Runner**: TestNG
- **Build Tool**: Maven
- **Languages**: Java
- **Assertions**: AssertJ
- **Locators**: CSS Selectors
- **Logging**: SLF4J with Logback
- **Browsers**: Chrome & Firefox
- **Design Pattern**: Strategy (used in `WebDriverFactory`)

---

## 🧪 Test Scenarios

### UC-1: Empty Credentials
- Click login without entering any data
- Validate error: `Epic sadface: Username is required`

### UC-2: Username Provided, Password Empty
- Enter username, clear password, click login
- Validate error: `Epic sadface: Password is required`

### UC-3: Valid Login
- Username: `standard_user`
- Password: `secret_sauce`
- Validate page title: `Swag Labs` or that URL contains `/inventory`

---

## 🛠️ How to Run

1. Clone the repository
2. In `src/test/resources/config.properties`, set:

   ```properties
   browser=chrome
3. Run the tests

**Command line:**

```bash
mvn  clean test
```
# My solution branch