package FinalProject.OtusTest;

import FinalProject.Pages.CalendarOfEventsPage;
import FinalProject.Pages.CoursePage;
import FinalProject.Pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class MainTest extends BaseTest {
    private Logger logger = LogManager.getLogger(Logger.class);

    @Test
    public void mainTest() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        logger.info("Сайт открыт");
        CoursePage coursePage = new CoursePage(driver);
        coursePage.openPageTesting();
        logger.info("Открыта форма Тестирование");
        coursePage.countCurses();
        logger.info("11 карточке курсов");
        cleanUP();
    }

    @Test
    public void checkingCourseAttributes() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        logger.info("Сайт открыт");
        CoursePage coursePage = new CoursePage(driver);
        coursePage.openPageTesting();
        logger.info("Открыта форма Тестирование");
        coursePage.openCurseCard();
        logger.info("Открыта карточка курса Java QA Engineer. Basic");
        coursePage.checkingCourseAttributes();
        logger.info("Проверено наличие атрибутов в картчоке курса");
        cleanUP();
    }

    @Test
    public void checkingEventsDate() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        logger.info("Сайт открыт");
        CalendarOfEventsPage calendarOfEventsPage = new CalendarOfEventsPage(driver);
        calendarOfEventsPage.openPageCalendarOfEvents();
        logger.info("Открыта форма Календарь меропиятий");
        calendarOfEventsPage.showAllEvents();
        logger.info("Открыты все меропиятия");
        calendarOfEventsPage.checkingDate();
        logger.info("Даты мероприятий больше или равны текущей дате");
        cleanUP();
    }

    @Test
    public void checkingfilterDod() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openOtus();
        logger.info("Сайт открыт");
        CalendarOfEventsPage calendarOfEventsPage = new CalendarOfEventsPage(driver);
        calendarOfEventsPage.openPageCalendarOfEvents();
        calendarOfEventsPage.filterDod();
        logger.info("Мероприятия отфильтрованы по признаку 'День открыфтых дверей'");
        cleanUP();
        }
}
