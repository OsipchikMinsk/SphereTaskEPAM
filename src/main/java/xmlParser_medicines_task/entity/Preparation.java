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

    public Preparation(String name, String pharm, Set<String> analogs, Set<Version> versions, String group) {
        this.name = name;
        this.pharm = pharm;
        this.analogs = analogs;
        this.versions = versions;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Preparation() {
        versions = new HashSet<>();
        analogs = new HashSet<>();
    }
    public void setAnalog (String analog){
        analogs.add(analog);
    }
    public void setVersion (Version version){
        versions.add(version);
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public Set<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(Set<String> analogs) {
        this.analogs = analogs;
    }

    public Set<Version> getVersions() {
        return versions;
    }

    public void setVersions(Set<Version> versions) {
        this.versions = versions;
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
