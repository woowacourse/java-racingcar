package dto;

import domain.Car;

import java.util.List;

public record ResultDto(List<CarDto> carGroup) {

    public static ResultDto toDto(final List<Car> carGroup) {
        return new ResultDto(carGroup.stream()
                .map(CarDto::toDto)
                .toList());
    }

}
