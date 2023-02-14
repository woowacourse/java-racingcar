package racingcar.domain.dto;

public class CarStatusDto {

    private final String carName;

    private final int carPosition;

    private CarStatusDto(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarStatusDto create(final String carName, final int carPosition) {
        return new CarStatusDto(carName, carPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
