package racingcar.datatransfer;

public class CarDTO {
    private final String carName;
    private final int carPosition;

    public CarDTO(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
