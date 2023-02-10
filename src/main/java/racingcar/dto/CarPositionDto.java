package racingcar.dto;

public class CarPositionDto {

    private final int status;
    private final String carName;

    public CarPositionDto(int status, String carName) {
        this.status = status;
        this.carName = carName;
    }

    public int getStatus() {
        return status;
    }

    public String getCarName() {
        return carName;
    }
}
