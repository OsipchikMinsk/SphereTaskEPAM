package xmlParser_medicines_task;

import java.util.Date;

public class Certificate {
    private int id;
    private Date startDate;
    private Date finishDate;
    private String registrationOfOrganization;

    public Certificate(int id, Date startDate, Date finishDate, String registrationOfOrganization) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", registrationOfOrganization='" + registrationOfOrganization + '\'' +
                '}';
    }
}
