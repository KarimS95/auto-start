package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumLevelPage;
import ru.mtsbank.premium.pages.PremiumPage;

public class PremiumLevelTest extends BaseTest {

    private final String PREMIUM_LEVEL_URL = "https://online.mtsdengi-test.mbrd.ru/premium/level";
    private final String EXPECTED_LEVEL_SHEET_HEADER = "уровень";
    private final String EXPECTED_LEVEL_PAGE_HEADER = "Премиальное обслуживание";
    private final String EXPECTED_TERMS_HEADER = "Условия обслуживания";
    private final String EXPECTED_FIRST_HEADER = "Cреднемесячный остаток";
    private final String EXPECTED_SECOND_HEADER = "Покупки";
    private final String EXPECTED_THIRD_HEADER = "Cреднемесячный остаток на тек";
    private final String EXPECTED_TERMS_CARD_HEADER = "Уровень присваивается первого числа каждого месяца при выполнении одного из условий в прошлом месяце";
    private final String FIRST_CLIENTS_CASE = "Топ\n" +
            "Среднемесячный остаток: от 5 млн ₽\n" +
            "Покупки по премиальным картам: от 100 000 ₽ + остаток: от 4 млн ₽\n" +
            "Плюс\n" +
            "Среднемесячный остаток на текущих и карточных счетах: от 500 тыс ₽\n" +
            "Среднемесячный остаток: от 2 млн ₽\n" +
            "Покупки по премиальным картам: от 50 000 ₽ + остаток: от 1,4 млн ₽\n" +
            "Плюс 2024\n" +
            "Среднемесячный остаток: от 1,4 млн ₽\n" +
            "Лайт\n" +
            "При невыполнении условий других уровней\n" +
            "Обслуживание: 2 500 ₽ за месяц";
    private final String SECOND_CLIENTS_CASE = "Топ\n" +
            "Среднемесячный остаток: от 5 млн ₽\n" +
            "Покупки по премиальным картам: от 100 000 ₽ + остаток: от 4 млн ₽\n" +
            "Плюс\n" +
            "Среднемесячный остаток на текущих и карточных счетах: от 500 тыс ₽\n" +
            "Среднемесячный остаток: от 2 млн ₽\n" +
            "Покупки по премиальным картам: от 50 000 ₽ + остаток: от 1,4 млн ₽\n" +
            "Лайт\n" +
            "При невыполнении условий других уровней\n" +
            "Обслуживание: 2 500 ₽ за месяц";


    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumLevelPage premiumLevelPage = premiumPage.openPremiumLevelPage();

        Assert.assertTrue(premiumLevelPage.getLevelPageHeader().contains(EXPECTED_LEVEL_PAGE_HEADER));
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeader")
    public void testOpenLevelSheet()  {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.openLevelSheet().contains(EXPECTED_LEVEL_SHEET_HEADER));

        premiumLevelPage.closeLevelSheet();
    }

    @Test(dependsOnMethods = "testOpenLevelSheet")
    public void testOpenServicesTermsButton() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertEquals(premiumLevelPage.openServicesTermsListButton(),EXPECTED_TERMS_HEADER);
    }

    @Test(dependsOnMethods = "testOpenServicesTermsButton", groups = "parallel")
    public void testGetCardHeaderTermsList() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertEquals(premiumLevelPage.getCardHeaderTermsList(),EXPECTED_TERMS_CARD_HEADER);
    }

    @Test(dependsOnMethods = "testOpenServicesTermsButton", groups = "parallel")
    public void testGetLevelsTermsList() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String termsList = premiumLevelPage.getLevelsTermsList();
        boolean isTrue = termsList.equals(FIRST_CLIENTS_CASE) || termsList.equals(SECOND_CLIENTS_CASE);
        premiumLevelPage.returnBack();

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnGroups = "parallel")
    public void testOpenFirstI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openFirstI();
        Assert.assertEquals(header,EXPECTED_FIRST_HEADER);

        premiumLevelPage.closeI();
    }


    @Test(dependsOnMethods = "testOpenFirstI")
    public void testOpenSecond() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openSecondI();
        boolean isTrue = header.contains(EXPECTED_SECOND_HEADER);

        Assert.assertTrue(isTrue);

        premiumLevelPage.closeI();
    }


    @Test(dependsOnMethods = "testOpenSecond")
    public void testOpenThirdI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openThirdI();
        boolean isTrue = header.contains(EXPECTED_THIRD_HEADER);

        Assert.assertTrue(isTrue);

        premiumLevelPage.closeI();
    }




}
