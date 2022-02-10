package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        if (canMove(number)) {
            this.position++;
        }
    }

    public boolean canMove(int number) {
        return number >= 4;
//        if (number >= 4 && number <= 9) {
//            this.move();
//        }
    }
}
