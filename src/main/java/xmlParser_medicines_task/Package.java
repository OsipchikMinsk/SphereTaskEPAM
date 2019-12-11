package xmlParser_medicines_task;

public class Package {
    private String typeOfPackage;
    private int amountInPackage;
    private double packagePrice;

    public Package(String typeOfPackage, int amountInPackage, double packagePrice) {
        this.typeOfPackage = typeOfPackage;
        this.amountInPackage = amountInPackage;
        this.packagePrice = packagePrice;
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

    @Override
    public String toString() {
        return "Package{" +
                "typeOfPackage='" + typeOfPackage + '\'' +
                ", amountInPackage=" + amountInPackage +
                ", packagePrice=" + packagePrice +
                '}';
    }
}
