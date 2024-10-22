package aquality.selenium.template.testng.steps.ui;


import aquality.selenium.template.forms.pages.AboutPage;
import com.google.inject.Inject;
import io.qameta.allure.Step;
import static org.testng.Assert.assertTrue;

public class AboutSteps {
    @Inject
    private AboutPage aboutPage;

    @Step("Compare players and gamers")
    public void comparePlayersAndGamers() {
        assertTrue(aboutPage.Players() > aboutPage.Gamers(), "Число игроков сейчас больше, чем онлайн");
    }
}
