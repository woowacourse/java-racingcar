package domain;

import java.util.Random;

public class Car {
    private int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String trace = new String(new char[position]).replace("\0", "-");
        return name + " : " + trace;
    }

    public String judgeMove(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position ++;
            return "Go";
        }
        return "Stop";
    }

    public int getBiggerPosition(int compareNum) {
        return Math.max(position, compareNum);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
