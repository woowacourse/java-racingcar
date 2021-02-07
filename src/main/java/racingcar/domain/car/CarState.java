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

    @Override
    public String toString() {
        return carName.toString() + " : " + createLines();
    }

    private String createLines() {
        return String.valueOf(new char[position]).replace("\0", LINE);
    }
}