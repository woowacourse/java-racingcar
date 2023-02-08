public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        return String.format("%s  : %s", name, "-".repeat(distance));
    }
}
