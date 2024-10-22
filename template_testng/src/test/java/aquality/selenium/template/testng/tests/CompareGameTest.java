package aquality.selenium.template.testng.tests;

import aquality.selenium.template.testng.steps.ui.MainSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

public class CompareGameTest extends BaseTest {
    @Inject
    MainSteps mainSteps;

    @Test(description = "Compare game description")
    public void compareGameDescription() {
        mainSteps.clickleadersOfSells();
        mainSteps.clickSeeMoreLeadersOfSells();
        mainSteps.selectCheckboxSteam();
        mainSteps.selectCheckboxKoopLan();
        mainSteps.selectCheckboxAdventure();
        mainSteps.compareFirstResult();

    }
}
