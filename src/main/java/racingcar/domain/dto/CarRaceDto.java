package racingcar.domain.dto;

public class CarRaceDto {

    private final String carName;

    private final int carPosition;

    private CarRaceDto(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarRaceDto createCarRaceDto(final String carName, final int carPosition) {
        return new CarRaceDto(carName, carPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
