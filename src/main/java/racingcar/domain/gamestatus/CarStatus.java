package racingcar.domain.gamestatus;

import racingcar.domain.GameStatus;

public class CarStatus implements GameStatus {
    private static final String CARS_STATUS_FORMAT = "%s : %s";
    private static final String CARS_POSITION_CHARACTER = "-";

    private final String carName;
    private final int carPosition;

    public CarStatus(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    @Override
    public String showStatus() {
        return CARS_STATUS_FORMAT.formatted(
                carName,
                CARS_POSITION_CHARACTER.repeat(carPosition));
    }

}
