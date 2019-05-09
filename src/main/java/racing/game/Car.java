package racing.game;

public class Car {
    private String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    void move() {
        position++;
    }

}
