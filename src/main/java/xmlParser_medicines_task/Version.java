package xmlParser_medicines_task;

public class Version {
    private String type;
    private Certificate certificate;
    private Package packageOfPreparat;
    private Dosage dosage;

    public Version(String type, Certificate certificate, Package packageOfPreparat, Dosage dosage) {
        this.type = type;
        this.certificate = certificate;
        this.packageOfPreparat = packageOfPreparat;
        this.dosage = dosage;
    }

    public Version() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getPackageOfPreparat() {
        return packageOfPreparat;
    }

    public void setPackageOfPreparat(Package packageOfPreparat) {
        this.packageOfPreparat = packageOfPreparat;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Version{" +
                "type='" + type + '\'' +
                ", certificate=" + certificate +
                ", packageOfPreparat=" + packageOfPreparat +
                ", dosage=" + dosage +
                '}';
    }
}
