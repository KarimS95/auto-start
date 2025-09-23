package ru.mtsbank.premiumServices.premium_clients_ref.dto;

public class Response {

    private String rboId;
    private String domainId;
    private String level;
    private String openDate;
    private String commissionDate;
    private String levelReason;
    private String levelScheme;

    public String getRboId() {
        return rboId;
    }

    public void setRboId(String rboId) {
        this.rboId = rboId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
}
