package aquality.selenium.template.forms.pages;


import aquality.selenium.elements.interfaces.ILabel;

import aquality.selenium.template.forms.BaseAppForm;
import org.openqa.selenium.By;



public class AboutPage extends BaseAppForm {

    private final ILabel playersOnline = getElementFactory().getLabel(By.xpath("//*[@class='online_stat_label gamers_online']//parent::div"), "PlayersOnline");
    private final ILabel playersInGame = getElementFactory().getLabel(By.xpath("//*[@class='online_stat_label gamers_in_game']//parent::div"), "PlayersInGame");

    public AboutPage() {
        super(By.xpath("//*[title='Steam — превосходная игровая Интернет-платформа']"), "About page");
    }
    public Integer Players() {
        Integer p = Integer.parseInt(playersOnline.getText().replaceAll("\\D+", ""));
        return p;
    }
    public Integer Gamers() {
        Integer g = Integer.parseInt(playersInGame.getText().replaceAll("\\D+", ""));
        return g;
    }
}