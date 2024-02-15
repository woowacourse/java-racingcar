package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private Integer progress;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.progress = 0;
    }

    public void move(){
        this.progress++;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름의 1~5글자 사이입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.progress, other.progress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

