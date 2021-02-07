package model;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public void validateCarName(String name) {
        if(name.length() > 5 || name.length() <= 0){
            throw new IllegalArgumentException();
        }
    }

    public void movePosition() {
        this.position++;
    }

    public int getRandomNumber() {
        return RandomUtils.nextInt(0, 9);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMaxPosition(int max) {
        return max == position;
    }
}
