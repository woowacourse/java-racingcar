package racingcar.domain;

public class CarDto {
    private String carName;
    private int carPosition;

    public CarDto(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
