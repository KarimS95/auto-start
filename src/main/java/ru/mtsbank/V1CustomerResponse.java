package ru.mtsbank;

public class V1CustomerResponse {

    private long rboId;
    private long domainId;
    private String openDate;
    private String commissionDate;
    private String welcomeDuration;
    private String packageId;
    private String levelScheme;
    private Manager manager;
    private String vipServiceType;
    private String cosCode;

    public long getRboId() {
        return rboId;
    }

    public void setRboId(long rboId) {
        this.rboId = rboId;
    }

    public long getDomainId() {
        return domainId;
    }

    public void setDomainId(long domainId) {
        this.domainId = domainId;
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

    public String getWelcomeDuration() {
        return welcomeDuration;
    }

    public void setWelcomeDuration(String welcomeDuration) {
        this.welcomeDuration = welcomeDuration;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getLevelScheme() {
        return levelScheme;
    }

    public void setLevelScheme(String levelScheme) {
        this.levelScheme = levelScheme;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getVipServiceType() {
        return vipServiceType;
    }

    public void setVipServiceType(String vipServiceType) {
        this.vipServiceType = vipServiceType;
    }

    public String getCosCode() {
        return cosCode;
    }

    public void setCosCode(String cosCode) {
        this.cosCode = cosCode;
    }
}
