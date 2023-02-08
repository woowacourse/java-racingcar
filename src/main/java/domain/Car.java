package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;

    private final List<String> position;

    public Car(String name) {
        this.name = name;
        this.position = new ArrayList<>();
    }
}
