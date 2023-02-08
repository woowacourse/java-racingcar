package dto;

public class RacingStatusDto {
    private final int status;
    private final String carName;

    public RacingStatusDto(int status, String carName) {
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
