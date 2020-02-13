package racingcargame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarDto {

    private List<Car> cars;

    public CarDto(List<Car> cars) {

        List<Car> re = new ArrayList<>();
        Iterator<Car> iterator = cars.iterator();

        while (iterator.hasNext()) {
            re.add(new Car(iterator.next()));
        }
        this.cars = re;
    }

    public List<Car> getCar() {
        return cars;
    }


}
