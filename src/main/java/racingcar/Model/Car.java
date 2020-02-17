package racingcar.Model;

/**
 * 클래스 이름 : Car.java
 *
 * @author 작은곰
 * @version 1.0.2
 * <p>
 * 날짜 : 2020.02.17 월요일
 */

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int CRITERIA_FOR_GO = 4;

    public static StringBuilder winners = new StringBuilder();

    private Name carName;
    private Position position;

    public Car(String carName) {
        this.carName = new Name(carName);
        this.position = new Position();
    }

    public Car(Name carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public void goOrNot(RandomNumber randomNumber) {
        if (randomNumber.getRandomNumber() >= CRITERIA_FOR_GO) {
            position.go();
        }
    }

    public boolean comparePosition(Car target) {
        return this.position.getPosition() > target.position.getPosition();
    }

    public void findWinners(int topPosition) {
        if (this.position.getPosition() == topPosition) {
            winners.append(", ");
            winners.append(this.carName.getName());
        }
    }

    public String getName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
