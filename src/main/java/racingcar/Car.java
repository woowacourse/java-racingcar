package racingcar;

public class Car {
    private static final int STANDARD = 4;
    private String name;
    private int position;
    private RandomUtil randomGenerator;

    public Car(String name, RandomUtil randomUtil) {
        this.name = name;
        this.position = 0;
        this.randomGenerator = randomUtil;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (randomGenerator.generate() >= STANDARD) {
            position++;
        }
    }
}
