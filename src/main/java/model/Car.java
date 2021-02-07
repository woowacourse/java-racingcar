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
        if(name.length() > 5){
            throw new IllegalArgumentException("잘못된 길이입니다.");
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

//    @Override
//    public int compareTo(Car car) {
//        if (this.getPosition() < car.getPosition()) {
//            return -1;
//        }
//
//        if (this.getPosition() > car.getPosition()) {
//            return 1;
//        }
//
//        return 0;
//    }
}
