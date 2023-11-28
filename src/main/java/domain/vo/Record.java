package domain.vo;

public class Record {

    private final String name;
    private final int distance;

    public Record(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String name() {
        return name;
    }

    public int distance() {
        return distance;
    }
}
