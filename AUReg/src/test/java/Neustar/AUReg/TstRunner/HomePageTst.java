package Neustar.AUReg.TstRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Neustar/AUReg/Resources/Homepage/" } 
					,glue = {"classpath:Neustar/AUReg/StepDefinitions/" }
				)
public class HomePageTst {

}
