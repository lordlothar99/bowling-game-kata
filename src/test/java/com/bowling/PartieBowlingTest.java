package com.bowling;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = { "pretty", "html:target/cucumber-reports", "de.monochromata.cucumber.report.PrettyReports:target/cucumber" }
)
public class PartieBowlingTest {

}
