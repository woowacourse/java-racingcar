import java.util.Random;

public class Car {
    private int location;

    public Car() {
        location = 0;
    }

    public void tryMove() {
        if ((int) (Math.random() * 9) >= 4) {
            location++;
        }
    }
}
