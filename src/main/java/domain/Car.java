package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Distance distance;
    private final Name name;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name, int distance) {
        return new Car(Name.from(name), Distance.from(distance));
    }

    public static Car fromName(String name) {
        return new Car(Name.from(name), Distance.init());
    }

//    public static Car fromEmpty() { // TODO: 테스트를 위한 부생성자가 발생시킬 수 있는 부작용이 있을까? 없다면 가능하지 않을까?
//        return new Car(Name.empty(), Distance.init());
//    }

    public void move() {
        distance.increase();
    }

    public boolean isSameDistance(Car maxDistance) {
        return distance.isSameDistance(maxDistance.distance);
    }

    @Override
    public int compareTo(Car other) {
        return this.distance.compareTo(other.distance);
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
        return Objects.equals(distance, car.distance) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }

    public Distance getDistance() {
        return distance;
    }

    public Name getName() {
        return name;
    }
}
