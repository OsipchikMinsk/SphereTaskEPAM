package xmlParser_medicines_task.entity;

import java.util.Date;

public class Certificate {
    private int id;
    private String startDate; //от какого числа
    private String expireDate;//до какокого числа
    private String registrationOfOrganization;

    public Certificate(int id, String startDate, String expireDate, String registrationOfOrganization) {
        this.id = id;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.registrationOfOrganization = registrationOfOrganization;
    }

    public Certificate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getRegistrationOfOrganization() {
        return registrationOfOrganization;
    }

    public void setRegistrationOfOrganization(String registrationOfOrganization) {
        this.registrationOfOrganization = registrationOfOrganization;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", registrationOfOrganization='" + registrationOfOrganization + '\'' +
                '}';
    }
}
