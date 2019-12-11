package xmlParser_medicines_task;

public class Dosage {
    private double dosage;
    private String periodicity;

    public Dosage(double dosage, String periodicity) {
        this.dosage = dosage;
        this.periodicity = periodicity;
    }

    public Dosage() {
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
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
        return "Dosage{" +
                "dosage=" + dosage +
                ", periodicity='" + periodicity + '\'' +
                '}';
    }
}
