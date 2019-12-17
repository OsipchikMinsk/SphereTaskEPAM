package xmlParser_medicines_task.entity;

public class Package {
    private String typeOfPackage;
    private int amountInPackage;
    private double packagePrice;
    private String dosage;
    private String periodicity;

    public Package(String typeOfPackage, int amountInPackage,
                   double packagePrice, String dosage, String periodicity) {
        this.typeOfPackage = typeOfPackage;
        this.amountInPackage = amountInPackage;
        this.packagePrice = packagePrice;
        this.dosage = dosage;
        this.periodicity = periodicity;
    }

    public Package() {
    }

    public String getTypeOfPackage() {
        return typeOfPackage;
    }

    public void setTypeOfPackage(String typeOfPackage) {
        this.typeOfPackage = typeOfPackage;
    }

    public int getAmountInPackage() {
        return amountInPackage;
    }

    public void setAmountInPackage(int amountInPackage) {
        this.amountInPackage = amountInPackage;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Package{" +
                "typeOfPackage='" + typeOfPackage + '\'' +
                ", amountInPackage=" + amountInPackage +
                ", packagePrice=" + packagePrice +
                ", dosage='" + dosage + '\'' +
                ", periodicity='" + periodicity + '\'' +
                '}';
    }
}
