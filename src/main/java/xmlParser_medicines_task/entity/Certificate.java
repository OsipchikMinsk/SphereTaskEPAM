package xmlParser_medicines_task.entity;



public class Certificate {
    private int id;
    private String startDate; //от какого числа
    private String expireDate;//до какокого числа
    private String registrationOfOrganization;

    private Certificate(Builder builder) {
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.expireDate = builder.expireDate;
        this.registrationOfOrganization = builder.registrationOfOrganization;
    }
    public static class Builder {
        private int id;
        private String startDate; //от какого числа
        private String expireDate;//до какокого числа
        private String registrationOfOrganization;


        public Builder withId(int idCertificate) {
            id = idCertificate;
            return this;
        }

        public Builder withStartDate(String startDateCertificate) {
            startDate = startDateCertificate;
            return this;
        }
        public Builder withExpireDate(String expireDateCertificate){
            expireDate = expireDateCertificate;
            return this;
        }
        public Builder witRegistrationOrganization(String regOrganization){
            registrationOfOrganization = regOrganization;
            return this;
        }
        public Certificate build(){
            return new Certificate(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getRegistrationOfOrganization() {
        return registrationOfOrganization;
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
