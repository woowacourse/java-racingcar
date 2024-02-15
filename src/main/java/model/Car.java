package model;

public class Car {
    private final Name name;
    private int distance;

    public Car(Name name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        distance++;
    }

    public String showDistance() {
        String dis = "";
        for (int i = 0; i < distance; i++) {
            dis += "-";
        }
        return dis;
    }
}
