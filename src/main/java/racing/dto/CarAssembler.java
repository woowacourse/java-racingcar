package racing.dto;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarAssembler {

    private CarAssembler() {
    }

    public static List<CarDto> writeCarDtos(List<Car> cars) {
        return cars.stream()
                .map(CarAssembler::writeCarDto)
                .collect(Collectors.toList());
    }

    private static CarDto writeCarDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
