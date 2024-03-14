package MyRunner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(

        features = {"src/main/java/Feature"},
        glue ={"stepDefination"},
        //tags = "@Smoke","@Regression",
        dryRun = true,
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }


)
public class Runner {

        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun=true)
        public void setUpClass()throws Exception{
                testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
        }

        @Test(groups="cucumber",description="RunsCucumberFeature",dataProvider="features")
        public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature){
                testNGCucumberRunner.runScenario(pickle.getPickle());
        }

        @DataProvider
        public Object[][]features(){
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun=true)
        public void tearDownClass()throws Exception{
                testNGCucumberRunner.finish();
        }

}
