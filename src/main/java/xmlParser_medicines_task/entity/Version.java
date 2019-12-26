package xmlParser_medicines_task.entity;

public class Version {
    private Certificate certificate;
    private Package packageOfPreparation;
    private String typeOfVersion;

    public static  class Builder{
        private Certificate certificate;
        private Package packageOfPreparation;
        private String typeOfVersion;

        public Builder withCertificate (Certificate certificateVersion){
            certificate = certificateVersion;
            return this;
        }
        public Builder withPackage (Package packageOfPrep){
            packageOfPreparation = packageOfPrep;
            return this;
        }
        public Builder withTypeOfVersion(String type){
            typeOfVersion = type;
            return this;
        }
        public Version build(){
            return new Version(this);
        }
    }
    private Version(Builder builder) {
        this.certificate = builder.certificate;
        this.typeOfVersion = builder.typeOfVersion;
        this.packageOfPreparation = builder.packageOfPreparation;
    }


    public Certificate getCertificate() {
        return certificate;
    }

    public Package getPackageOfPreparation() {
        return packageOfPreparation;
    }

    public String getTypeOfVersion() {
        return typeOfVersion;
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
