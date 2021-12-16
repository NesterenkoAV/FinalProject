package FinalProject.Pages;

import FinalProject.OtusTest.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarOfEventsPage extends BasePage {
    public CalendarOfEventsPage(WebDriver driver) {
        super(driver);
    }

    private By Events = By.xpath("//p[contains(text(),'События')]");
    private By CalendarOfEvents = By.xpath("//a[contains(text(),'Календарь мероприятий')]");
    private By Numbers = By.xpath("//div[contains(text(),'C++ Developer. Professional')]/ancestor::*[2]");
    private By HowToLog = By.xpath("//div[contains(text(),'Как зайти в IT-компанию и остаться там')]/ancestor::*[2]");
    private By DifferentNumbers = By.xpath("//div[contains(text(),'Такие разные числа')]/ancestor::*[2]");
    private By linuxRouter = By.xpath("//div[contains(text(),'Простой роутер на Linux')]/ancestor::*[2]");
    private By Algorithm = By.xpath("//div[contains(text(),'Алгоритмы и структуры данных')]/ancestor::*[2]");
    private By systemAnalyst = By.xpath("//div[contains(text(),'«Системный аналитик. Advanced')]/ancestor::*[2]");
    private By EventType = By.cssSelector("path[d*='8.748 0 0 0-.22-.547L1.88 1.15a.75.75 0 0 0-1.06 0z']");
    private By Close = By.cssSelector("div[class*='sticky-banner__close js-sticky-banner-close']");
    private By Dod = By.cssSelector("a[title='ДОД']");
    private By Event = By.xpath("//div[@class='dod_new-events__list js-dod_new_events']");


    public void openPageCalendarOfEvents() {
        driver.findElement(Events).click();
        driver.findElement(CalendarOfEvents).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Numbers));
        element.isDisplayed();
    }

    public void showAllEvents() {
        driver.findElement(Numbers).sendKeys(Keys.CONTROL, Keys.END);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(HowToLog));
        element.isDisplayed();
        driver.findElement(HowToLog).sendKeys(Keys.CONTROL, Keys.END);
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(DifferentNumbers));
        element2.isDisplayed();
        driver.findElement(DifferentNumbers).sendKeys(Keys.CONTROL, Keys.END);
        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(Algorithm));
        element3.isDisplayed();

        driver.findElement(Algorithm).sendKeys(Keys.CONTROL, Keys.END);
        WebDriverWait wait4 = new WebDriverWait(driver, 5);
        WebElement element4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(linuxRouter));
        element4.isDisplayed();
    }

    public void checkingDate() throws Exception {
        List<WebElement> allElements = new ArrayList<WebElement>(driver.findElements(Event));
        for (WebElement event : allElements) {
            List<WebElement> contents = event.findElements(By.xpath("//div[@class='dod_new-event-content']"));
            for (WebElement content : contents) {
                WebElement el = content.findElement(By.xpath("//span[@class='dod_new-event__date-text']"));
                String elementValue = el.getText();
                //превращаем строку из локатора в объект c рус. названием месяца
                Date ru = new SimpleDateFormat("dd MMMM", new Locale("ru")).parse(elementValue);
                //Определяем год, в зависмости от месяца мероприятия.
                if (ru.getMonth() - new Date().getMonth() < 0)
                    //Если месяц события меньше текущего (new Date().getMonth()) то это след год.
                    ru.setYear(new Date().getYear() + 1);
                    // Иначе,  это текущий год
                else ru.setYear(new Date().getYear());
                //Сравниваем полученный объект с текущей датой new Date
                boolean match = ru.after(new Date()) || ru.equals(new Date());
                Assert.assertTrue(match);
            }
        }

    }

    public void filterDod() {
        driver.findElement(Close).click();
        driver.findElement(EventType).click();
        driver.findElement(Dod).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Event));
        element.isDisplayed();
        List<WebElement> allElements = new ArrayList<WebElement>(driver.findElements(Event));
        for (WebElement event : allElements) {
            List<WebElement> contents = event.findElements(By.xpath("//div[@class='dod_new-event-content']"));
            for (WebElement content : contents) {
                WebElement el = content.findElement(By.xpath("//div[@class='dod_new-type__text']"));
                String elementValue = el.getText();
                Assert.assertEquals("День открытых дверей", elementValue);
            }
        }
    }

}




