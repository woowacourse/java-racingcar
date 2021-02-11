package racing.view.dto;

import racing.domain.Car;

public class CarMoveStatusDto {
    private final CarNameDto carNameDto;
    private final PositionDto position;

    public CarMoveStatusDto(CarNameDto carNameDto, PositionDto position) {
        this.carNameDto = carNameDto;
        this.position = position;
    }

    public static CarMoveStatusDto of(final Car car) {
        return new CarMoveStatusDto(new CarNameDto(car.getName()), new PositionDto(car.getPositionValue()));
    }

    public CarNameDto getCarNameDto() {
        return carNameDto;
    }

    public PositionDto getPositionDto() {
        return position;
    }
}
