package racingcar.Model;

import racingcar.View.OutputView;

/**
 * 클래스 이름 : Car.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Car {
    public static final int RANDOM_UPPER_LIMIT = 9;
    public static final int RANDOM_LOWER_LIMIT = 1;
    private static final int CRITERIA_FOR_GO = 4;
    private static final int INITIAL_POSITION = 0;
    public static final String DASH = "-";
    public static final String COLON = " : ";

    public static StringBuilder winners = new StringBuilder();

    private String carName;
    private int position;


    public Car(String carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void goOrNot() {
        if (isGo(createRandomNumber())) {
            position++;
        }
    }

    public boolean isGo(int randomNumber) {
        return randomNumber >= CRITERIA_FOR_GO;
    }

    private int createRandomNumber() {
        return (int) (Math.random() * RANDOM_UPPER_LIMIT) + RANDOM_LOWER_LIMIT;
    }

    public boolean comparePosition(Car target) {
        return this.position > target.position;
    }

    public void showCurrentPosition() {
        StringBuilder outputValue = new StringBuilder();
        outputValue.append(carName).append(COLON);
        for (int i = 0; i < position; i++) {
            outputValue.append(DASH);
        }
        OutputView.printPositionByDash(outputValue.toString());
    }

    public void findWinners(Car car) {
        if (this.position == car.position) {
            winners.append(", ");
            winners.append(car.carName);
        }
    }
}
