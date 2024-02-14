package domain;

public class Car {

    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void move() {
        this.score++;
    }
}
