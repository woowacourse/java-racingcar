package racingcar.domain;

public class Car {
    public static final int RANDOM_NUM_SCOPE = 10;
    public static final int MIN_NUM_TO_ACCELERATE = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position =  0;
    }

    public void accelerate() {
        int numToAccelerate = (int) (Math.random()* RANDOM_NUM_SCOPE);
        if (numToAccelerate >= MIN_NUM_TO_ACCELERATE) {
            position++;
        }
    }
}
