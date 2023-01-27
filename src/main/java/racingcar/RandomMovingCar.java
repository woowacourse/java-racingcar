package racingcar;

public class RandomMovingCar implements Car {

    private final int STANDARD_CAN_MOVING = 4;
    private final String name;
    private final RangedRandomNumberPicker randomNumberPicker;
    private int position = 0;

    public RandomMovingCar(String name, RangedRandomNumberPicker randomNumberPicker) {
        this.name = name;
        this.randomNumberPicker = randomNumberPicker;
    }

    public void race() {
        if (isPossibleMoveForward()) {
            position += 1;
        }
    }

    private boolean isPossibleMoveForward() {
        int randomNumber = randomNumberPicker.pickRandomNumber();
        return randomNumber >= STANDARD_CAN_MOVING;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}
