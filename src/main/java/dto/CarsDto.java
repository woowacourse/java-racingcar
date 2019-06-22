package dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarsDto implements Iterable<CarDto> {
    public static final CarsDto EMPTY = new CarsDto(new ArrayList<>());

    private List<CarDto> cars;

    private CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public static CarsDto from(List<CarDto> cars) {
        return new CarsDto(cars);
    }

    public List<CarDto> getCars() {
        return cars;
    }

    @Override
    public Iterator<CarDto> iterator() {
        return cars.iterator();
    }
}
