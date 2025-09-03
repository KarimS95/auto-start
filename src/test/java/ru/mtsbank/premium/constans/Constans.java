package ru.mtsbank.premium.constans;


public enum Constans {

    BASE_URLS_ARRAY (new String[]{"https://online.mtsdengi-dev.mbrd.ru/","https://online.mtsdengi-test.mbrd.ru/"}),
    PREMIUM_WIDGET_NAMES (new String[]{"Премиум", "Premium", "Прайвет", "Private"}),
    LEVEL_PAGE_NAMES (new String[]{"Уровень", "уровень", "Private", "private"}),
    MANAGER_VALUE("менеджер"),
    MANAGER_CALL_BUTTON("позвонить"),
    MANAGER_MESSAGE_BUTTON("написать"),
    LEVEL_PURCHASES_TERMS_PDF_URL("https://static.mtsdengi.ru/portal-frontend-premium/documents/pravila-nachisleniya.pdf"),
    LEVEL_RULES_PDF_URL("https://static.mtsdengi.ru/portal-frontend-premium/documents/moj-uroven-obsluzhivaniya-"),
    LEVEL_SHEET_HEADER("уровень"),
    LEVEL_PAGE_HEADER("Премиальное обслуживание"),
    LEVEL_TERMS_HEADER("Условия обслуживания"),
    LEVEL_FIRST_HEADER("Cреднемесячный остаток"),
    LEVEL_SECOND_HEADER( "Покупки"),
    LEVEL_THIRD_HEADER("Cреднемесячный остаток на тек"),
    LEVEL_TERMS_CARD_HEADER("Уровень присваивается первого числа каждого месяца при выполнении одного из условий в прошлом месяце"),
    LEVEL_FIRST_CLIENTS_CASE("Топ\n" +
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
            "Обслуживание: 2 500 ₽ за месяц"),
    LEVEL_SECOND_CLIENTS_CASE ("Топ\n" +
            "Среднемесячный остаток: от 5 млн ₽\n" +
            "Покупки по премиальным картам: от 100 000 ₽ + остаток: от 4 млн ₽\n" +
            "Плюс\n" +
            "Среднемесячный остаток на текущих и карточных счетах: от 500 тыс ₽\n" +
            "Среднемесячный остаток: от 2 млн ₽\n" +
            "Покупки по премиальным картам: от 50 000 ₽ + остаток: от 1,4 млн ₽\n" +
            "Лайт\n" +
            "При невыполнении условий других уровней\n" +
            "Обслуживание: 2 500 ₽ за месяц"),

    CASHBACK_HEADER(new String[]{"Кешбэк", "кешбэк"}),
    CASHBACK_CHECKBOXES_COUNT(5),
    LEVEL_PAGE_URLS(new String[]{"https://online.mtsdengi-test.mbrd.ru/premium/level","https://online.mtsdengi-dev.mbrd.ru/premium/level"}),
    CASHBACK_URLS(new String[]{"https://online.mtsdengi-test.mbrd.ru/premium/cashback", "https://online.mtsdengi-dev.mbrd.ru/premium/cashback"}),
    CASHBACK_PARTNERS_URLS(new String[]{"https://vamprivet.ru/supreme-restaurants/","https://vamprivet.ru/afisha/"}),
    CASHBACK_TERMS_URLS(new String[]{
            "https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf",
            "https://static.mtsdengi.ru/portal-frontend-private-banking/documents/usloviya-nachisleniya-keshbeka-private.pdf"}),
    CASHBACK_BASE_CASHBACK_BLOCK_HEADER("Базовый кешбэк"),
    CASHBACK_INCREASED_CASHBACK_BLOCK_HEADER("Повышенный кешбэк"),
    CASHBACK_SUBSCRIPTION_BLOCK_HEADER("С подпиской МТС PREMIUM"),
    CASHBACK_FROM_PAYMENT_SYSTEM_BLOCK_HEADER("От платежной системы МИР"),
    CASHBACK_HOW_TO_GET_BLOCK_HEADER("Как получить");

    private String stringValue;
    private String[] arrayStringValue;
    private Integer intValue;

//    Constans(Object object) {
//        if (object instanceof String) {
//            this.stringValue = (String) object;
//        } else if (object instanceof String[]) {
//            this.arrayStringValue = (String[]) object;
//        } else if (object instanceof Integer) {
//            this.intValue = (Integer) object;
//        }
//    }

    Constans(String stringValue) {
        this.stringValue = stringValue;
    }

    Constans(String[] arrayStringValue) {
        this.arrayStringValue = arrayStringValue;
    }

    Constans(Integer intValue) {
        this.intValue = intValue;
    }


    public String getStringValue() {
        return stringValue;
    }

    public String[] getArrayStringValue() {
        return arrayStringValue;
    }

    public int getIntValue() {
        return intValue;
    }

}
