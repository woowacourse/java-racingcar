package domain;

import java.util.Random;

public class Car {
    private static int MIN_MOVE_NUMBER = 4;
    private static int BOUND_NUMBER = 10;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int judgeMove(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position++;
        }
        return position;
    }

    private int makeRandomNumber() {
        Random random = new Random();

        return random.nextInt(BOUND_NUMBER);
    }

    @Override
    public String toString() {
        return name + " : " + new String(new char[position]).replace("\0", "-");
    }
}
