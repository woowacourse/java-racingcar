package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(String cars) {
        List<String> names = stringToList(cars);
        this.cars = names.stream().map(Car::new).toList();
    }

    private List<String> stringToList(String string) {
        List<String> names = new ArrayList<>();
        for(String name:string.split(",")){
            names.add(name.trim());
        }
        return names;
    }

}
