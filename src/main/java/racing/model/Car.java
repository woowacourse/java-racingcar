package racing.model;


import racing.dto.MovedCar;

import java.util.Objects;

public class Car {
    private static final int BOUNDARY = 4;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public MovedCar move(int randomNumber) {
        if (randomNumber >= BOUNDARY)
            position++;
        return new MovedCar(this.name, this.position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    public int compareTo(Car o2) {
        if (this.position == o2.position) {
            return 0;
        }
        if (this.position > o2.position) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
