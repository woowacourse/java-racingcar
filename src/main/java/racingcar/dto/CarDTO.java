package racingcar.dto;

import racingcar.domain.car.Car;

public class CarDTO {

    private String name;
    private int position;

    private CarDTO() {
    }

    public static CarDTO from(Car car) {
        CarDTO dto = new CarDTO();
        dto.name = car.getName();
        dto.position = car.getPosition();
        return dto;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
