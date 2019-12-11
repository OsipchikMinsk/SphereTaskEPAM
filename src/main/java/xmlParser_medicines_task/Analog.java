package xmlParser_medicines_task;

public class Analog {
    private String name;

    public Analog() {
    }

    public Analog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Analog{" +
                "name='" + name + '\'' +
                '}';
    }
}

