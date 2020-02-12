package racingcar.Model;

import racingcar.View.OutputView;

public class Car {
    private static final int CRITERIA_FOR_GO = 4;
    private static final int INITIAL_POSITION = 0;

    private String carName;
    private int position;


    public Car(String carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public boolean goOrNot(int randomNumber) {
        return randomNumber >= CRITERIA_FOR_GO;
    }

    public int getPosition() {
        return position;
    }

    public void showCurrentPosition() {
        StringBuilder outputValue = new StringBuilder();
        outputValue.append(carName + " : ");
        for (int i = 0; i < position; i++){
            outputValue.append("-");
        }
        OutputView.printPositionByDash(outputValue.toString());
    }
}
