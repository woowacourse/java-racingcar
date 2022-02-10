package racingcar.domain;

import java.util.Random;
import java.util.Scanner;

public class Car {
    private static final int GO_MINIMUM = 4;

    private final String name;
    private int position = 0;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        if (random.nextInt(10) >= GO_MINIMUM) {
            position += 1;
        }
    }

    public void showInfo() {
        String info = getName() + " : ";
        for (int i = 0; i < position; i++) {
            info += "-";
        }
        System.out.println(info);
    }
}
