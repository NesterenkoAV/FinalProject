package FinalProgect.Pages;

import FinalProgect.OtusTest.BasePage;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    private final String OTUS_URL = "https://otus.ru/";

    public void openOtus() {
        driver.get(OTUS_URL);
    }
}
