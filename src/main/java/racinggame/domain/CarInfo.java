package racinggame.domain;

public record CarInfo(String name, int position) {

    public CarInfo(Car car) {
        this(car.getName(), car.getPosition());
    }
}
