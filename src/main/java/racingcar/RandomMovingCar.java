package racingcar;

public class RandomMovingCar implements Car {

    private final int STANDARD_CAN_MOVING = 4;
    private final String name;
    private final RangedRandomNumberPicker randomNumberPicker;
    private final StringBuilder currentPositionString;
    private int position = 0;

    public RandomMovingCar(String name, RangedRandomNumberPicker randomNumberPicker) {
        this.name = name;
        this.randomNumberPicker = randomNumberPicker;
        currentPositionString = new StringBuilder(name);
        currentPositionString.append(" : ");
    }

    public void race() {
        if (!isPossibleMoveForward()) {
            return;
        }
        position += 1;
        currentPositionString.append('-');
    }

    private boolean isPossibleMoveForward() {
        int randomNumber = randomNumberPicker.pickRandomNumber();
        return randomNumber >= STANDARD_CAN_MOVING;
    }

    @Override
    public void printCurrentPosition() {
        System.out.println(currentPositionString);
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
