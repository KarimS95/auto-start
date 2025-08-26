package ru.mtsbank.hw.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.hw.pages.HomePage;
import ru.mtsbank.hw.pages.WebInputsPage;

public class WebInputsPageTest extends BaseTest {


    @Test
    public void testOpenWebInputsPageWithClickOnLink() {
        HomePage homePage = new HomePage(driverContainer);
        WebInputsPage webInputsPage = homePage.openWebInputsPageWithClickOnLink();

        Assert.assertEquals(webInputsPage.getWebInputsPageURL(), WEB_INPUTS_PAGE_URL);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetWebInputsPageCardHeader() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getWebInputsPageCardHeader(), WEB_INPUTS_PAGE_CARD_HEADER);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetWebInputsPageCardText() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getWebInputsPageCardText(), WEB_INPUTS_PAGE_CARD_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetWebInputsPageFooter() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getWebInputsPageFooter(), WEB_INPUTS_PAGE_FOOTER);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetWebInputsPageDisplayInputsButtonName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getWebInputsPageDisplayInputsButtonName(), DISPLAY_INPUTS_BUTTON);
    }


    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetWebInputsPageClearInputsButtonName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getWebInputsPageClearInputsButtonName(), CLEAR_INPUTS_BUTTON);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckDisplayInputsButton() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkDisplayInputsButton());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckClearInputsButton() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkClearInputsButton());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetInputNumberFieldName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getInputNumberFieldName(), INPUT_NUMBER_NAME);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetInputTextFieldName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getInputTextFieldName(), INPUT_TEXT_NAME);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckInputNumberField() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkInputNumberField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckInputTextField() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkInputTextField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetInputPasswordFieldName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getInputPasswordFieldName(), INPUT_PASSWORD_NAME);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckInputPasswordField() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkInputPasswordField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testGetInputDateFieldName() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertEquals(webInputsPage.getInputDateFieldName(), INPUT_DATE_NAME);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenWebInputsPageWithClickOnLink")
    public void testCheckInputDateField() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);

        Assert.assertTrue(webInputsPage.checkInputDateField());
    }

    @Test(dependsOnGroups = "parallel")
    public void testClickOnDisplayInputsButton() {
        WebInputsPage webInputsPage = new WebInputsPage(driverContainer);
        webInputsPage.clickOnDisplayInputsButton();

        Assert.assertEquals(webInputsPage.getOutputNumberFieldName(), OUTPUT_NUMBER_NAME);
        Assert.assertEquals(webInputsPage.getOutputTextFieldName(), OUTPUT_TEXT_NAME);
        Assert.assertEquals(webInputsPage.getOutputPasswordFieldName(), OUTPUT_PASSWORD_NAME);
        Assert.assertEquals(webInputsPage.getOutputDateFieldName(), OUTPUT_DATE_NAME);
        Assert.assertTrue(webInputsPage.checkOutputNumberField());
        Assert.assertTrue(webInputsPage.checkOutputTextField());
        Assert.assertTrue(webInputsPage.checkOutputPasswordField());
        Assert.assertTrue(webInputsPage.checkOutputDateField());
    }

}
