package racingcar.domain.car;

public class CarState {
    private static final String LINE = "-";

    private CarName carName;
    private int position;

    private CarState(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarState withNameAndPosition(CarName carName, int position) {
        return new CarState(carName, position);
    }

    @Override
    public String toString() {
        return carName.toString() + " : " + createLines();
    }

    private String createLines() {
        return String.valueOf(new char[position]).replace("\0", LINE);
    }
}


