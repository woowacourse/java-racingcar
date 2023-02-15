package racing.domain;

import racing.util.RandomMaker;
import racing.validate.InputVerifier;

public class Car {
    public static final int DECIDE_NUMBER = 4;

    private final String name;
    private int step;

    public Car(String name) {
        InputVerifier.validateNameLength(name);
        this.name = name;
        this.step = 0;
    }

    public void execute() {
        if (decideMove(RandomMaker.getRandomNumber())) {
            moving();
        }
    }

    private boolean decideMove(int randomNumber) {
        return DECIDE_NUMBER <= randomNumber;
    }

    private void moving() {
        increaseStep();
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void increaseStep() {
        this.step++;
    }

}
