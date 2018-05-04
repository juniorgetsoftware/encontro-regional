package br.com.ic;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:br/com/ic/cucumber/features", monochrome = true, dryRun = true)
public class ExecutaTestesCucumber {

}