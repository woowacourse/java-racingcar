package racingcar.Model;

/**
 * 클래스 이름 : Car.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class Car {
    private static final int INITIAL_POSITION = 0;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int CRITERIA_FOR_GO = 4;

    public static StringBuilder winners = new StringBuilder();

    private Name carName;
    private Position position;

    public Car(String carName) {
        checkEmptyCarName(carName);
        checkSmallerThanSix(carName);
        this.carName = new Name(carName);
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
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름의 길이가 6 이상입니다.");
        }
    }

    public void goOrNot(RandomNumber randomNumber) {
        if (randomNumber.getRandomNumber() >= CRITERIA_FOR_GO) {
            position.go();
        }
    }

    public boolean comparePosition(Car target) {
        return this.position.getPosition() > target.position.getPosition();
    }

    public void findWinners(Car car) {
        if (this.position.getPosition() == car.position.getPosition()) {
            winners.append(", ");
            winners.append(car.carName.getName());
        }
    }

    public String getName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
