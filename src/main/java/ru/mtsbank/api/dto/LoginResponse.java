package ru.mtsbank.api.dto;

public class LoginResponse {

    private boolean success;
    private int status;
    private String message;
    private DataResponse data;
    private String phone;


    public boolean getSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public DataResponse getData() {
        return data;
    }

    public String getPhone() {
        return phone;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
