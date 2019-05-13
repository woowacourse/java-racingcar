package racingcar.domain;


import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int num) {
        if (Rule.isPossibleMove(num)) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }


    public boolean isSamePosition(Car winner) {
        return this.position == winner.position ? true : false;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    public int compareTo(Car another) {
        if(position == another.position) return 0;
        return position < another.position ? 1 : -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
