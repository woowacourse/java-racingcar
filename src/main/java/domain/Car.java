package domain;

import java.util.Random;

public class Car {
    private static int MIN_MOVE_NUMBER = 4;

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

    public int getBiggerPosition(int compareNum) {
       return Math.max(position, compareNum);
    }

    public boolean isMaxPosition(int compareNum) {
        return compareNum == position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " : " + new String(new char[position]).replace("\0", "-");
    }
}
