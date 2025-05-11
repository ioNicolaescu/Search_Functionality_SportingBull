package com.sportingBull.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target.return.txt",
        glue = "com/sportingBull/step_definitions"
)
public class FailedTestRunner {}
