package dto;

import domain.Car;

public class Output {

    private final String name;
    private final int position;

    private Output(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Output from(Car car) {
        return new Output(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
