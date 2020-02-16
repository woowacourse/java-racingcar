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

    public static StringBuilder winners = new StringBuilder();

    private Name carName;
    private Position position;

    public Car(Name carName) {
        checkEmptyCarName(carName.getName());
        checkSmallerThanSix(carName.getName());
        this.carName = carName;
        this.position = new Position();
    }

    public Car(Name carName, int position) {
        checkEmptyCarName(carName.getName());
        checkSmallerThanSix(carName.getName());
        this.carName = carName;
        this.position = new Position(position);
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
            position.go();
        }
    }

    private boolean isGo() {
        RandomNumber randomNo = new RandomNumber();
        return randomNo.isMovable();
    }

    public boolean comparePosition(Car target) {
        return this.position.getPosition() > target.position.getPosition();
    }

    public void findWinners(Car car) {
        if (this.position == car.position) {
            winners.append(", ");
            winners.append(car.carName);
        }
    }

    public String getName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
