package aquality.selenium.template.testng.tests;


import aquality.selenium.template.testng.steps.ui.AboutSteps;
import aquality.selenium.template.testng.steps.ui.MainSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

public class ComparePlayersTest extends BaseTest {
    @Inject
    MainSteps mainSteps;

    @Inject
    AboutSteps aboutSteps;

    @Test(description = "Compare number of players and the number online")
    public void comparePlayersAndGamers() {
        mainSteps.clickAboutButton();
       aboutSteps.comparePlayersAndGamers();

    }
}
