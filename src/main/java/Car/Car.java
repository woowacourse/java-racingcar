package Car;

public class Car {

    private String name;

    public Car(String name) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
