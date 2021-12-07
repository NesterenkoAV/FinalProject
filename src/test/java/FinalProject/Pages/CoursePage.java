package FinalProject.Pages;

import FinalProject.OtusTest.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoursePage extends BasePage {
    public CoursePage(WebDriver driver) {

        super(driver);
    }

    private By Curses = By.cssSelector("div[class*='header2-menu__item header2-menu__item_dropdown']>div>p");
    private By Testing = By.xpath("//*[contains(text(),'Тестирование')]");
    private By Heading = By.xpath("//div[contains(text(),'Java QA Engineer. Basic')]");
    private By Description = By.xpath("//h1[contains(text(),'Автоматизация тестирования на Java с нуля')]");
    private By DurationMonth = By.xpath("//p[contains(text(),'месяца')]");
    private By DurationHours = By.xpath("//div[contains(text(),'ак.')]");
    private By CursesCard = By.cssSelector("div[class*='lessons__new-item-bg-right']");
    private By Format = By.xpath("//p[contains(text(),'Online')]");

    public void openPageTesting() {
        driver.findElement(Curses).click();
        driver.findElement(Testing).click();
    }


    public void countCurses() {
        List<WebElement> list = driver.findElements(CursesCard);
        assertThat(11, equalTo(list.size()));
    }

    public void openCurseCard() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//img[@alt='Java QA Engineer. Basic foreground']/ancestor::*[3]")).click();
    }

    public void checkingCourseAttributes() {
        Boolean headingIsPresent = driver.findElements(Heading).size() > 0;
        Assert.assertTrue("Заголовок не найден", headingIsPresent);
        Boolean descriptionIsPresent = driver.findElements(Description).size() > 0;
        Assert.assertTrue("Поясение не задано", descriptionIsPresent);
        Boolean durationMonthPresent = driver.findElements(DurationMonth).size() > 0;
        Assert.assertTrue("Длительность обучения в месяцах не задана", durationMonthPresent);
        Boolean durationHoursPresent = driver.findElements(DurationHours).size() > 0;
        Assert.assertTrue("Длительность обучения в часах не задана", durationHoursPresent);
        Boolean formatPresent = driver.findElements(Format).size() > 0;
        Assert.assertTrue("Формат не задан", formatPresent);
    }
}
