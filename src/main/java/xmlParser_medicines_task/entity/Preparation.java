package xmlParser_medicines_task.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Preparation {

    private String name; //название препарата
    private String pharm; //фирма производитель
    private Set<String> analogs;
    private Set<Version> versions;
    private String group;

    public static class Builder {
        private String name; //название препарата
        private String pharm; //фирма производитель
        private Set<String> analogs;
        private Set<Version> versions;
        private String group;

        public Builder() {
            analogs = new HashSet<>();
            versions = new HashSet<>();
        }
        public Builder withName(String preparationName){
            name = preparationName;
            return this;
        }
        public Builder withPharm(String pharmName){
            pharm = pharmName;
            return this;
        }
        public Builder withAnalog(String analog){
            analogs.add(analog);
            return this;
        }
        public Builder withVersion (Version version){
            versions.add(version);
            return this;
        }
        public Builder withGroup(String groupPreparation){
            group = groupPreparation;
            return this;
        }
        public Preparation build(){
            return new Preparation(this);
        }
    }

    private Preparation(Builder builder) {
        this.name = builder.name;
        this.pharm = builder.pharm;
        this.analogs = builder.analogs;
        this.versions = builder.versions;
        this.group = builder.group;
    }

    public String getGroup() {
        return group;
    }

    public String getAnalog(String analog) {
        if (analogs.contains(analog)) {
            return analog;
        }
        return null;
    }
    public Version getVersion (Version version){
        if(versions.contains(version)){
            return version;
        }
        return null;
    }
    public String getName() {
        return name;
    }


    public String getPharm() {
        return pharm;
    }


    public Set<String> getAnalogs() {
        return analogs;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preparation that = (Preparation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pharm, that.pharm) &&
                Objects.equals(analogs, that.analogs) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pharm, analogs, versions, group);
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", analogs=" + analogs +
                ", versions=" + versions +
                ", group='" + group + '\'' +
                '}';
    }

}
