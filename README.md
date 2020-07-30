# RecruitIt_TradeMe_AutomationFramework


> TO validate the TradeMe Webservices and UI with the given Acceptance Criteria.

## TOOLS
[JAVA V_1.7 or greater](https://www.java.com/en/download/)<br/>
[Maven Build](https://maven.apache.org/download.cgi)<br/>
[Cucumeber BDD Framework](https://mvnrepository.com/artifact/io.cucumber/cucumber-java/6.3.0)<br/>
[Simple JsonParser , Rest Assured](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple)

## Project Description
> This project is to navigate to trade me url and get the used car details and validate with the acceptance
<br/>Also to validate the same business process via Webservices.

## Project Highlights
> Project is build on BDD framework with POM and  part of modular approach. .<br/>
> Selenium/Java is used for code<br/>
> Validation of API is done via Rest Assured <br/>
> Log are entered using log4j2<br/>
>Assertion is done thorugh hamcrest assertion <br/>
>Report - 2 type of report 
	>HTML report
	>JVM (Graphical report) <br/>



## Installation/Pre conditions for Running the test

Java 1.7 or higher
<br/>Maven 
<br/>Intellij/Eclipse (Intellij prferable) / Command promt to run the test
<br/>Set Java_Home and Maven_Home in environmental variables

To check if Java and maven are installed in your Machine:

```sh
Java -version
Mvn -version
```

## Creating testdata
To create API test data, use jsonTestData.json file in test/resource
<br/>"getUsedCars": { 
  <br/>    "endpoint":"/v1/Categories/UsedCars.json",
   <br/> "method" : "get",
  <br/>      "auth" : "noAuth",
   <br/> "header": "",
  <br/>  "requestBody": ""
  <br/>}
  <br/>"getUsedCars":  - is your test api name to pass in feature file

  
  ![scenario](/src/test/resources/imageForReadme/FeatureApiData.jpg)
  
  ## Validations
  
  > All API uri response code is validated for status code 200
  
  > The response data is then asserted with the acceptance criteria 
  
  > The UI data is asserted with the business requirement, if any step fail the test scenario will fail.
  
  > One scenario will get failed as the test data does not match with the details in UI
  

## How to run the test

Download the code from GITHUB 

```sh
git pull origin master 
<br/>https://github.com/reach2prabakar/RecruitIt_TradeMe_AutomationFramework.git
```

Open the project in any IDE (Intellij preferred)
You can right click on the feature file and select Run (not preffered to run in suite level)

Mention the tag for the scenario to run in the feature file and configure Run with the specific tag to run the test

![configure](/src/test/resources/imageForReadme/config.JPG)

If you want to run the project as maven Build 

Open the command promt, Navigate to your project folder
```sh
C:\Users> cd path to your folder
C:\Users\Projectfolder> mvn clean install
```

## Reporting

For greater understanding cucumber JVM is plugged in with the framework, However the inbuild cucumber.Html report is avaialble

Once all the test is executed,
<br/>Open the project folder ->\target\cucumber-reports\advanced-reports\cucumber-html-reports
>### overview-features.html

![Scenario](/src/test/resources/imageForReadme/scenarioReport.jpg)
<br/>
<br/>
![FailedScenario](/src/test/resources/imageForReadme/failedscenario.jpg)


## Contributing

1. Fork it (<https://github.com/yourname/yourproject/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

