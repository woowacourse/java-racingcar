package utils;

import java.util.List;
import model.Car;
import view.dto.CarDto;

public class Converter {

    public static List<CarDto> convertCarToCarDtos(List<Car> cars) {
        return cars.stream().map(CarDto::new).toList();
    }
}
