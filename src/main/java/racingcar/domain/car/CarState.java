package racingcar.domain.car;

public class CarState {
    private static final String LINE = "-";

    private CarName carName;
    private int position;

    private CarState(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public static CarState withNameAndPosition(Car car) {
        return new CarState(car);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}