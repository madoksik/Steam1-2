package aquality.selenium.template.forms.pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.template.forms.BaseAppForm;

import org.openqa.selenium.By;


public class MainSteamPage extends BaseAppForm {

    private final IButton btnAbout = getElementFactory().getButton(By.xpath("//div[@class='supernav_container']//*[contains(text(),'About')]"), "About");
    private final IButton newAndInt = getElementFactory().getButton(By.xpath("//*[@id='noteworthy_tab']"), "New and interesting");
    private final IButton popUpMenu = getElementFactory().getButton(By.xpath("//*[@id='noteworthy_flyout']"), "PopUp Menu");
    private final IButton leadersOfSells = getElementFactory().getButton(By.xpath("//div[@class = 'popup_menu popup_menu_browse']//*[contains(text(), 'Top Sellers')]"), "Leaders Of Sells");
    private final IButton seemoreLeadersOfSells = getElementFactory().getButton(By.xpath("//*[@class='DialogButton _DialogLayout Primary Focusable']"), "See more leaders of sells");
    private final ICheckBox steamOSLinuxCheckbox = getElementFactory().getCheckBox(By.xpath("//span[contains(text(), 'SteamOS + Linux')]/preceding-sibling::span"), "SteamOS Linux Checkbox", ElementState.EXISTS_IN_ANY_STATE);

    private final ILabel numberOfPlayers = getElementFactory().getLabel(By.xpath("//div[text()='Narrow by number of players']/parent::div"), "numberOfPlayers");
    private final ICheckBox koopLanCheckbox = getElementFactory().getCheckBox(By.xpath("//span[contains(text(), 'LAN Co-op')]/preceding-sibling::span"), "KoopLan Checkbox", ElementState.EXISTS_IN_ANY_STATE);
    private final ICheckBox adventureCheckbox = getElementFactory().getCheckBox(By.xpath("//span[@data-loc='Adventure']"), "Multiplayer checkbox", ElementState.EXISTS_IN_ANY_STATE);

    private final IButton firstResult = getElementFactory().getButton(By.xpath("//div[@id='search_resultsRows']//a"), "First Result");

    private final ILabel firstResultName = getElementFactory().getLabel(By.xpath("//div[@id='search_resultsRows']//a//span"), "First Result Name");
    private final ILabel firstResultDate = getElementFactory().getLabel(By.xpath("//div[@id='search_resultsRows']//a//div[@class='col search_released responsive_secondrow']"), "First Result Date");
    private final ILabel firstResultPrice = getElementFactory().getLabel(By.xpath("//div[@id='search_resultsRows']//a//div[@class='discount_final_price']"), "First Result Price");

    private final ILabel firstResultPage = getElementFactory().getLabel(By.xpath("//*[@class='block game_media_and_summary_ctn']"), "First Result Page");

    private final ILabel firstResultNameClick = getElementFactory().getLabel(By.xpath("//*[@id='appHubAppName']"), "First Result Name Click");
    private final ILabel firstResultDateClick = getElementFactory().getLabel(By.xpath("//*[@class='release_date']//*[@class='date']"), "First Result Date Click");
    private final ILabel firstResultPriceClick = getElementFactory().getLabel(By.xpath("//*[@class='game_purchase_price price']"), "First Result Price Click");


    public MainSteamPage() {
        super(By.xpath("//*[title='Добро пожаловать в Steam']"), "Main page");
    }

    public void clickAbout() {
        btnAbout.click();
    }

    public void leadersOfSells() {
        newAndInt.click();
        popUpMenu.state().waitForDisplayed();
        leadersOfSells.click();
    }

    public void seeMoreLeadersOfSells() {
        seemoreLeadersOfSells.state().waitForClickable();
        seemoreLeadersOfSells.click();
    }

    public void CheckboxSteamOS() {
        steamOSLinuxCheckbox.click();
    }

    public void CheckboxKoopLan() {
        numberOfPlayers.click();
        koopLanCheckbox.click();
    }

    public void CheckboxAdventure() {
        adventureCheckbox.click();
    }


    public String nameBeforeClick() {
        String nBC = firstResultName.getAttribute("innerText");
        return nBC;
    }

    public String dataBeforeClick() {
        String dBC = firstResultDate.getAttribute("innerText");
        return dBC;
    }

    public Integer priceBeforeClick() {
        Integer pBC = Integer.parseInt(firstResultPrice.getText().replaceAll("\\D+", ""));
        return pBC;
    }

    public String nameAfterClick() {
        String nAC = firstResultNameClick.getAttribute("innerText");
        return nAC;
    }

    public String dataAfterClick() {
        String dAC = firstResultDateClick.getAttribute("innerText");
        return dAC;
    }

    public Integer priceAfterClick() {
        Integer pAC = Integer.parseInt(firstResultPriceClick.getText().replaceAll("\\D+", ""));
        return pAC;
    }

    public void firstResultGame() {
        firstResult.click();
        firstResultPage.state().waitForDisplayed();
    }

    public static class Game {
        String name;
        String data;
        Integer price;

        public Game(String name, String data, Integer price) {
            this.name = name;
            this.data = data;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Game game = (Game) o;
            return name.equals(game.name) &&
                    data.equals(game.data) &&
                    price.equals(game.price);
        }
    }
}
