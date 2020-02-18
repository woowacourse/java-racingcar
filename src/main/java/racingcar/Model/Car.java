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
    private static final int CRITERIA_FOR_GO = 4;

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

    public void goOrNot(int randomNumber) {
        if (randomNumber >= CRITERIA_FOR_GO) {
            position.go();
        }
    }

    public boolean comparePosition(Car target) {
        return this.position.getPosition() > target.position.getPosition();
    }

    public boolean isWinner(int topPosition) {
        return this.position.getPosition() == topPosition;
    }

    public String getName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
