package xmlParser_medicines_task.entity;

public class Package {
    private String typeOfPackage;
    private int amountInPackage;
    private double packagePrice;
    private String dosage;
    private String periodicity;

    public static class Builder{
        private String typeOfPackage;
        private int amountInPackage;
        private double packagePrice;
        private String dosage;
        private String periodicity;

     public Builder withTypeOfPackage (String typePackage){
         typeOfPackage = typePackage;
         return this;
     }
     public Builder withAmountInPackage(int amount){
         amountInPackage = amount;
         return this;
     }
     public Builder withPackagePrice(double pRice){
         packagePrice = pRice;
         return this;
     }
     public Builder withDosage(String dosageOfPreparation){
         dosage = dosageOfPreparation;
         return this;
     }
     public Builder withPeriodicity (String periodicityOfPreparation){
         periodicity = periodicityOfPreparation;
         return this;
     }
     public Package build (){
         return new Package(this);
     }

    }
    private Package(Builder builder) {
        this.typeOfPackage = builder.typeOfPackage;
        this.amountInPackage = builder.amountInPackage;
        this.packagePrice = builder.packagePrice;
        this.dosage = builder.dosage;
        this.periodicity = builder.periodicity;
    }



    public int getAmountInPackage() {
        return amountInPackage;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public String getDosage() {
        return dosage;
    }

    public String getPeriodicity() {
        return periodicity;
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
