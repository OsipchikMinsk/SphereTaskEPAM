package xmlParser_medicines_task.entity;

public class Version {
    private Certificate certificate;
    private Package packageOfPreparation;
    private String typeOfVersion;

    public Version(Certificate certificate, Package packageOfPreparation, String typeOfVersion) {
        this.certificate = certificate;
        this.packageOfPreparation = packageOfPreparation;
        this.typeOfVersion = typeOfVersion;
    }

    public Version() {
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getPackageOfPreparation() {
        return packageOfPreparation;
    }

    public void setPackageOfPreparation(Package packageOfPreparation) {
        this.packageOfPreparation = packageOfPreparation;
    }

    public String getTypeOfVersion() {
        return typeOfVersion;
    }

    public void setTypeOfVersion(String typeOfVersion) {
        this.typeOfVersion = typeOfVersion;
    }

    @Override
    public String toString() {
        return "Version{" +
                "certificate=" + certificate +
                ", packageOfPreparation=" + packageOfPreparation +
                ", typeOfVersion='" + typeOfVersion + '\'' +
                '}';
    }
}
