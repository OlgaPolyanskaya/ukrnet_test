import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //   features = "src/test/features",
//        glue = "src/test/java/steps",
        tags = "@login",
        //       tags = "@param",
//        tags = "@failed",
//        tags = "@success",
//        dryRun = false,
//        strict = false,
        plugin = {"html:target/myreport"},
        snippets = SnippetType.CAMELCASE
//        name = "^Успешное|Успешная.*"

)
public class RunnerTest {
}