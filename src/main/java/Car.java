import java.util.Random;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public void tryMove() {
        if ((int) (Math.random() * 9) >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
