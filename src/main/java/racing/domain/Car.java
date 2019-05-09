package racing.domain;

import java.util.Objects;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
}
