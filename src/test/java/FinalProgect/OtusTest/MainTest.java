package FinalProgect.OtusTest;

import FinalProgect.Pages.CalendarOfEventsPage;
import FinalProgect.Pages.CoursePage;
import FinalProgect.Pages.MainPage;
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
        coursePage.openCurseCard();
        logger.info("Открыта карточка курса Java QA Engineer. Basic");
        coursePage.checkingCourseAttributes();
        logger.info("Проверено наличие атрибутов в картчоке курса");
        CalendarOfEventsPage calendarOfEventsPage = new CalendarOfEventsPage(driver);
        calendarOfEventsPage.openPageCalendarOfEvents();
        logger.info("Открыта форма Календарь меропиятий");
        calendarOfEventsPage.showAllEvents();
        logger.info("Открыты все меропиятия");
        calendarOfEventsPage.checkingDate();
        logger.info("Даты мероприятий больше или равны текущей дате");
        calendarOfEventsPage.filterDod();
        logger.info("Мероприятия отфильтрованы по признаку 'День открыфтых дверей'");
        }
}
