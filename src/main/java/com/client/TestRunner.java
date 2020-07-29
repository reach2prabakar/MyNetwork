package com.client;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "pretty",
                "html:target/site/cucumber-pretty",
                "json:target/site/cucumber.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true,
        glue = {
                "com.client.step_definitions"
        },
        strict = true,
        tags = {"not @ignore"}
)

public class TestRunner {}

