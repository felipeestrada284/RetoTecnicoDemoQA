package com.demoqa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/demoQA.feature",
        glue = "com.demoqa.stepDefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@RegisterSuccessful or @SelectDate or @TypeOfAlerts"

)

public class DemoQARunners {
}
