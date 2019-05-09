package racingcargame.model;

import racinginterface.CarInterface;

public class Car implements CarInterface {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move() {
        if (getRandomNo() >= 4) {
            position++;
        }
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}
