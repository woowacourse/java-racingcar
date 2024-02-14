public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        Validator.validateCarName(name);
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void go() {
        location++;
    }
}
