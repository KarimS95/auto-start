package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsbanksite.pages.HomePage;
import ru.mtsbank.premium.web.mtsbanksite.pages.PremiumPage;

public class PremiumPageTest extends BaseTest {

    private final String PREMIUM_GENERAL_HEADER = "Премиальное обслуживание\nв МТС Банке";
    private final String PREMIUM_AFTER_HEADER_TEXT = "До 16,2% доходность по вкладам\n0 ₽ первые 2 месяца\nФинансовые привилегии и уникальные услуги";
    private final String PREMIUM_AFTER_HEADER_FIRST_BUTTON_TEXT = "Стать премиум-клиентом";
    private final String PREMIUM_AFTER_HEADER_SECOND_BUTTON_TEXT = "Остались вопросы о Премиум?";


    @Test
    public void testGetPremiumPageGeneralHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumLink();
        String header = premiumPage.getPremiumPageGeneralHeader();

        Assert.assertEquals(header, PREMIUM_GENERAL_HEADER);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderText();

        Assert.assertEquals(text, PREMIUM_AFTER_HEADER_TEXT);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderFirstButtonText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderFirstButtonText();

        Assert.assertEquals(text, PREMIUM_AFTER_HEADER_FIRST_BUTTON_TEXT);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderSecondButtonText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderSecondButtonText();

        Assert.assertEquals(text, PREMIUM_AFTER_HEADER_SECOND_BUTTON_TEXT);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testCheckFirstButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkAfterHeaderFirstButton();

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testCheckSecondButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkAfterHeaderSecondButton();

        Assert.assertTrue(isTrue);
    }



}
