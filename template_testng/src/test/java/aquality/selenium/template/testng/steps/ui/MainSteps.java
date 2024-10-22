package aquality.selenium.template.testng.steps.ui;


import aquality.selenium.template.forms.pages.MainSteamPage;
import com.google.inject.Inject;
import io.qameta.allure.Step;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MainSteps {
    @Inject
    private MainSteamPage mainSteamPage;

   @Step("Click About")
    public void clickAboutButton() {
        mainSteamPage.clickAbout();
    }

    @Step("Click Leaders of sells")
    public void clickleadersOfSells() {
        mainSteamPage.leadersOfSells();
    }

    @Step("See more leaders of sells")
    public void clickSeeMoreLeadersOfSells() {
        mainSteamPage.seeMoreLeadersOfSells();
    }

    @Step("Select SteamOS+Linux checkbox")
    public void selectCheckboxSteam() {
        mainSteamPage.CheckboxSteamOS();
    }

    @Step("Select KoopLan checkbox")
    public void selectCheckboxKoopLan() {
        mainSteamPage.CheckboxKoopLan();
    }

    @Step("Select Adventure checkbox")
    public void selectCheckboxAdventure() {
        mainSteamPage.CheckboxAdventure();
    }

    @Step("Compare players and gamers")
    public void compareFirstResult() {
        MainSteamPage.Game gameBeforeClick = new MainSteamPage.Game(mainSteamPage.nameBeforeClick(), mainSteamPage.dataBeforeClick(), mainSteamPage.priceBeforeClick());
        mainSteamPage.firstResultGame();
        MainSteamPage.Game gameAfterClick = new MainSteamPage.Game(mainSteamPage.nameAfterClick(), mainSteamPage.dataAfterClick(), mainSteamPage.priceAfterClick());
        assertEquals(gameBeforeClick, gameAfterClick, "Данные не совпадают");
    }
}