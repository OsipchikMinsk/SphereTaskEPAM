package xmlParser_medicines_task;

import java.util.Set;

public class Preparation {

    private String name;
    private String pharm; //фирма производитель
    private String group;
    //todo enum group
    private Set<Analog> analogs;
    private Set<Version> versions;

    public Preparation(String name, String pharm, String group, Set<Analog> analogs, Set<Version> versions) {
        this.name = name;
        this.pharm = pharm;
        this.group = group;
        this.analogs = analogs;
        this.versions = versions;
    }

    public Preparation() {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Set<Analog> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(Set<Analog> analogs) {
        this.analogs = analogs;
    }

    public Set<Version> getVersions() {
        return versions;
    }

    public void setVersions(Set<Version> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + analogs +
                ", versions=" + versions +
                '}';
    }
}
