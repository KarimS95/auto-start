package ru.mtsbank.premium.web.mtsbanksite.constans;

public enum Constants {

    URL_TEST ("https://site-pred1.mbrd.ru/"),
    PREMIUM_TAB_TEXT("Премиум"),
    PREMIUM_TEST_URL ("https://site-pred1.mbrd.ru/chastnim-licam/premium/premium-package/"),

    PREMIUM_GENERAL_HEADER("Премиальное обслуживание\nв МТС Банке"),
    PREMIUM_AFTER_HEADER_TEXT("До 16,2% доходность по вкладам\n0 ₽ первые 2 месяца\nФинансовые привилегии и уникальные услуги"),
    PREMIUM_AFTER_HEADER_FIRST_BUTTON_TEXT("Стать премиум-клиентом"),
    PREMIUM_AFTER_HEADER_SECOND_BUTTON_TEXT("Остались вопросы о Премиум?"),
    PREMIUM_ABOUT_SERVICES_TAB_TEXT("Об услугах"),
    PREMIUM_SERVICES_AND_TARIFFS_TAB("Сервисы и тарифы"),
    PREMIUM_SERVICE_HEADER("Премиальное обслуживание"),
    PREMIUM_NEXT_BUTTON("Продолжить"),

    PREMIUM_SERVICE_FIRST_BLOCK_HEADER("Персональный менеджер"),
    PREMIUM_SERVICE_FIRST_BLOCK_INFO("Ваш личный советник и помощник в банке"),
    PREMIUM_SERVICE_SECOND_BLOCK_HEADER("Выделенная линия 24/7"),
    PREMIUM_SERVICE_SECOND_BLOCK_INFO("Круглосуточная поддержка по важным вопросам"),
    PREMIUM_SERVICE_THIRD_BLOCK_HEADER("Обслуживание без очередей"),
    PREMIUM_SERVICE_THIRD_BLOCK_INFO("Без ожидания в банке или на линии поддержки");





    private final String stringValue;

    Constants(String stringValue) {
        this.stringValue = stringValue;
    }


    public String getStringValue() {
        return stringValue;
    }

}
