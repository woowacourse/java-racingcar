package racing.domain;

import racing.util.RandomNumberGenerator;

public class Car {
    private static final int GO_FORWRARD_CRITERIA_NUM = 4;
    private static final int GO_STEP = 1;

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this.name = name;
    }

    public void tryGoForward() {
        int randomNum = RandomNumberGenerator.generate(10);
        if (isGo(randomNum)) position += GO_STEP;
    }

    private boolean isGo(int number) {
        if (number >= GO_FORWRARD_CRITERIA_NUM) return true;
        return false;
    }

    @Override
    public String toString() {
        String positionString = "";
        for (int i = 0; i < position; i++) {
            positionString += "-";
        }
        return name + " : " + positionString;
    }

    public boolean isSameRank(Car another) {
        return another.isSamePosition(position);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean isFartherThan(Car another) {
        return !another.isBiggerPosition(position);
    }

    public boolean isBiggerPosition(int position) {
        return this.position > position;
    }

    public void printName() {
        System.out.print(name);
    }
}