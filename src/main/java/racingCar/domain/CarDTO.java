package racingCar.domain;

public class CarDTO {
    public final String name;
    public int position;

    public CarDTO(Car car) {
        this.name = car.name.toString();
        this.position = car.position.get();
    }
}