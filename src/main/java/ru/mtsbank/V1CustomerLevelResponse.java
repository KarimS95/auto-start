package ru.mtsbank;

public class V1CustomerLevelResponse {
    private String rboId;
    private String level;
    private String levelCode;
    private String openDate;

    public String getRboId() {
        return rboId;
    }

    public void setRboId(String rboId) {
        this.rboId = rboId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(String commissionDate) {
        this.commissionDate = commissionDate;
    }

    public String getLevelReason() {
        return levelReason;
    }

    public void setLevelReason(String levelReason) {
        this.levelReason = levelReason;
    }

    public String getLevelScheme() {
        return levelScheme;
    }

    public void setLevelScheme(String levelScheme) {
        this.levelScheme = levelScheme;
    }

    private String commissionDate;
    private String levelReason;
    private String levelScheme;
}