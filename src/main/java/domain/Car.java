package domain;

public class Car {
    public final String name;
    public int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public void incLocation() {
        location += 1;
    }

    public String getCarName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
