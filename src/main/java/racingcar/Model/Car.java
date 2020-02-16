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
    private static final int INITIAL_POSITION = 0;
    public static final String DASH = "-";
    public static final String COLON = " : ";

    public static StringBuilder winners = new StringBuilder();

    private String carName;
    private int position;


    public Car(String carName) {
        checkEmptyCarName(carName);
        checkSmallerThanSix(carName);
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public Car(String carName, int position) {
        checkEmptyCarName(carName);
        checkSmallerThanSix(carName);
        this.carName = carName;
        this.position = position;
    }

    public static void checkEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    public static void checkSmallerThanSix(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차 이름의 길이가 6 이상입니다.");
        }
    }

    public void goOrNot() {
        if (isGo()) {
            position++;
        }
    }

    private boolean isGo() {
        RandomNumber randomNo = new RandomNumber();
        return randomNo.isMovable();
    }

    public boolean comparePosition(Car target) {
        return this.position > target.position;
    }

    public void showCurrentPosition() { // TODO 출력 분리
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
