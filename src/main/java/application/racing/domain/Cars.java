package application.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String name) {
        String[] names = name.split(",");
    }
}
