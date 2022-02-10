package racingcargame.model;

import racingcargame.utils.RandomNumberGenerator;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar() {
        if (isMoveCar()) {
            position ++;
        }
    }

    private boolean isMoveCar() {
        int number = RandomNumberGenerator.makeRandomNumber();
        return number >= 4;
    }
}
