package ru.mtsbank;

public class Manager {

    private String code;
    private String name;
    private boolean isContactCenter;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsContactCenter() {
        return isContactCenter;
    }

    public void setContactCenter(boolean isContactCenter) {
        this.isContactCenter = isContactCenter;
    }
}
